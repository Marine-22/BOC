package sk.posta.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Sluzba {
	
	public Sluzba(){}
	
	// default spravny a sudny poplatok 9997, 9998
	public Sluzba(String busId, String name, String feeType){
		this(busId, name, feeType, 0d, 0d, null, null, false);
	}
	


	public Sluzba(String busId, String name, String feeType, Double suma,
			Double electronicAmount, Integer multipleMin, Integer multipleMax, boolean discEnabled) {
		this.busId = busId;
		this.name = name;
		this.feeType = feeType;
		this.active = true;
		this.suma = suma;
		this.discountEnable = discEnabled;
		this.multipleMax = multipleMax;
		this.multipleMin = multipleMin;
		this.electronicAmount = electronicAmount;
	}

	@Id
	@JsonIgnore
	private String id;
	private String busId;
	private String name;
	private String feeType;
	private Double suma;
	private Boolean discountEnable;
	private Integer multipleMin;
	private Integer multipleMax;
	private Double electronicAmount;
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

	public Boolean getDiscountEnable() {
		return discountEnable;
	}

	public void setDiscountEnable(Boolean discountEnable) {
		this.discountEnable = discountEnable;
	}

	public Integer getMultipleMin() {
		return multipleMin;
	}

	public void setMultipleMin(Integer multipleMin) {
		this.multipleMin = multipleMin;
	}

	public Integer getMultipleMax() {
		return multipleMax;
	}

	public void setMultipleMax(Integer multipleMax) {
		this.multipleMax = multipleMax;
	}

	public Double getElectronicAmount() {
		return electronicAmount;
	}

	public void setElectronicAmount(Double electronicAmount) {
		this.electronicAmount = electronicAmount;
	}
	
	
}
