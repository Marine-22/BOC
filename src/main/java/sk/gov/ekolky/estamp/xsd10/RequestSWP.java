
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.fo10.cashdesk.CloseRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetClosureRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetMoneySendSPRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.ListRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneySendSPRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneyTransferRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.OpenRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.TakeoverRequest;


/**
 * <p>Java class for requestSWP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestSWP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestOEK">
 *       &lt;sequence>
 *         &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cashDeskID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cashDeskPin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestSWP", propOrder = {
    "officeID",
    "cashDeskID",
    "cashDeskPin"
})
@XmlSeeAlso({
    MoneySendSPRequest.class,
    CloseRequest.class,
    ListRequest.class,
    TakeoverRequest.class,
    MoneyTransferRequest.class,
    GetClosureRequest.class,
    GetInfoRequest.class,
    GetMoneySendSPRequest.class,
    OpenRequest.class
})
public class RequestSWP
    extends RequestOEK
{

    @XmlElement(required = true)
    protected String officeID;
    @XmlElement(required = true)
    protected String cashDeskID;
    @XmlElement(required = true)
    protected String cashDeskPin;

    /**
     * Gets the value of the officeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeID() {
        return officeID;
    }

    /**
     * Sets the value of the officeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeID(String value) {
        this.officeID = value;
    }

    /**
     * Gets the value of the cashDeskID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashDeskID() {
        return cashDeskID;
    }

    /**
     * Sets the value of the cashDeskID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashDeskID(String value) {
        this.cashDeskID = value;
    }

    /**
     * Gets the value of the cashDeskPin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashDeskPin() {
        return cashDeskPin;
    }

    /**
     * Sets the value of the cashDeskPin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashDeskPin(String value) {
        this.cashDeskPin = value;
    }

}
