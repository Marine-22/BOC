
package sk.gov.ekolky.estamp.fo10.nominal;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sk.gov.ekolky.estamp.fo10.nominal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sk.gov.ekolky.estamp.fo10.nominal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckStateResponse }
     * 
     */
    public CheckStateResponse createCheckStateResponse() {
        return new CheckStateResponse();
    }

    /**
     * Create an instance of {@link CheckStateRequest }
     * 
     */
    public CheckStateRequest createCheckStateRequest() {
        return new CheckStateRequest();
    }

}
