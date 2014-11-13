
package sk.gov.ekolky.estamp.fo10.estamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.CreditNote;
import sk.gov.ekolky.estamp.xsd10.Estamp;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.RequestFE;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestFE">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="estamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}estamp"/>
 *         &lt;element name="creditNote" type="{http://www.ekolky.gov.sk/estamp/xsd10}creditNote" minOccurs="0"/>
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
    "key",
    "estamp",
    "creditNote"
})
@XmlRootElement(name = "exchangeRequest")
public class ExchangeRequest
    extends RequestFE
{

    @XmlElement(required = true)
    protected Key key;
    @XmlElement(required = true)
    protected Estamp estamp;
    protected CreditNote creditNote;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setKey(Key value) {
        this.key = value;
    }

    /**
     * Gets the value of the estamp property.
     * 
     * @return
     *     possible object is
     *     {@link Estamp }
     *     
     */
    public Estamp getEstamp() {
        return estamp;
    }

    /**
     * Sets the value of the estamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Estamp }
     *     
     */
    public void setEstamp(Estamp value) {
        this.estamp = value;
    }

    /**
     * Gets the value of the creditNote property.
     * 
     * @return
     *     possible object is
     *     {@link CreditNote }
     *     
     */
    public CreditNote getCreditNote() {
        return creditNote;
    }

    /**
     * Sets the value of the creditNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditNote }
     *     
     */
    public void setCreditNote(CreditNote value) {
        this.creditNote = value;
    }

}
