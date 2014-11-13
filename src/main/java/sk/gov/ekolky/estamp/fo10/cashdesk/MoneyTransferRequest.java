
package sk.gov.ekolky.estamp.fo10.cashdesk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.RequestSWP;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestSWP">
 *       &lt;sequence>
 *         &lt;element name="cashDeskToID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cashDeskToPin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cashDeskToID",
    "cashDeskToPin"
})
@XmlRootElement(name = "moneyTransferRequest")
public class MoneyTransferRequest
    extends RequestSWP
{

    @XmlElement(required = true)
    protected String cashDeskToID;
    @XmlElement(required = true)
    protected String cashDeskToPin;

    /**
     * Gets the value of the cashDeskToID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashDeskToID() {
        return cashDeskToID;
    }

    /**
     * Sets the value of the cashDeskToID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashDeskToID(String value) {
        this.cashDeskToID = value;
    }

    /**
     * Gets the value of the cashDeskToPin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashDeskToPin() {
        return cashDeskToPin;
    }

    /**
     * Sets the value of the cashDeskToPin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashDeskToPin(String value) {
        this.cashDeskToPin = value;
    }

}
