package sk.posta.boc.ispep;

import java.util.Set;

import sk.posta.data.Predpis;

public interface ExportPredpis {
	public void exportPredpis(Predpis p);
	public void exportPredpisSync(Predpis p);
	public void checkConnection();
	public void checkEnums(boolean force);
	public StringBuffer checkNoms(Set<String> nominals);
}
