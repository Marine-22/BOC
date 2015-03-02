package sk.posta.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class ConfigVersion {

	public ConfigVersion(){}
	
	public ConfigVersion(String name, String version){
		this.name = name;
		this.version = version;
	}
	
	@Id
	private String id;
	private String name;
	private String version;
	private Long datum;
	@Transient
	private Date dateDatum;
	
	public String toString(){
		return "ConfigVersion["+name+":"+version+"]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getDatum() {
		return datum;
	}
	public void setDatum(Long datum) {
		this.datum = datum;
	}
	public Date getDateDatum() {
		return dateDatum;
	}
	public void setDateDatum(Date dateDatum) {
		this.dateDatum = dateDatum;
	}
	
	public void setDateDatum(){
		if(this.datum != null)
			this.dateDatum = new Date(this.datum);
	}


	public enum ConfigType{
		SLUZBY,
		URADY,
		SUFFIX_POTVRDENIA,
		CONN_TEST
	}
	
}
