package sk.posta.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.util.MultiValueMap;

import sk.posta.data.enumm.PredpisStav;


public class Predpis {
	
	private static final String SIMPLE_DATE = "dd.MM.yyyy";

	public Predpis(){}
	
	
	public Predpis(MultiValueMap<String, String> data, String zamMeno, String zamId){
		SimpleDateFormat sdf = new SimpleDateFormat(Predpis.SIMPLE_DATE);
		internaChyba = false;
		String err = "";
		this.doklad = data.get("doklad").get(0);
		//this.konanie = data.get("konanie").get(0);
		this.sluzba = data.get("sluzba").get(0);
		try{
			this.datumPredaja = sdf.parse(data.get("datum").get(0)).getTime();
			if(this.datumPredaja > new Date().getTime()){
				err += "Dátum spotreby je v budúcnosti ["+data.get("datum").get(0)+"];";
				internaChyba = false;
			}
			// datum nesmie byt pred 1.11.2014. Mesiace sa cisluju od 0, preto 10
			Calendar c = Calendar.getInstance();
			c.set(2014, 10, 1); 
			
			if(this.datumPredaja < c.getTimeInMillis()){
				err += "Dátum spotreby je pred 1.11.2014 ["+data.get("datum").get(0)+"];";
				internaChyba = false;
			}
			
		}catch(ParseException e){
			this.datumPredaja = null;// zle zadany datum, co uz
			err += "Zle zadaný dátum spotreby ["+data.get("datum").get(0)+"];";
			internaChyba = true;
		}
		this.urad = data.get("urad").get(0);
		this.poradove = data.get("poradove").get(0);
		this.datumPridania = new Date().getTime();
		this.feeTypeService = data.get("feeType").get(0);
		idnom = new ArrayList<String>();
		for(String idNom : data.get("idnom[]")){
			this.idnom.add(idNom);
		}
		try{
			this.multiple = Integer.parseInt(data.get("multiple").get(0));
		}
		catch(NumberFormatException e){
			this.multiple = null;
			err += "Zle zadaná násobnosť ["+data.get("multiple").get(0)+"];";
			internaChyba = true;
		}
		
		try{
			String sAmount = data.get("amount").get(0);
			sAmount = sAmount.split("€")[0];
			this.amount = Float.parseFloat(sAmount);
		}
		catch(NumberFormatException e){
			this.multiple = null;
			err += "Zle zadaná suma predpisu ["+data.get("amount").get(0)+"];";
			internaChyba = true;
		}

		try{
			this.discount = Integer.parseInt(data.get("discount").get(0));
		}
		catch(NumberFormatException e){
			this.multiple = null;
			err += "Zle zadaný typ zľavy ["+data.get("discount").get(0)+"];";
			internaChyba = true;
		}
		this.zamId = zamId;
		this.zamMeno = zamMeno;
		
		if("".equals(err)){
			this.stav = PredpisStav.LOADED;
		}
		else{
			this.stav = PredpisStav.ERROR;
			this.errorMsg = err;
		}
	}
	
	@Id
	private String id;
	private String doklad;
	//private String konanie;
	private String sluzba;
	private Long datumPredaja; // predaja, zadava pouzivatel v GUI
	private Long datumPridania;
	private Long datumSync;
	private String urad;
	private String poradove;
	private List<String> idnom;
	private List<String> idnomOK;
	private List<String> idnomFAIL;
	private PredpisStav stav;
	private String errorMsg;
	private String idZamLogin;
	private String zamMeno;
	private String zamId;
	private String idPredpisu; //XXX-YYMMDD-NNNN 
	private Integer multiple;
	private Integer discount;
	private Float amount;
	private Boolean internaChyba;
	private Integer dnsfail;
	
	@Transient
	private String fullName;
	@Transient
	private String uradName;
	@Transient
	private String sluzbaName;
	
	/**
	 * Typ poplatky za sluzbu. Moze byt spravny alebo sudny
	 */
	@JsonIgnore
	private String feeTypeService;
	
	
	public String toString(){
		return "Predpis: id="+id+" doklad=" + doklad + "; sluzba=" + sluzba + "; datum: "+datumPredaja + "; pocetId=" + (idnom == null ? 0 : (idnom.size()  + "; idnom: " + idnom));
	}
	
