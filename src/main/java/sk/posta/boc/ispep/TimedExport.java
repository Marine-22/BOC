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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.OperPayment;
import sk.gov.ekolky.estamp.xsd10.OperPaymentNominal;
import sk.gov.ekolky.estamp.xsd10.Operation;
import sk.gov.ekolky.estamp.xsd10.RequestFE;
import sk.gov.ekolky.estamp.xsd10.Service;
import sk.posta.data.ConfigVersion;
import sk.posta.data.Predpis;
import sk.posta.data.Sluzba;
import sk.posta.data.Urad;
import sk.posta.data.enumm.PredpisStav;
import sk.posta.data.repo.ConfigVersionRepository;
import sk.posta.data.repo.PredpisRepository;
import sk.posta.data.repo.SluzbaRepository;
import sk.posta.data.repo.UradRepository;


@org.springframework.stereotype.Service
public class TimedExport implements ExportPredpis{
    
	@Value("#{appProps['app.export.feDeviceId']}") 
	private String feDeviceId;
	
	private String SUFFIX_POTVRDENIA = "suffixPotvrdenia";
	
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
	
	private static final Logger logger = LoggerFactory.getLogger(TimedExport.class.getName());
	
	public void exportPredpis(final Predpis p){
		Runnable r = new Runnable() {
			@Override
			public void run() {
				int cisloPotvrdenia = getCisloPotvrdenia();
				if(exportPredpis(p, cisloPotvrdenia)){
					cisloPotvrdenia++;
					saveIdPotvrdenia(cisloPotvrdenia);
				}
			}
		};
		new Thread(r).start();
	}
	
	public boolean exportPredpis(Predpis p, int cisloPotvrdenia){
		try{
			Sluzba s = sluzbaRepo.findByBusId(p.getSluzba());
			p.setFeeTypeService(s.getFeeType());
			checkPredpis(p);
			uploadPredpis(p, cisloPotvrdenia);
			p.setStav(PredpisStav.PROCESSED);
			predpisRepo.save(p);
			return true;
		} catch(BloxFaultMessage e){
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov.", e);
		} catch (InstantiationException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov.", e);
		} catch (IllegalAccessException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov.", e);
		} catch (DatatypeConfigurationException e) {
			saveExceptioin(p, e);
			logger.info("Chyba pri synchronizacii predpisov.", e);
		}catch(InaccessibleWSDLException e){
			Exception wrapItBaby = new Exception("Chyba pri nadviazaní spojenia s PEP.", e);
			saveExceptioin(p, wrapItBaby);
			logger.info("Chyba pri synchronizacii predpisov.", wrapItBaby);
		}
		return false;
	}
	//com.sun.xml.ws.wsdl.parser.InaccessibleWSDLException: 2 counts of InaccessibleWSDLException.
	//com.sun.xml.ws.wsdl.parser.InaccessibleWSDLException

	
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
			
			int cisloPotvrdenia = getCisloPotvrdenia();
			
