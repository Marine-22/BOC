package sk.posta.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	
	public Predpis(MultiValueMap<String, String> data) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(Predpis.SIMPLE_DATE);
		this.doklad = data.get("doklad").get(0);
		this.konanie = data.get("konanie").get(0);
		this.sluzba = data.get("sluzba").get(0);
		this.datum = sdf.parse(data.get("datum").get(0)).getTime();
		this.urad = data.get("urad").get(0);
		this.poradove = data.get("poradove").get(0);
		idnom = new ArrayList<String>();
		for(String idNom : data.get("idnom[]")){
			this.idnom.add(idNom);
		}
		this.stav = PredpisStav.LOADED;
	}
	
	@Id
	@JsonIgnore
	private String id;
	private String doklad;
	private String konanie;
	private String sluzba;
	private Long datum;
	private String urad;
	private String poradove;
	private List<String> idnom;
	private PredpisStav stav;
	private String errorMsg;
	private String idZamLogin;
	
	@Transient
	private String fullName;
	@Transient
	private String uradName;
	@Transient
	private String sluzbaName;
	
	
	public String toString(){
		return "Predpis: doklad=" + doklad + "; konanie=" + konanie + "; sluzba=" + sluzba + "; datum: "+datum + "; pocetId=" + (idnom == null ? 0 : (idnom.size()  + "; idnom: " + idnom));
	}
	
	public String getDoklad() {
		return doklad;
	}
	public void setDoklad(String doklad) {
		this.doklad = doklad;
	}
	public String getKonanie() {
		return konanie;
	}
	public void setKonanie(String konanie) {
		this.konanie = konanie;
	}
	public String getSluzba() {
		return sluzba;
	}
	public void setSluzba(String sluzba) {
		this.sluzba = sluzba;
	}
	public Long getDatum() {
		return datum;
	}
	public void setDatum(Long datum) {
		this.datum = datum;
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
}
