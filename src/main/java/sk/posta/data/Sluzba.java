package sk.posta.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Sluzba {
	
	public Sluzba(){}
	
	public Sluzba(String busId, String name, String feeType, Double suma){
		this.busId = busId;
		this.name = name;
		this.feeType = feeType;
		this.active = true;
		this.suma = suma;
	}
	
	@Id
	@JsonIgnore
	private String id;
	private String busId;
	private String name;
	private String feeType;
	private Double suma;
	private boolean active;
	
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
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String toString(){
		return "Sluzba[busId="+busId+"; name="+name+"; suma="+suma+"]";
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}
	
	
}
