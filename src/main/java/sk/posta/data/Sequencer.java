package sk.posta.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Sequencer {

	@Id
	private String id;
	private Long datum;
	private int sequence;
	
	public Sequencer(){}
	
	public Sequencer(Long datum){
		this.datum = datum;
		this.sequence = 0;
	}
	
	public Sequencer(Long datum, int sequence) {
		this.datum = datum;
		this.sequence = sequence;
	}

	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d = new Date(datum);
		return "Sequencer["+id+"]: datum="+datum+" - "+sdf.format(d)+"; sequence="+sequence+"";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getDatum() {
		return datum;
	}
	public void setDatum(Long datum) {
		this.datum = datum;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	
}
