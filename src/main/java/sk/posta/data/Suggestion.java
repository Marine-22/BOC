package sk.posta.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Data container for search box using autocomplete
 * @author fmo
 *
 */
public class Suggestion {
	
	
	public static final int BUS_ID	= 0;
	public static final int NAME	= 1;
	
	private Suggestion(Urad u, int field){
		this.id = u.getBusId();
		this.name = u.getName();
		switch(field){
		case BUS_ID:
			this.label = u.getBusId();
			break;
		case NAME:
			this.label = u.getName();
			break;
		}
	}
	
	private Suggestion(Sluzba s, int field){
		this.id = s.getBusId();
		this.name = s.getName();
		this.price = s.getSuma();
		switch(field){
		case BUS_ID:
			this.label = s.getBusId();
			break;
		case NAME:
			this.label = s.getName();
			break;
		}
	}
	
	
	public static List<Suggestion> getSuggestionList(List<?> data, int field){
		List<Suggestion> retVal = new ArrayList<Suggestion>();
		for(Object o : data){
			if(o instanceof Sluzba)
				retVal.add(new Suggestion((Sluzba)o, field));
			else if(o instanceof Urad)
				retVal.add(new Suggestion((Urad)o, field));
				
		}
		return retVal;
	}
	
	private String label; // hodnota, ktora sa zobrazil v suggestion liste
	private String id;
	private String name;
	private Double price;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
