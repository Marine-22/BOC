package sk.posta.boc.ispep;

/*
BLOX ERROR:
      <env:Fault>
         <faultcode>env:Server</faultcode>
         <faultstring>Nominálny kredit nie je v žiadnej emisii: 7777777777</faultstring>
         <faultactor>server/r1_2/assessment/create</faultactor>
         <detail>
            <tns:BloxFaultType>
               <tns:error>ERR-07-003</tns:error>
            </tns:BloxFaultType>
         </detail>

 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;

import com.sun.xml.ws.wsdl.parser.InaccessibleWSDLException;

import sk.gov.ekolky.estamp.fo10.Assessment;
import sk.gov.ekolky.estamp.fo10.AssessmentPortType;
import sk.gov.ekolky.estamp.fo10.BloxFaultMessage;
import sk.gov.ekolky.estamp.fo10.BloxFaultType;
import sk.gov.ekolky.estamp.fo10.Infra;
import sk.gov.ekolky.estamp.fo10.InfraPortType;
import sk.gov.ekolky.estamp.fo10.Nominal;
import sk.gov.ekolky.estamp.fo10.NominalPortType;
import sk.gov.ekolky.estamp.fo10.assessment.CreateRequest;
import sk.gov.ekolky.estamp.fo10.assessment.CreateResponse;
import sk.gov.ekolky.estamp.fo10.infra.DeviceStateCheckRequest;
import sk.gov.ekolky.estamp.fo10.infra.DeviceStateCheckResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListOfficeRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListOfficeResponse.Offices;
import sk.gov.ekolky.estamp.fo10.infra.ListServiceRequest;
import sk.gov.ekolky.estamp.fo10.nominal.CheckStateRequest;
import sk.gov.ekolky.estamp.fo10.nominal.CheckStateResponse;
import sk.gov.ekolky.estamp.xsd10.AssesmentType;
import sk.gov.ekolky.estamp.xsd10.Fee;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.OperDeclare;
import sk.gov.ekolky.estamp.xsd10.OperPayment;
import sk.gov.ekolky.estamp.xsd10.OperPaymentNominal;
import sk.gov.ekolky.estamp.xsd10.OperReserve;
import sk.gov.ekolky.estamp.xsd10.Operation;
import sk.gov.ekolky.estamp.xsd10.RequestFE;
import sk.gov.ekolky.estamp.xsd10.Service;
import sk.gov.ekolky.estamp.xsd10.ServiceUse;
import sk.gov.ekolky.estamp.xsd10.User;
import sk.posta.boc.util.SOAPLoggingHandler;
import sk.posta.data.ConfigVersion;
import sk.posta.data.Predpis;
import sk.posta.data.Sequencer;
import sk.posta.data.Sluzba;
import sk.posta.data.Urad;
import sk.posta.data.enumm.PredpisStav;
import sk.posta.data.repo.ConfigVersionRepository;
import sk.posta.data.repo.PredpisRepository;
import sk.posta.data.repo.SequencerRepository;
import sk.posta.data.repo.SluzbaRepository;
import sk.posta.data.repo.UradRepository;


@org.springframework.stereotype.Service
public class TimedExport implements ExportPredpis{
	
	private static int MAX_TRY_COUNT=1;
    
	@Value("#{appProps['app.export.feDeviceId']}") 
	private String feDeviceId;
	
	@Value("#{appProps['app.sluzba.sprava.default']}") 
	private String defaultSluzbaSpravna;
	@Value("#{appProps['app.sluzba.sud.default']}") 
	private String defaultSluzbaSudna;

	@Value("#{appProps['app.sluzba.sprava.default.text']}") 
	private String defaultSluzbaSpravnaText;
	@Value("#{appProps['app.sluzba.sud.default.text']}") 
	private String defaultSluzbaSudnaText;

	@Value("#{appProps['app.sluzba.sprava.default.feeType']}") 
	private String defaultSluzbaSpravnaFeeType;
	@Value("#{appProps['app.sluzba.sud.default.feeType']}") 
	private String defaultSluzbaSudnaFeeType;
	
	@Value("#{appProps['app.predpis.confirmID.dateFormat']}") 
	private String confirmIdDateFormat; 
	
	@Value("#{appProps['app.logWholeSOAP']}") 
	private String logSOAPenabled;
	
	private static final String ENABLED = "enabled";
	
	private static final String CHECKING = "Kontroluje sa"; 
	
	@Autowired
	private ConfigVersionRepository confRepo;
	@Autowired
	private SluzbaRepository sluzbaRepo;
	@Autowired
	private UradRepository uradRepo;	
	@Autowired
	private PredpisRepository predpisRepo;
	@Autowired
	private MongoOperations customOps;
	@Autowired
	private SequencerRepository seqRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(TimedExport.class.getName());
	
	public void exportPredpis(final Predpis p){
		Runnable r = new Runnable() {
			@Override
			public void run() {
				int cisloPotvrdenia = getNewCisloPotvrdenia(p.getDatumPredaja());
				int noveCislo;
				if((noveCislo = exportPredpis(p, cisloPotvrdenia, (cisloPotvrdenia+MAX_TRY_COUNT))) > 0){
					saveIdPotvrdenia(noveCislo, p.getDatumPredaja());
				}
			}
		};
		new Thread(r).start();
	}
	
	public void exportPredpisSync(Predpis p){

			int cisloPotvrdenia = getNewCisloPotvrdenia(p.getDatumPredaja());
			int noveCislo;
			if((noveCislo = exportPredpis(p, cisloPotvrdenia, (cisloPotvrdenia+MAX_TRY_COUNT))) > 0){
				saveIdPotvrdenia(noveCislo, p.getDatumPredaja());
			}
	}
	
	/**
	 * Exportuje jeden predpis do IS PEP.
	 * @param p
	 * @param cisloPotvrdenia
	 * @return true ak bolo nahranie predpisu uspesne, inak false
	 */
	public int exportPredpis(Predpis p, int cisloPotvrdenia, int maxCislo){
		try{
			if(cisloPotvrdenia == maxCislo){
				throw new Exception("Pocet pokusov synchronizacie predpisu: "+p.toString()+" dosiahol maximum: " + maxCislo);
			}
			Sluzba s = null;
			if(defaultSluzbaSpravna.equals(p.getSluzba())){
				s = new Sluzba(defaultSluzbaSpravna, defaultSluzbaSpravnaText, defaultSluzbaSpravnaFeeType);
			}
			else if(defaultSluzbaSudna.equals(p.getSluzba())){
				s = new Sluzba(defaultSluzbaSudna, defaultSluzbaSudnaText, defaultSluzbaSudnaFeeType);
			}
			else{
				s = sluzbaRepo.findByBusId(p.getSluzba());
			}
			p.setDatumSync(new Date().getTime());
			checkPredpis(p);
			String retVal = uploadPredpis(p, cisloPotvrdenia, s);
			p.setIdPredpisu(retVal);
			p.setStav(PredpisStav.PROCESSED);
			predpisRepo.save(p);
			return cisloPotvrdenia;
			//Chyba pri pridávaní eTicketu do databázy
		} catch(BloxFaultMessage e){
			if(e.getMessage().contains("Pokus o duplicitné zaevidovanie existujúceho eTicketu")){
				logger.info("Pokus o zaevidovanie eTiketu zlyhal, skusim dalsi pokus. Cislo potvrdenia: " + cisloPotvrdenia);
				exportPredpis(p, ++cisloPotvrdenia, maxCislo);
			}
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov. BloxFaultMessage", e);
		} catch (InstantiationException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov. InstantiationException", e);
		} catch (IllegalAccessException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov. IllegalAccessException", e);
		} catch (DatatypeConfigurationException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov. ", e);
		} catch(InaccessibleWSDLException e){
			Exception wrapItBaby = new Exception("Chyba pri nadviazaní spojenia s PEP. InaccessibleWSDLException", e);
			saveExceptioin(p, wrapItBaby);
			logger.info("Chyba pri synchronizacii predpisov.", wrapItBaby);
		} catch(Exception e){
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov.", e);
		}
		return -1;
	}

	
	@SuppressWarnings("unused")
	@Scheduled(fixedRate=PepConfig.fixedRatePredpis, initialDelay=PepConfig.initialDelayPredpis)
	public void exportPredpis()
    {
		if(PepConfig.initialDelayPredpis < Integer.MAX_VALUE){
			BasicQuery bq = new BasicQuery("{stav:\"LOADED\"}");
			List<Predpis> lP = customOps.find(bq, Predpis.class);
	
			Update upd = new Update();
			upd.set("stav", "WAITING");
			customOps.updateMulti(bq, upd, Predpis.class);
			
			for(Predpis p : lP){
					int cisloPotvrdenia = getNewCisloPotvrdenia(p.getDatumPredaja());
					int noveCislo;
					if((noveCislo = exportPredpis(p, cisloPotvrdenia, (cisloPotvrdenia+MAX_TRY_COUNT))) > 0){
						saveIdPotvrdenia(noveCislo, p.getDatumPredaja());
					}
			}
		}
    }
	
	/**
	 * Checks connection to is pep by calling deviceStateCheck
	 */
	@Scheduled(fixedRate=PepConfig.fixedRateCheckConn, initialDelay=PepConfig.initialDelayCheckConn)
	public void checkConnection(){
		ConfigVersion cv = confRepo.findByName("" + ConfigVersion.ConfigType.CONN_TEST);
		if(cv == null){
			cv = new ConfigVersion();
			cv.setName("" + ConfigVersion.ConfigType.CONN_TEST);
		}
		cv.setDatum(new Date().getTime());
		cv.setVersion(CHECKING);
		confRepo.save(cv);
		try{
			cv.setVersion("CHYBA");
			Infra infra = new Infra();
			if(ENABLED.equals(logSOAPenabled)){
				infra.setHandlerResolver(new HandlerResolver() {
					
					@Override
					public List<Handler> getHandlerChain(PortInfo portInfo) {
						List<Handler> retVal = new ArrayList<Handler>();
						retVal.add(new SOAPLoggingHandler());
						return retVal;
					}
				});
			}
			InfraPortType iPort = infra.getInfraPort();
			
			DeviceStateCheckRequest dscrq = getRequest(DeviceStateCheckRequest.class);
			iPort.deviceStateCheck(dscrq);
			cv.setVersion("OK");
		}catch(IllegalAccessException e){
			logger.info("Check connection FAIL " + e.getMessage());
		}catch(InstantiationException e){
			logger.info("Check connection FAIL " + e.getMessage());
		}catch(DatatypeConfigurationException e){
			logger.info("Check connection FAIL " + e.getMessage());
		}catch(BloxFaultMessage e){
			logger.info("Check connection FAIL " + e.getMessage());
		}catch(Exception e){
			logger.info("Check connection FAIL " + e.getMessage());
		}
		confRepo.save(cv);
	}
	
	
	private void saveExceptioin(Predpis p, Exception e){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy' 'HH:mm:ss:' '");
		p.setStav(PredpisStav.ERROR);
		p.setErrorMsg(sdf.format(new Date()) + e.getMessage());
		predpisRepo.save(p);
	}
	
	private synchronized ConfigVersion getVersion(ConfigVersion.ConfigType type){
		ConfigVersion conf = confRepo.findByName("" + type);
		if(conf == null){
			conf = new ConfigVersion("" + type, "N/A");
		}
		return conf;
	}
	
	//fixedRate = 1 den v milisekundach
	@Scheduled(fixedRate=PepConfig.fixedRateSluzbyUrady, initialDelay=PepConfig.initialDelaySluzbyUrady)
	public void checkEnums()
    {
		checkEnums(false);
    }
	
	public void checkEnums(boolean force)
    {
		
		DeviceStateCheckResponse check = null;
		// do funkcie
		ConfigVersion confSluzby = getVersion(ConfigVersion.ConfigType.SLUZBY);
		ConfigVersion confUrady = getVersion(ConfigVersion.ConfigType.URADY);
		if(confSluzby.getVersion().equals(CHECKING) || confUrady.getVersion().equals(CHECKING)){
			return;
		}
		confSluzby.setDatum(new Date().getTime());
		confUrady.setDatum(new Date().getTime());
		String sluzbyVersion = confSluzby.getVersion();
		String uradyVersion = confUrady.getVersion();
		confSluzby.setVersion(CHECKING);
		confUrady.setVersion(CHECKING);
		confRepo.save(confSluzby);
		confRepo.save(confUrady);
		confSluzby.setVersion(sluzbyVersion);
		confUrady.setVersion(uradyVersion);
		
		boolean checkFail = true;
		try{
			check = callCheck(sluzbyVersion, uradyVersion);
			checkFail = false;
		} catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		} catch (DatatypeConfigurationException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		} catch(InaccessibleWSDLException e){
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		} catch(Exception e){
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
		}

		if(checkFail){
			logger.info("Ukladam hodnoty: confSluzby" + confSluzby.getVersion() + "; confUrady" + confUrady.getVersion());
			confRepo.save(confSluzby);
			confRepo.save(confUrady);
			return;
		}
		
		SyncStats stats = new SyncStats(check);
		
		// sluzby
		try{
			checkFail = true;
			stats.sluzbyOldVer = confSluzby.getVersion();
			// sluzby treba poriesit
			if(force || !check.getServiceVersion().equals(confSluzby.getVersion())){
				
				List<Service> lServis = callSluzby();
				Set<String> keys = new HashSet<String>();
				logger.info("lServis.size: " + lServis.size());
				for(Service sPep : lServis){
					logger.info("sPep: '" + print(sPep));
					if(sPep.getId() != null){
						logger.info("Riesim: '" + sPep.getId() + "'");
						keys.add(sPep.getId());
						Sluzba sBoc = sluzbaRepo.findByBusId(sPep.getId());
						if(sBoc == null){
							stats.incSI();
							sBoc = new Sluzba(
									sPep.getId(), 
									sPep.getName(), 
									sPep.getFeeType(), 
									(sPep.getAmount() == null ? null : sPep.getAmount().doubleValue()),
									sPep.getElectronicAmount() == null ? null : sPep.getAmount().doubleValue(),
									sPep.getMultipleMin() == null ? null : sPep.getMultipleMin().intValue(),
									sPep.getMultipleMax() == null ? null : sPep.getMultipleMax().intValue(),
									sPep.isDiscountEnabled() == null ? false : sPep.isDiscountEnabled().booleanValue(),
									sPep.getMin(),
									sPep.getMax()
							);
							sluzbaRepo.save(sBoc);
						}
						else if(!equalsSluzba(sPep, sBoc)){// zmenil sa nazov alebo typ poplatku
							//logger.info("Zmena z " + sBoc.getName() + " na " + sPep.getName());
							stats.incSU();
							sBoc.setFeeType(sPep.getFeeType());
							sBoc.setName(sPep.getName());
							sBoc.setSuma(sPep.getAmount() == null ? null : sPep.getAmount().doubleValue());
							sBoc.setDiscountEnable(sPep.isDiscountEnabled());
							sBoc.setElectronicAmount(sPep.getElectronicAmount() == null ? null : sPep.getElectronicAmount().doubleValue());
							sBoc.setMultipleMax(sPep.getMultipleMax() == null ? null : sPep.getMultipleMax().intValue());
							sBoc.setMultipleMin(sPep.getMultipleMin() == null ? null : sPep.getMultipleMin().intValue());
							sBoc.setActive(true);
							sBoc.setSumaMin(sPep.getMin() == null ? null : sPep.getMin().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							sBoc.setSumaMax(sPep.getMax() == null ? null : sPep.getMax().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
							sluzbaRepo.save(sBoc);
						}
					}
				}
				List<Sluzba> lSluzy = sluzbaRepo.findAll();
				for(Sluzba sBoc : lSluzy){
					if(!keys.contains(sBoc.getBusId()) && sBoc.isActive()){
						logger.info("keys neobsahuju '" + sBoc.getBusId() + "'");
						stats.incSD();
						sBoc.setActive(false);
						sluzbaRepo.save(sBoc);
					}
				}
			}
			confSluzby.setVersion(check.getServiceVersion());
			checkFail = false;
			// sluzby end
		}
		catch(DatatypeConfigurationException e){
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch (Exception e) {
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		}
		if(checkFail){
			confSluzby.setVersion("N/A");
		}
// urady
		try{
			checkFail = true;
			stats.uradyOldVer = confUrady.getVersion();
			if(force || !check.getOfficeVersion().equals(confUrady.getVersion())){

				List<Offices> lOff = callUrady();
				Set<String> keys = new HashSet<String>();
				for(Offices oPep : lOff){
					keys.add(oPep.getCode());
					Urad uBoc = uradRepo.findByBusId(oPep.getCode());
					if(uBoc == null){
						stats.incUI();
						uBoc = new Urad(oPep.getCode(), oPep.getName());
						uradRepo.save(uBoc);
					}
					else if(!equalsUrad(oPep, uBoc)){
						stats.incUU();
						uBoc.setName(oPep.getName());
						uradRepo.save(uBoc);
					}
				}
				
				List<Urad> lUrady = uradRepo.findAll();
				for(Urad u : lUrady){
					if(!keys.contains(u.getBusId()) && u.isActive()){
						stats.incUD();
						u.setActive(false);
						uradRepo.save(u);
					}
				}
				logger.info("Ukladam novu verziu uradov: " + confUrady.getName() + " - " + confUrady.getVersion());
				// nova verzia conf uradov
				confUrady.setDatum(new Date().getTime());
				confRepo.save(confUrady);
			}
			// urady end
			confUrady.setVersion(check.getOfficeVersion());
			checkFail = false;
		} catch(DatatypeConfigurationException e){
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch (Exception e) {
			logger.info("Chyba pri synchronizacii uradov.", e);
		}
		if(checkFail){
			confUrady.setVersion("N/A");
		}
		
		logger.info(stats.getReport());
		logger.info("Aktualne nastavenie verzie sluzieb a uradov: sluzby:" + confSluzby.getVersion() + " urady: " + confUrady.getVersion());
		// ulozim novu verziu
		confRepo.save(confUrady);
		// ulozim novu verziu
		confRepo.save(confSluzby);
		
    }
	
	

	private String print(Service s) {
		StringBuffer sb = new StringBuffer();
		sb.append("id = " + s.getId() + "\n");
		sb.append("order = " + s.getOrder() + "\n");
		sb.append("agendaID = " + s.getAgendaID() + "\n");
		sb.append("name = " + s.getName() + "\n");
		sb.append("extraShortName = " + s.getExtraShortName() + "\n");
		sb.append("amount = " + s.getAmount() + "\n");
		sb.append("electronicAmount = " + s.getElectronicAmount() + "\n");
		sb.append("min = " + s.getMin() + "\n");
		sb.append("max = " + s.getMax() + "\n");
		sb.append("multipleMin = " + s.getMultipleMin() + "\n");
		sb.append("multipleMax = " + s.getMultipleMax() + "\n");
		sb.append("discountEnabled = " + s.isDiscountEnabled() + "\n");
		sb.append("validFrom = " + s.getValidFrom() + "\n");
		sb.append("validTo = " + s.getValidTo() + "\n");
		sb.append("type = " + s.getType() + "\n");
		sb.append("feeType = " + s.getFeeType() + "\n");
		return sb.toString();                  
	}

	private <T extends RequestFE> T getRequest(Class<T> clazz) throws DatatypeConfigurationException, InstantiationException, IllegalAccessException {
		T retVal = clazz.newInstance();
		GregorianCalendar gc = new GregorianCalendar();
		//Calendar c = Calendar.getInstance();
		//c.set(Calendar.MONTH, 8); c.set(Calendar.DAY_OF_MONTH, 2); c.set(Calendar.YEAR, 2014);
		//gc.setTime(c.getTime());
		
		gc.setTime(new Date());
		XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		retVal.setDate(xgc);
		retVal.setFeDeviceID(feDeviceId);
		return retVal;
	}
	
	
	private DeviceStateCheckResponse callCheck(String sluzbyVersion, String uradyVersion) throws DatatypeConfigurationException, InstantiationException, IllegalAccessException, BloxFaultMessage{
		DeviceStateCheckRequest dscrq = getRequest(DeviceStateCheckRequest.class);
		if(!"N/A".equals(sluzbyVersion) && !CHECKING.equals(sluzbyVersion)){
			dscrq.setServiceVersion(sluzbyVersion);
		}
		if(!"N/A".equals(uradyVersion) && !CHECKING.equals(uradyVersion)){
			dscrq.setOfficeVersion(uradyVersion);
		}
		dscrq.setFeDeviceID(feDeviceId);
		
		Infra infra = new Infra();

		if(ENABLED.equals(logSOAPenabled)){
			infra.setHandlerResolver(new HandlerResolver() {
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					List<Handler> retVal = new ArrayList<Handler>();
					retVal.add(new SOAPLoggingHandler());
					return retVal;
				}
			});
		}
		InfraPortType ipt = infra.getInfraPort();
		return ipt.deviceStateCheck(dscrq);
	}
	
	private List<Service> callSluzby() throws DatatypeConfigurationException, InstantiationException, IllegalAccessException, BloxFaultMessage{
		ListServiceRequest lsrq = getRequest(ListServiceRequest.class);
		
		Infra infra = new Infra();
		InfraPortType ipt = infra.getInfraPort();
		logger.info("Calling sluzby: " + lsrq.getFeDeviceID() + " - " + lsrq.getDate());
		return ipt.listService(lsrq).getServices();
	}
	
	private List<Offices> callUrady() throws DatatypeConfigurationException, InstantiationException, IllegalAccessException, BloxFaultMessage{
		ListOfficeRequest lorq = getRequest(ListOfficeRequest.class);
		
		Infra infra = new Infra();
		InfraPortType ipt = infra.getInfraPort();
		
		return ipt.listOffice(lorq).getOffices();
	}
	
	
	private boolean equalsSluzba(Service sPep, Sluzba sBoc){
		if(!sBoc.getName().equals(sPep.getName())){
			logger.info("ZMENA getName:\n" + sBoc.getName() + "\t" + sPep.getName() + "\n");
			return false;
		}
		if(!sBoc.getFeeType().equals(sPep.getFeeType())){
			logger.info("ZMENA getFeeType:\n" + sBoc.getFeeType() + "\t" + sPep.getFeeType() + "\n");
			return false;
		}
		if(!equals(sPep, sBoc)){
			logger.info("ZMENA Amount:\n" + sBoc.getSuma() + "\t" + sPep.getAmount() + "\n");
			return false;
		}
		if(!equals(sPep.isDiscountEnabled(), sBoc.getDiscountEnable())){
			logger.info("ZMENA isDiscountEnabled:\n" + sBoc.getDiscountEnable() + "\t" + sPep.isDiscountEnabled() + "\n");
			return false;
		}
		if(!equals(sPep.getMultipleMin(), sBoc.getMultipleMin())){
			logger.info("ZMENA getMultipleMin:\n" + sBoc.getMultipleMin() + "\t" + sPep.getMultipleMin() + "\n");
			return false;
		}
		if(!equals(sPep.getMultipleMax(), sBoc.getMultipleMax())){
			logger.info("ZMENA getMultipleMax:\n" + sBoc.getMultipleMax() + "\t" + sPep.getMultipleMax() + "\n");
			return false;
		}
		if(!equals(sPep.getElectronicAmount(), sBoc.getElectronicAmount())){
			logger.info("ZMENA getElectronicAmount:\n" + sBoc.getElectronicAmount() + "\t" + sPep.getElectronicAmount() + "\n");
			return false;
		}
		if(!equals(sPep.getMin(), sBoc.getSumaMin())){
			logger.info("ZMENA getMin:\n" + sBoc.getSumaMin() + "\t" + sPep.getMin() + "\n");
			return false;
		}
		if(!equals(sPep.getMax(), sBoc.getSumaMax())){
			logger.info("ZMENA getMax:\n" + sBoc.getSumaMax() + "\t" + sPep.getMax() + "\n");
			return false;
		}
		if(!sBoc.isActive()) return false;
		return true;
	}
	
	private boolean equals(Boolean o1, Boolean o2){
		if(o1 == null && o2 != null) return false;
		if(o2 == null && o1 != null) return false;
		if(o2 == null && o1 == null) return true;
		return o1.equals(o2);
	}
	private boolean equals(BigInteger o1, Integer o2){
		if(o1 == null && o2 != null) return false;
		if(o2 == null && o1 != null) return false;
		if(o2 == null && o1 == null) return true;
		return o1.longValue() == o2.longValue();
	}
	private boolean equals(BigDecimal o1, Double o2){
		if(o1 == null && o2 != null) return false;
		if(o2 == null && o1 != null) return false;
		if(o2 == null && o1 == null) return true;
		return o1.doubleValue() == o2.doubleValue();
	}
	private boolean equals(BigDecimal o1, BigDecimal o2){
		if(o1 == null && o2 != null) return false;
		if(o2 == null && o1 != null) return false;
		if(o2 == null && o1 == null) return true;
		return o1.compareTo(o2) == 0;
	}
	
	private boolean equals(Service sPep, Sluzba sBoc){
		if(sBoc.getSuma() == null && sPep.getAmount() != null) return false;
		if(sBoc.getSuma() != null && sPep.getAmount() == null) return false;
		if(sBoc.getSuma() == null && sPep.getAmount() == null) return true;
		return sBoc.getSuma().doubleValue() == sPep.getAmount().doubleValue();
	}
	
	private boolean equalsUrad(Offices oPep, Urad uBoc){
		if(!uBoc.getName().equals(oPep.getName())){
			return false;
		}
		return true;
	}
	
	private XMLGregorianCalendar getDate(Long time) throws DatatypeConfigurationException{
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date(time));
		XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		return xgc;
	}
	
	private void checkPredpis(Predpis p) throws BloxFaultMessage, IllegalAccessException, InstantiationException, DatatypeConfigurationException{
		String errMsg = "";
		List<String> nomOk = new ArrayList<String>();
		List<String> nomErr = new ArrayList<String>();
		
		for(String idNom : p.getIdnom()){
			Nominal nom = new Nominal();

			if(ENABLED.equals(logSOAPenabled)){
				nom.setHandlerResolver(new HandlerResolver() {
					@Override
					public List<Handler> getHandlerChain(PortInfo portInfo) {
						List<Handler> retVal = new ArrayList<Handler>();
						retVal.add(new SOAPLoggingHandler());
						return retVal;
					}
				});
			}
			NominalPortType nomPort = nom.getNominalPort();
			CheckStateRequest chsrq = getRequest(CheckStateRequest.class);
			Key k = new Key();
			k.setNominalID(idNom);
			chsrq.setKey(k);
/*
Stavy:
nevalidny - nominalID nebolo vygenerovane v emisii
vydany - bol predany
nepredany - nebol predany ani pouzity na uhrade ale je to validne ID nominalu (zatial vraciame nezaevidovany ale bude opravene v najblizsej verzii)
nezaevidovany - bol spotrebovany ale este nedosla informacia o predaji
spotrebovany - predany a aj spotrebovany
refundReserve - predany a rezervovany na refundaciu
zaslanyNaRefundaciu - predany a zaslany na refundaciu
nevyplateny - predany a refundacia nebola vyplatena
zaslanyNaRefundZnova - predany potom zaslany na refundaciu no nevyplateny a nasledne znova zaslany na refundaciu
refundovany - predany a refundacia bola vyplatena
fraudovany - do piatich dni po spotrebe neprisla informacia o predaji
spotrebovat sa daju nominalne kredity len v stave vydany alebo nepredany.
 */
			try{
				CheckStateResponse chsrs = nomPort.checkState(chsrq);
				if("nezaevidovany".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " už bol spotrebovaný");
					nomErr.add(idNom);
				}
				else if("nevalidny".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " nie je platný");
					nomErr.add(idNom);
				}
				else if("spotrebovany".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " už bol spotrebovaný");
					nomErr.add(idNom);
				}
				else if("refundReserve".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " je rezervovaný na refundáciu");
					nomErr.add(idNom);
				}
				else if("zaslanyNaRefundaciu".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " bol zaslaný na refundáciu");
					nomErr.add(idNom);
				}
				else if("nevyplateny".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " je nevyplatený");
					nomErr.add(idNom);
				}
				else if("zaslanyNaRefundZnova".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " bol znova zaslaný na refundáciu");
					nomErr.add(idNom);
				}
				else if("refundovany".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " bol refundovaný");
					nomErr.add(idNom);
				}
				else if("fraudovany".equals(chsrs.getState())){
					errMsg = addError(errMsg, "Kolok " + idNom + " je fraud");
					nomErr.add(idNom);
				}
				else if("nepredany".equals(chsrs.getState())){
					nomOk.add(idNom);
					// OK
				}
				else if("vydany".equals(chsrs.getState())){
					nomOk.add(idNom);
					// OK
				}
			}catch(BloxFaultMessage e){
				errMsg = addError(errMsg, e.getMessage());
				nomErr.add(idNom);
			}
		}
		p.setIdnomOK(nomOk);
		p.setIdnomFAIL(nomErr);
		p.setErrorMsg(errMsg);
		if(nomOk.isEmpty()){
			BloxFaultType bft = new BloxFaultType();
			bft.setError("ERR-00-000");
			throw new BloxFaultMessage("Žiadny nominálny kolok nie je OK. " + errMsg, bft);
		}
	}
	
	private String addError(String actual, String adding){
		return "".equals(actual) ? adding : (actual + "; " + adding);
	}
	
	private String uploadPredpis(Predpis p, int cisloPotvrdenia, Sluzba s) throws 
										DatatypeConfigurationException, 
										InstantiationException, 
										IllegalAccessException, 
										BloxFaultMessage{
		logger.debug("uploadPredpis p = " + p + "; cislo potvrdenia = " + cisloPotvrdenia + "; Sluzba: " + s); 
		CreateRequest requestCreate = getRequest(CreateRequest.class);
		requestCreate.setOfficeID(p.getUrad());
		requestCreate.setInternalUserID(p.getZamId());
		requestCreate.setInternalUserName(p.getZamMeno());
		
		sk.gov.ekolky.estamp.xsd10.Assessment predpis = new sk.gov.ekolky.estamp.xsd10.Assessment();
		String idPotvrdenia = getConfirmId(cisloPotvrdenia, p.getDatumPredaja());
		predpis.setOfficeID(p.getUrad());
		predpis.setFeeType(AssesmentType.fromValue(s.getFeeType()));
		predpis.setProcessNumber(p.getDoklad());// doklad je cislo dokladu/cislo konania (spajalo sa to do jedneho pola)
		predpis.setKey(new Key());
		predpis.getKey().setConfirmID(idPotvrdenia);
		predpis.getKey().setIssueDate(getDate(p.getDatumPredaja()));
		
		predpis.setCreator(new User());
		predpis.getCreator().setFeDeviceID(feDeviceId);
		predpis.getCreator().setInternalUserID(p.getZamId());
		predpis.getCreator().setInternalUserName(p.getZamMeno());
		predpis.setState("vydany");
		
		if(predpis.getFeeType() == AssesmentType.SPRAVNY){
			predpis.getOperations().add(getOperationReserve(p));
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(p.getDatumPredaja());
			c.add(Calendar.DAY_OF_YEAR, 30);
			predpis.setExpirationDate(getDate(c.getTimeInMillis())); // datum predaja + 30 dni
		}
		else if (predpis.getFeeType() == AssesmentType.SUDNY){
			predpis.getOperations().add(getOperationDeclare(p));
			predpis.setExpirationDate(null);
		}
		
		for(String idNom : p.getIdnomOK()){
			predpis.getOperations().add(getOperationPayment(idNom, p.getDatumPredaja()));
		}
		requestCreate.setAssessment(predpis);
		printPredpis(requestCreate);
		Assessment ass = new Assessment();
		// Na logovanie SOA volani
		if(ENABLED.equals(logSOAPenabled)){
			ass.setHandlerResolver(new HandlerResolver() {
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					List<Handler> retVal = new ArrayList<Handler>();
					retVal.add(new SOAPLoggingHandler());
					return retVal;
				}
			});
		}
		// koniec logovania SOA volani
		AssessmentPortType apt = ass.getAssessmentPort();
		CreateResponse cres = apt.create(requestCreate);
		logger.info("Dokoncenie uploadu. " + cres);
		return idPotvrdenia;
	}
	
	private Operation getOperationDeclare(Predpis p) throws DatatypeConfigurationException{
		Operation operation = new Operation();
		operation.setOperationDate(getDate(p.getDatumPredaja()));
		operation.setType(new Operation.Type());
		operation.getType().setDeclare(new OperDeclare());
		operation.getType().getDeclare().setAmount(p.getAmount());
		operation.getType().getDeclare().setMultiple(BigInteger.valueOf(p.getMultiple()));
		operation.getType().getDeclare().setDiscount(BigInteger.valueOf(p.getDiscount()));
		
		//operation.getType().getDeclare().setAmount(s.getSuma().floatValue());
		operation.getType().getDeclare().setUse(new ServiceUse());
		operation.getType().getDeclare().getUse().setOfficeID(p.getUrad());
		operation.getType().getDeclare().getUse().setServiceID(p.getSluzba());
		operation.getType().getDeclare().getUse().setUserID(p.getZamId());
		return operation;
	}
	
	private Operation getOperationReserve(Predpis p) throws DatatypeConfigurationException{
		Operation operation = new Operation();
		operation.setOperationDate(getDate(p.getDatumPredaja()));
		operation.setType(new Operation.Type());
		operation.getType().setReserve(new OperReserve());
		operation.getType().getReserve().setAmount(p.getAmount());
		operation.getType().getReserve().setMultiple(BigInteger.valueOf(p.getMultiple()));
		operation.getType().getReserve().setDiscount(BigInteger.valueOf(p.getDiscount()));
		
		//operation.getType().getReserve().setAmount(s.getSuma().floatValue());
		operation.getType().getReserve().setUse(new ServiceUse());
		operation.getType().getReserve().getUse().setOfficeID(p.getUrad());
		operation.getType().getReserve().getUse().setServiceID(p.getSluzba());
		operation.getType().getReserve().getUse().setUserID(p.getZamId());
		return operation;
	}
	
	private Operation getOperationPayment(String idNom, Long datumSpotreby) throws DatatypeConfigurationException{
		Operation operation = new Operation();
		operation.setOperationDate(getDate(datumSpotreby));
		operation.setType(new Operation.Type());
		operation.getType().setPayment(new OperPayment());
		operation.getType().getPayment().setAmount(getCashAmount(idNom));
		operation.getType().getPayment().setPayType(new OperPayment.PayType());
		operation.getType().getPayment().getPayType().setNominal(new OperPaymentNominal());
		operation.getType().getPayment().getPayType().getNominal().setKey(new Key());
		operation.getType().getPayment().getPayType().getNominal().getKey().setIssueDate(getDate(datumSpotreby));
		operation.getType().getPayment().getPayType().getNominal().getKey().setNominalID(idNom);
		return operation;
	}
	
	private float getCashAmount(Predpis p){
		float retVal = 0;
		for(String idNom : p.getIdnom()){
			retVal += getCashAmount(idNom);
		}
		return retVal;
	}
	
	private float getCashAmount(String idNom){
		float retVal = 0;
		switch(idNom.charAt(0)){
		case '1':
			retVal = 0.5f;
			break;
		case '2':
			retVal = 1;
			break;
		case '3':
			retVal = 3;
			break;
		case '4':
			retVal = 5;
			break;
		case '5':
			retVal = 10;
			break;
		case '6':
			retVal = 20;
			break;
		case '7':
			retVal = 50;
			break;
		case '8':
			retVal = 100;
			break;
		}
		return retVal;
	}
	
	private String getConfirmId(int cisloPotvrdenia, Long datum){
		SimpleDateFormat sdf = new SimpleDateFormat(confirmIdDateFormat);
		logger.info(String.format("%s-%s-%04d",feDeviceId, sdf.format(new Date(datum)), cisloPotvrdenia));
		return   String.format("%s-%s-%04d",feDeviceId, sdf.format(new Date(datum)), cisloPotvrdenia);
	}
	
	private synchronized int getNewCisloPotvrdenia(Long datum){
		Long vynulovany = getVynulovanyDatum(datum);
		Sequencer s = seqRepo.findByDatum(vynulovany);
		if(s == null){
			s = new Sequencer(vynulovany);
			seqRepo.save(s);
		}
		return s.getSequence() + 1;
	}
	
	private synchronized void saveIdPotvrdenia(int cisloPotvrdenia, Long datum){
		Long vynulovany = getVynulovanyDatum(datum);
		Sequencer s = seqRepo.findByDatum(vynulovany);
		s.setSequence(cisloPotvrdenia);
		seqRepo.save(s);
	}
	
	private Long getVynulovanyDatum(Long datum){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(datum);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	
	private class SyncStats{
		SyncStats(DeviceStateCheckResponse check){
			this.sluzbyI = 0;
			this.sluzbyD = 0;
			this.sluzbyU = 0;
			this.uradyI = 0;
			this.uradyD = 0;
			this.uradyU = 0;
			this.sluzbyNewVer = check.getServiceVersion();
			this.uradyNewVer = check.getOfficeVersion();
		}

		int sluzbyI;
		int sluzbyD;
		int sluzbyU;
		int uradyI;
		int uradyD;
		int uradyU;
		
		String sluzbyOldVer;
		String sluzbyNewVer;
		String uradyOldVer;
		String uradyNewVer;
		
		/**
		 * Inserted
		 */
		void incSI(){
			sluzbyI++;
		}
		
		/**
		 * Deleted (Deactivated)
		 */
		void incSD(){
			sluzbyD++;
		}
		
		/**
		 * Updated
		 */
		void incSU(){
			sluzbyU++;
		}
		
		
		/**
		 * Inserted
		 */
		void incUI(){
			uradyI++;
		}
		
		/**
		 * Deleted (Deactivated)
		 */
		void incUD(){
			uradyD++;
		}
		
		/**
		 * Updated
		 */
		void incUU(){
			uradyU++;
		}
		
		String getReport(){
			return "Synchronizacia ukoncena:" + 
				 "\n o Sluzby ["+sluzbyOldVer+" -> "+sluzbyNewVer+"]:" +
				 "\n  - Pridane: " + sluzbyI + 
				 "\n  - Zmazane: " + sluzbyD + 
				 "\n  - Zmenene: " + sluzbyU + 
				 "\n o Urady: ["+uradyOldVer+" -> "+uradyNewVer+"]" + 
				 "\n  - Pridane: " + uradyI + 
				 "\n  - Zmazane: " + uradyD + 
				 "\n  - Zmenene: " + uradyU;
		}
	}
	
	private void printPredpis(CreateRequest cr){
    	String retVal = "CreateRequest:";
    	retVal += "\ndate: " + cr.getDate();
    	retVal += "\nfeDevideID: " + cr.getFeDeviceID();
    	retVal += "\nAssessment.officeId: " + cr.getAssessment().getOfficeID();
    	retVal += "\nAssessment.feeType: " + cr.getAssessment().getFeeType();
    	retVal += "\nAssessment.key.confirmId: " + cr.getAssessment().getKey().getConfirmID();
    	retVal += "\nAssessment.key.issueDate: " + cr.getAssessment().getKey().getIssueDate();
    	for(int i = 0; i < cr.getAssessment().getOperations().size(); i++){
    		if(cr.getAssessment().getOperations().get(i).getType().getPayment() != null){
	    		retVal += "\nAssessment.operation["+i+"].type.payment.amount: " + cr.getAssessment().getOperations().get(i).getType().getPayment().getAmount();
	    		retVal += "\nAssessment.operation["+i+"].type.payment.payType.nominal.key.nominalId: " + cr.getAssessment().getOperations().get(i).getType().getPayment().getPayType().getNominal().getKey().getNominalID();
	    		retVal += "\nAssessment.operation["+i+"].type.payment.payType.nominal.key.issueDate: " + cr.getAssessment().getOperations().get(i).getType().getPayment().getPayType().getNominal().getKey().getIssueDate();
	    		retVal += "\nAssessment.operation["+i+"].operationDate: " + cr.getAssessment().getOperations().get(i).getOperationDate();
    		}
    		if(cr.getAssessment().getOperations().get(i).getType().getDeclare() != null){
    			retVal += "\nAssessment.operation["+i+"].type.declare.amount:" + cr.getAssessment().getOperations().get(i).getType().getDeclare().getAmount();
    			retVal += "\nAssessment.operation["+i+"].type.declare.use.officeId:" + cr.getAssessment().getOperations().get(i).getType().getDeclare().getUse().getOfficeID();
    			retVal += "\nAssessment.operation["+i+"].type.declare.use.serviceId:" + cr.getAssessment().getOperations().get(i).getType().getDeclare().getUse().getServiceID();
    		}
    		if(cr.getAssessment().getOperations().get(i).getType().getReserve() != null){
    			retVal += "\nAssessment.operation["+i+"].type.reserve.amount:" + cr.getAssessment().getOperations().get(i).getType().getReserve().getAmount();
    			retVal += "\nAssessment.operation["+i+"].type.reserve.use.officeId:" + cr.getAssessment().getOperations().get(i).getType().getReserve().getUse().getOfficeID();
    			retVal += "\nAssessment.operation["+i+"].type.reserve.use.serviceId:" + cr.getAssessment().getOperations().get(i).getType().getReserve().getUse().getServiceID();
    		}
    	}
    	logger.info(retVal);
	}
	
	
	@Override
	public StringBuffer checkNoms(Set<String> nominals) {
		StringBuffer retVal = new StringBuffer();
		
		retVal.append("Nominal;State;AgrState;Popis\n");
		logger.info("Pocet nominalov na check: " + nominals.size());
		for(String idNom : nominals){
			try{
				logger.info("Testujem nominal: " + idNom);
				Nominal nom = new Nominal();
				NominalPortType nomPort = nom.getNominalPort();
				CheckStateRequest chsrq = getRequest(CheckStateRequest.class);
				Key k = new Key();
				k.setNominalID(idNom);
				chsrq.setKey(k);
			
				CheckStateResponse chsrs = nomPort.checkState(chsrq);
				retVal.append(idNom + ";" + chsrs.getState() + ";");
				
				if("nezaevidovany".equals(chsrs.getState())){
					retVal.append("NOK;Kolok už bol spotrebovaný");
				}
				else if("nevalidny".equals(chsrs.getState())){
					retVal.append("NOK;Kolok nie je platný");
				}
				else if("spotrebovany".equals(chsrs.getState())){
					retVal.append("NOK;Kolok už bol spotrebovaný");
				}
				else if("refundReserve".equals(chsrs.getState())){
					retVal.append("NOK;Kolok je rezervovaný na refundáciu");
				}
				else if("zaslanyNaRefundaciu".equals(chsrs.getState())){
					retVal.append("NOK;Kolok bol zaslaný na refundáciu");
				}
				else if("nevyplateny".equals(chsrs.getState())){
					retVal.append("NOK;Kolok je nevyplatený");
				}
				else if("zaslanyNaRefundZnova".equals(chsrs.getState())){
					retVal.append("NOK;Kolok bol znova zaslaný na refundáciu");
				}
				else if("refundovany".equals(chsrs.getState())){
					retVal.append("NOK;Kolok bol refundovaný");
				}
				else if("fraudovany".equals(chsrs.getState())){
					retVal.append("NOK;Kolok je fraud");
				}
				else if("nepredany".equals(chsrs.getState())){
					retVal.append("OK;Kolok nebol predany");
					// OK
				}
				else if("vydany".equals(chsrs.getState())){
					retVal.append("OK;Kolok je vydany");
					// OK
				}
			}catch(BloxFaultMessage e){
				logger.info("Chyba BLOX", e);
				retVal.append(idNom + "BloxFault;EX;" + e.getMessage());
			}catch(IllegalAccessException e){
				logger.info("Chyba BLOX", e);
				retVal.append(idNom + "IllegalAccessException;EX;" + e.getMessage());
			}catch(InstantiationException e){
				logger.info("Chyba BLOX", e);
				retVal.append(idNom + "InstantiationException;EX;" + e.getMessage());
			}catch(DatatypeConfigurationException e){
				logger.info("Chyba BLOX", e);
				retVal.append(idNom + "DatatypeConfigurationException;EX;" + e.getMessage());
			}
			retVal.append("\n");
		}
		
		return retVal;
	}
	
}

