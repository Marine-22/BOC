package sk.posta.boc.ispep;

import java.util.List;

import sk.posta.data.Predpis;

public class PredpisList {
	
	public PredpisList(){}
	
	public PredpisList(List<Predpis> l, long totalCount, int page){
		this.l = l;
		this.totalCount = totalCount;
		this.page = page;
	}
	
	private List<Predpis> l;
	private long totalCount;
	private int page;
	
	public List<Predpis> getL() {
		return l;
	}
	public void setL(List<Predpis> l) {
		this.l = l;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
