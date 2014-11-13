package sk.posta.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Urad {
	
	public Urad(){}
	
	public Urad(String busId, String name){
		this.busId = busId;
		this.name = name;
	}
	
	
	@Id
	@JsonIgnore
	private String id;
	private String busId;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString(){
		return "Urad[busId="+busId+"; name="+name+"]";
	}
}
