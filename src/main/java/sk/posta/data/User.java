package sk.posta.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import sk.posta.data.enumm.UserType;


public class User{

	
	@Id
	@JsonIgnore
	private String id;
	// business id
	private String idZamLogin;
	private String meno;
	private String priezvisko;
	@JsonIgnore
	private String heslo;
	@JsonIgnore
	@Transient
	private String repHeslo;
	private UserType userType;
	private boolean active;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdZamLogin() {
		return idZamLogin;
	}
	public void setIdZamLogin(String idZamLogin) {
		this.idZamLogin = idZamLogin;
	}
	public String getMeno() {
		return meno;
	}
	public void setMeno(String meno) {
		this.meno = meno;
	}
	public String getPriezvisko() {
		return priezvisko;
	}
	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}
	public String getHeslo() {
		return heslo;
	}
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	public String getRepHeslo() {
		return repHeslo;
	}
	public void setRepHeslo(String repHeslo) {
		this.repHeslo = repHeslo;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String toString(){
		return "User[id:'"+id+"'; idZamLogin:'"+idZamLogin+"'; meno:'"+meno+"'; priezvisko:'"+priezvisko+"'; heslo:'"+heslo+"'; repHeslo:'"+repHeslo+"'; type:"+ userType +"; active:"+active+"]";
	}
	
	
}