	public String getDoklad() {
		return doklad;
	}
	public void setDoklad(String doklad) {
		this.doklad = doklad;
	}
//	public String getKonanie() {
//		return konanie;
//	}
//	public void setKonanie(String konanie) {
//		this.konanie = konanie;
//	}
	public String getSluzba() {
		return sluzba;
	}
	public void setSluzba(String sluzba) {
		this.sluzba = sluzba;
	}
	public Long getDatumPredaja() {
		return datumPredaja;
	}
	public void setDatumPredaja(Long datumPredaja) {
		this.datumPredaja = datumPredaja;
	}
	public String getUradName() {
		return uradName;
	}
	public void setUradName(String uradName) {
		this.uradName = uradName;
	}
	public String getSluzbaName() {
		return sluzbaName;
	}
	public void setSluzbaName(String sluzbaName) {
		this.sluzbaName = sluzbaName;
	}
	public String getUrad() {
		return urad;
	}
	public void setUrad(String urad) {
		this.urad = urad;
	}
	public String getPoradove() {
		return poradove;
	}
	public void setPoradove(String poradove) {
		this.poradove = poradove;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getIdnom() {
		return idnom;
	}
	public void setIdnom(List<String> idnom) {
		this.idnom = idnom;
	}
	
	public List<String> getIdnomOK() {
		return idnomOK;
	}


	public void setIdnomOK(List<String> idnomOK) {
		this.idnomOK = idnomOK;
	}


	public List<String> getIdnomFAIL() {
		return idnomFAIL;
	}


	public void setIdnomFAIL(List<String> idnomFAIL) {
		this.idnomFAIL = idnomFAIL;
	}


	public String getIdZamLogin() {
		return idZamLogin;
	}
	public void setIdZamLogin(String idZamLogin) {
		this.idZamLogin = idZamLogin;
	}
	public PredpisStav getStav() {
		return stav;
	}
	public void setStav(PredpisStav stav) {
		this.stav = stav;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFeeTypeService() {
		return feeTypeService;
	}
	/**
	 * 
	 * @param feeTypeService String "spravny", "sudny"
	 */
	public void setFeeTypeService(String feeTypeService) {
		this.feeTypeService = feeTypeService;
	}
	public String getIdPredpisu() {
		return idPredpisu;
	}
	public void setIdPredpisu(String idPredpisu) {
		this.idPredpisu = idPredpisu;
	}
	public void setGUIStaff(User u, Urad ur, Sluzba s) {
		if(u != null){
			this.fullName = u.getPriezvisko() + " " + u.getMeno();
		}
		if(ur != null){
			this.uradName = ur.getName();
		}
		if(s != null){
			this.sluzbaName = s.getName();
		}
	}


	public Long getDatumPridania() {
		return datumPridania;
	}


	public void setDatumPridania(Long datumPridania) {
		this.datumPridania = datumPridania;
	}


	public Long getDatumSync() {
		return datumSync;
	}


	public void setDatumSync(Long datumSync) {
		this.datumSync = datumSync;
	}


	public Integer getMultiple() {
		return multiple;
	}


	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}


	public Integer getDiscount() {
		return discount;
	}


	public void setDiscount(Integer discount) {
		this.discount = discount;
	}


	public Float getAmount() {
		return amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
	}


	public Boolean getInternaChyba() {
		return internaChyba;
	}


	public void setInternaChyba(Boolean internaChyba) {
		this.internaChyba = internaChyba;
	}


	public String getZamMeno() {
		return zamMeno;
	}


	public void setZamMeno(String zamMeno) {
		this.zamMeno = zamMeno;
	}


	public String getZamId() {
		return zamId;
	}


	public void setZamId(String zamId) {
		this.zamId = zamId;
	}


	public Integer getDnsfail() {
		return dnsfail;
	}


	public void setDnsfail(Integer dnsfail) {
		this.dnsfail = dnsfail;
	}
	
}