			for(Predpis p : lP){
				
					if(exportPredpis(p, cisloPotvrdenia)){
						cisloPotvrdenia++;
					}
			}
			saveIdPotvrdenia(cisloPotvrdenia);
		}
    }
	
	private void saveExceptioin(Predpis p, Exception e){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy' 'HH:mm:ss:' '");
		p.setStav(PredpisStav.ERROR);
		p.setErrorMsg(sdf.format(new Date()) + e.getMessage());
		predpisRepo.save(p);
	}
	
	//fixedRate = 1 den v milisekundach
	@Scheduled(fixedRate=PepConfig.fixedRateSluzbyUrady, initialDelay=PepConfig.initialDelaySluzbyUrady)
	public void checkEnums()
    {
		ConfigVersion cv;
		DeviceStateCheckResponse check = null;
		
		try{
			check = callCheck();
		} catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
			return;
		} catch (DatatypeConfigurationException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
			return;
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
			return;
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii sluzieb a uradov.", e);
			return;
		}
		
		
		SyncStats stats = new SyncStats(check);
		
		
		try{
			
			cv = confRepo.findByName("" + ConfigVersion.ConfigType.SLUZBY);
			stats.sluzbyOldVer = (cv == null ? "null" : cv.getVersion());
			
			// sluzby treba poriesit
			if(cv == null || !check.getServiceVersion().equals(cv.getVersion())){

				List<Service> lServis = callSluzby();
				Set<String> keys = new HashSet<String>();
				
				for(Service sPep : lServis){
					if(sPep.getId() != null){
						keys.add(sPep.getOrder());
						Sluzba sBoc = sluzbaRepo.findByBusId(sPep.getOrder());
						if(sBoc == null){
							stats.incSI();
							sBoc = new Sluzba(sPep.getOrder(), sPep.getName(), sPep.getFeeType());
							sluzbaRepo.save(sBoc);
						}
						// zmenil sa nazov alebo typ poplatku
						else if(!equalsSluzba(sPep, sBoc)){
							logger.info("Zmena z " + sBoc.getName() + " na " + sPep.getName());
							stats.incSU();
							sBoc.setFeeType(sPep.getFeeType());
							sBoc.setName(sPep.getName());
							sluzbaRepo.save(sBoc);
						}
					}
				}
				List<Sluzba> lSluzy = sluzbaRepo.findAll();
				for(Sluzba sBoc : lSluzy){
					if(!keys.contains(sBoc.getBusId())){
						stats.incSD();
						sBoc.setActive(true);
						sluzbaRepo.save(sBoc);
					}
				}
				
				if(cv == null){
					cv = new ConfigVersion("" + ConfigVersion.ConfigType.SLUZBY, check.getServiceVersion());
				}
				else{
					cv.setVersion(check.getServiceVersion());
				}
				// ulozim novu verziu
				confRepo.save(cv);
			}
		}
		catch(DatatypeConfigurationException e){
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		}
		catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii sluzieb.", e);
		}

		
		
		try{
			cv = confRepo.findByName("" + ConfigVersion.ConfigType.URADY);
			stats.uradyOldVer = (cv == null ? "null" : cv.getVersion());
			if(cv == null || !cv.getVersion().equals(check.getOfficeVersion())){

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
					if(!keys.contains(u.getBusId())){
						stats.incUD();
						u.setActive(false);
						uradRepo.save(u);
					}
				}
				
				if(cv == null){
					cv = new ConfigVersion("" + ConfigVersion.ConfigType.URADY, check.getOfficeVersion());
				}
				else{
					cv.setVersion(check.getServiceVersion());
				}
				// nova verzia conf uradov
				confRepo.save(cv);
			}
		} catch(DatatypeConfigurationException e){
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch(BloxFaultMessage e){
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch (InstantiationException e) {
			logger.info("Chyba pri synchronizacii uradov.", e);
		} catch (IllegalAccessException e) {
			logger.info("Chyba pri synchronizacii uradov.", e);
		}
		logger.info(stats.getReport());
    }
	
	private <T extends RequestFE> T getRequest(Class<T> clazz) throws DatatypeConfigurationException, InstantiationException, IllegalAccessException {
		T retVal = clazz.newInstance();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		retVal.setDate(xgc);
		retVal.setFeDeviceID(feDeviceId);
		return retVal;
	}
	
	
	private DeviceStateCheckResponse callCheck() throws DatatypeConfigurationException, InstantiationException, IllegalAccessException, BloxFaultMessage{
		DeviceStateCheckRequest dscrq = getRequest(DeviceStateCheckRequest.class);
		dscrq.setFeDeviceID(feDeviceId);
		
		Infra infra = new Infra();
		InfraPortType ipt = infra.getInfraPort();
		return ipt.deviceStateCheck(dscrq);
	}
	
	private List<Service> callSluzby() throws DatatypeConfigurationException, InstantiationException, IllegalAccessException, BloxFaultMessage{
		ListServiceRequest lsrq = getRequest(ListServiceRequest.class);
		
		Infra infra = new Infra();
		InfraPortType ipt = infra.getInfraPort();
		
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
			logger.info("ZMENA:\n" + sBoc.getName() + "\n" + sPep.getName() + "\n");
			return false;
		}
		if(!sBoc.getFeeType().equals(sPep.getFeeType())){
			logger.info("ZMENA:\n" + sBoc.getFeeType() + "\n" + sPep.getFeeType() + "\n");
			return false;
		}
		return true;
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
		for(String idNom : p.getIdnom()){
			Nominal nom = new Nominal();
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
			CheckStateResponse chsrs = nomPort.checkState(chsrq);
			if("nezaevidovany".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " už bol spotrebovaný");
			}
			else if("nevalidny".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " nie je platný");
			}
			else if("spotrebovany".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " už bol spotrebovaný");
			}
			else if("refundReserve".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " je rezervovaný na refundáciu");
			}
			else if("zaslanyNaRefundaciu".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " bol zaslaný na refundáciu");
			}
			else if("nevyplateny".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " je nevyplatený");
			}
			else if("zaslanyNaRefundZnova".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " bol znova zaslaný na refundáciu");
			}
			else if("refundovany".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " bol refundovaný");
			}
			else if("fraudovany".equals(chsrs.getState())){
				errMsg = addError(errMsg, "Kolok " + idNom + " je fraud");
			}
			else if("nepredany".equals(chsrs.getState())){
				// OK
			}
			else if("vydany".equals(chsrs.getState())){
				// OK
			}
		}
		if(errMsg.length() > 0){
			BloxFaultType bft = new BloxFaultType();
			bft.setError("ERR-00-000");
			throw new BloxFaultMessage(errMsg, bft);
		}
	}
	
	private String addError(String actual, String adding){
		return "".equals(actual) ? adding : (actual + "; " + adding);
	}
	
	private void uploadPredpis(Predpis p, int cisloPotvrdenia) throws 
										DatatypeConfigurationException, 
										InstantiationException, 
										IllegalAccessException, 
										BloxFaultMessage{
		
		CreateRequest requestCreate = getRequest(CreateRequest.class);
		sk.gov.ekolky.estamp.xsd10.Assessment predpis = new sk.gov.ekolky.estamp.xsd10.Assessment();
		predpis.setOfficeID(p.getUrad());
		predpis.setFeeType(AssesmentType.fromValue(p.getFeeTypeService()));
		predpis.setKey(new Key());
		predpis.getKey().setConfirmID(getConfirmId(cisloPotvrdenia));
		predpis.getKey().setIssueDate(getDate(p.getDatum()));
		//predpis.getKey().setVariableSymbol("0987654321");
		
		// pocitam vyslednu sumu = sucet vsetkych kolkov na predpise
		//float cashAmount = getCashAmount(p);
		
		for(String idNom : p.getIdnom()){
			
			Operation operation = new Operation();
			Operation.Type oType = new Operation.Type();
			OperPayment oPay = new OperPayment();
			OperPayment.PayType pType = new OperPayment.PayType();
			OperPaymentNominal nominal = new OperPaymentNominal();
			Key k = new Key();
			
			k.setIssueDate(getDate(p.getDatum()));
			k.setNominalID(idNom);
			
			nominal.setKey(k);
			pType.setNominal(nominal);
			
			// amount vypocitany ako suma nominalov
			oPay.setAmount(getCashAmount(idNom));
			
			oPay.setPayType(pType);
			oType.setPayment(oPay);

			operation.setOperationDate(getDate(p.getDatum()));
			operation.setType(oType);
			
			predpis.getOperations().add(operation);
		}
		requestCreate.setAssessment(predpis);
		
		
		Assessment ass = new Assessment();
		AssessmentPortType apt = ass.getAssessmentPort();
		
		CreateResponse cres = apt.create(requestCreate);
		logger.info("Dokoncenie uploadu. " + cres);
	}
	
	@SuppressWarnings("unused")
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
			retVal += 0.5;
			break;
		case '2':
			retVal += 1;
			break;
		case '3':
			retVal += 2;
			break;
		case '4':
			retVal += 5;
			break;
		case '5':
			retVal += 10;
			break;
		case '6':
			retVal += 20;
			break;
		case '7':
			retVal += 50;
			break;
		case '8':
			retVal += 100;
			break;
		}
		return retVal;
	}
	
	//XXX-YYMMDD-NNNN 
	private String getConfirmId(int cisloPotvrdenia){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		logger.info("getConfirmId vracia: " + feDeviceId + "-" + sdf.format(new Date()) + "-" + String.format("%04d", cisloPotvrdenia));
		return feDeviceId + "-" + sdf.format(new Date()) + "-" + String.format("%04d", cisloPotvrdenia);
	}
	
	
	private int getCisloPotvrdenia(){
		int retVal = 0;
		ConfigVersion conf = confRepo.findByName(SUFFIX_POTVRDENIA);
		if(conf == null){
			retVal = 1;
		}
		else{
			String info = conf.getVersion();
			if(isLastFromToday(info)){ // musim zvysit index
				int last = Integer.parseInt(info.substring(13));
				retVal = last + 1;
			}
			else{ // novy den, index ide od 1
				retVal = 1;
			}
		}
		return retVal;
	}
	
	private void saveIdPotvrdenia(int idPotvrdenia){
		ConfigVersion conf = confRepo.findByName(SUFFIX_POTVRDENIA);
		if(conf == null){
			conf = new ConfigVersion();
			conf.setName(SUFFIX_POTVRDENIA);
			confRepo.save(conf);
		}
		conf.setVersion("" + new Date().getTime() + idPotvrdenia);
		confRepo.save(conf);
	}
	
	private boolean isLastFromToday(String info){
		Calendar cNow = Calendar.getInstance();
		// prvych 13 znakov su milisekundy date
		Calendar cLast = Calendar.getInstance();
		cLast.setTimeInMillis(Long.parseLong(info.substring(0, 13)));
		return ((cNow.get(Calendar.YEAR) == cLast.get(Calendar.YEAR)) &&
				cNow.get(Calendar.DAY_OF_YEAR) == cLast.get(Calendar.DAY_OF_YEAR));
		
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
}

