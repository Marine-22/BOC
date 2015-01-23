package sk.posta.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Urad {
	
	private static final int SPRAVNY=0;
	private static final int SUDNY=1;
	
	
	public Urad(){}
	
	public Urad(String busId, String name){
		this.busId = busId;
		this.name = name;
		this.active = true;
		this.spSu = this.name.toLowerCase().contains("súd") ? SUDNY : SPRAVNY;
	}
	
	
	@Id
	@JsonIgnore
	private String id;
	private String busId;
	private String name;
	private boolean active;
	private int spSu;
	
	public int getSpSu() {
		return spSu;
	}

	public void setSpSu(int spSu) {
		this.spSu = spSu;
	}

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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String toString(){
		return "Urad[busId="+busId+"; name="+name+"]";
	}
}
