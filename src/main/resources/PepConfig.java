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
	
	public static final String URL = "${pepConfig.url}";
	public static final String WSDL_LOCATION = "${pepConfig.wsdlLocation}";

	
	public static final String TARGET_NAMESPACE = "${pepConfig.targetNamespace}";
	public static final String QNAME_URI = "${pepConfig.qNameUri}";

	//public static final int initialDelayPredpis = 1000;
	//public static final int fixedRatePredpis = (1000 * 60 * 60 * 24); // 1 den
	public static final int initialDelayPredpis = Integer.MAX_VALUE; // vypnuta auto sync
	public static final int fixedRatePredpis = Integer.MAX_VALUE; // vypnuta auto sync
	
	
	public static final int initialDelaySluzbyUrady = 1000;
	public static final int fixedRateSluzbyUrady = (1000 * 60 * 60 * 24); // 1 den
}
