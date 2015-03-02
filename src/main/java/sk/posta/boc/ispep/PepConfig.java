package sk.posta.boc.ispep;


/**
 * Nastavenia ohladom pripojenia na PEP su v anotaciach vramci tried. Preto nemozu byt v .properties
 * ale ako konstanty v kode.
 * Zmena nastaveni si vyzaduje redeploy aplikacie.
 * @author fmo
 *
 */
public class PepConfig {

	/**
FIX         – 10.172.10.50
TEST      - 10.169.10.50
PROD    - 10.171.10.50
	 */
	
//	////////////////////    DEV    ////////////////////
//	public static final String URL = "http://10.168.10.50:9080/estamp/soa/server/r1_2.wsdl";
//	public static final String WSDL_LOCATION = "http://10.168.10.50:9080/estamp/soa/server/r1_2.wsdl";
//	
//	////////////////////    TEST    ////////////////////
	public static final String URL = "http://10.169.10.50:9080/estamp/soa/server/r1_2.wsdl";
	public static final String WSDL_LOCATION = "http://10.169.10.50:9080/estamp/soa/server/r1_2.wsdl";
//
//	////////////////////    FIX    ////////////////////
//	public static final String URL = "http://10.172.10.50:9080/estamp/soa/server/r1_2.wsdl";
//	public static final String WSDL_LOCATION = "http://10.172.10.50:9080/estamp/soa/server/r1_2.wsdl";
//
//	////////////////////    PROD    ////////////////////
//	public static final String URL = "http://10.171.10.50:9080/estamp/soa/server/r1_2.wsdl";
//	public static final String WSDL_LOCATION = "http://10.171.10.50:9080/estamp/soa/server/r1_2.wsdl";

	
	public static final String TARGET_NAMESPACE = "http://www.ekolky.gov.sk/estamp/fo10";
	public static final String QNAME_URI = "http://www.ekolky.gov.sk/estamp/fo10";

	//public static final int initialDelayPredpis = 1000;
	//public static final int fixedRatePredpis = (1000 * 60 * 60 * 24); // 1 den
	public static final int initialDelayPredpis = Integer.MAX_VALUE; // vypnuta auto sync
	public static final int fixedRatePredpis = Integer.MAX_VALUE; // vypnuta auto sync
	
	
	public static final int initialDelaySluzbyUrady = 1000;
	public static final int fixedRateSluzbyUrady = (1000 * 60 * 60 * 24); // 1 den
}
