
package sk.gov.ekolky.estamp.fo10.assessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Response;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}response">
 *       &lt;sequence>
 *         &lt;element name="pdf" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pdf"
})
@XmlRootElement(name = "print_DELETEDResponse")
public class PrintDELETEDResponse
    extends Response
{

    @XmlElement(required = true)
    protected byte[] pdf;

    /**
     * Gets the value of the pdf property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPdf() {
        return pdf;
    }

    /**
     * Sets the value of the pdf property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPdf(byte[] value) {
        this.pdf = ((byte[]) value);
    }

}
