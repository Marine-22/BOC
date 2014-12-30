package sk.posta.boc.ispep;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionTest implements InitializingBean{

	@Autowired
	private ExportPredpis exportPredpis;
	
	public void afterPropertiesSet() throws Exception {
		exportPredpis.checkConnection();
	}
	
}
