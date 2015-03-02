package sk.posta.boc.ispep;

import sk.posta.data.Predpis;

public interface ExportPredpis {
	public void exportPredpis(Predpis p);
	public void checkConnection();
	public void checkEnums(boolean force);
}
