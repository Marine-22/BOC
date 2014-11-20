package sk.posta.data;

import org.springframework.data.annotation.Id;

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
	
	public enum ConfigType{
		SLUZBY,
		URADY
	}
	
}
