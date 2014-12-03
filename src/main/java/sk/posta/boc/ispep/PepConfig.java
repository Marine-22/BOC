package sk.posta.boc.ispep;


/**
 * Nastavenia ohladom pripojenia na PEP su v anotaciach vramci tried. Preto nemozu byt v .properties
 * ale ako konstanty v kode.
 * Zmena nastaveni si vyzaduje redeploy aplikacie.
 * @author fmo
 *
 */
public class PepConfig {

	public static final String URL = "http://10.168.10.50:9080/estamp/soa/server/r1_2.wsdl";
	public static final String WSDL_LOCATION = "http://10.168.10.50:9080/estamp/soa/server/r1_2.wsdl";
	public static final String TARGET_NAMESPACE = "http://www.ekolky.gov.sk/estamp/fo10";
	public static final String QNAME_URI = "http://www.ekolky.gov.sk/estamp/fo10";
	public static final int initialDelayPredpis = 1000;
	public static final int initialDelaySluzbyUrady = 1000000;
	
	
}
