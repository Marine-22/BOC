
package sk.gov.ekolky.estamp.fo10.cashdesk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.Operation;
import sk.gov.ekolky.estamp.xsd10.Response;
import sk.gov.ekolky.estamp.xsd10.State;
import sk.gov.ekolky.estamp.xsd10.User;


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
 *         &lt;element name="state" type="{http://www.ekolky.gov.sk/estamp/xsd10}state" minOccurs="0"/>
 *         &lt;element name="user" type="{http://www.ekolky.gov.sk/estamp/xsd10}user" minOccurs="0"/>
 *         &lt;element name="amountCash" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="amountCard" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="openAmountCash" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="openAmountCard" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="lastOpenDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastCloseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastSendDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentCashCountOpen" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paymentCashCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paymentCardCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="moneySendSPAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="moneySendSPCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payments" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *                   &lt;element name="payment" type="{http://www.ekolky.gov.sk/estamp/xsd10}operation" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "state",
    "user",
    "amountCash",
    "amountCard",
    "openAmountCash",
    "openAmountCard",
    "lastOpenDate",
    "lastCloseDate",
    "lastSendDate",
    "paymentCashCountOpen",
    "paymentCashCount",
    "paymentCardCount",
    "moneySendSPAmount",
    "moneySendSPCount",
    "terminalID",
    "payments"
})
@XmlRootElement(name = "takeoverResponse")
public class TakeoverResponse
    extends Response
{

    protected State state;
    protected User user;
    protected BigDecimal amountCash;
    protected BigDecimal amountCard;
    protected BigDecimal openAmountCash;
    protected BigDecimal openAmountCard;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastOpenDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastCloseDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastSendDate;
    protected Long paymentCashCountOpen;
    protected Long paymentCashCount;
    protected Long paymentCardCount;
    protected BigDecimal moneySendSPAmount;
    protected BigDecimal moneySendSPCount;
    protected String terminalID;
    protected List<TakeoverResponse.Payments> payments;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link State }
     *     
     */
    public State getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link State }
     *     
     */
    public void setState(State value) {
        this.state = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the amountCash property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountCash() {
        return amountCash;
    }

    /**
     * Sets the value of the amountCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountCash(BigDecimal value) {
        this.amountCash = value;
    }

    /**
     * Gets the value of the amountCard property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountCard() {
        return amountCard;
    }

    /**
     * Sets the value of the amountCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountCard(BigDecimal value) {
        this.amountCard = value;
    }

    /**
     * Gets the value of the openAmountCash property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpenAmountCash() {
        return openAmountCash;
    }

    /**
     * Sets the value of the openAmountCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpenAmountCash(BigDecimal value) {
        this.openAmountCash = value;
    }

    /**
     * Gets the value of the openAmountCard property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpenAmountCard() {
        return openAmountCard;
    }

    /**
     * Sets the value of the openAmountCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpenAmountCard(BigDecimal value) {
        this.openAmountCard = value;
    }

    /**
     * Gets the value of the lastOpenDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastOpenDate() {
        return lastOpenDate;
    }

    /**
     * Sets the value of the lastOpenDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastOpenDate(XMLGregorianCalendar value) {
        this.lastOpenDate = value;
    }

    /**
     * Gets the value of the lastCloseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastCloseDate() {
        return lastCloseDate;
    }

    /**
     * Sets the value of the lastCloseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastCloseDate(XMLGregorianCalendar value) {
        this.lastCloseDate = value;
    }

    /**
     * Gets the value of the lastSendDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastSendDate() {
        return lastSendDate;
    }

    /**
     * Sets the value of the lastSendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastSendDate(XMLGregorianCalendar value) {
        this.lastSendDate = value;
    }

    /**
     * Gets the value of the paymentCashCountOpen property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentCashCountOpen() {
        return paymentCashCountOpen;
    }

    /**
     * Sets the value of the paymentCashCountOpen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentCashCountOpen(Long value) {
        this.paymentCashCountOpen = value;
    }

    /**
     * Gets the value of the paymentCashCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentCashCount() {
        return paymentCashCount;
    }

    /**
     * Sets the value of the paymentCashCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentCashCount(Long value) {
        this.paymentCashCount = value;
    }

    /**
     * Gets the value of the paymentCardCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentCardCount() {
        return paymentCardCount;
    }

    /**
     * Sets the value of the paymentCardCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentCardCount(Long value) {
        this.paymentCardCount = value;
    }

    /**
     * Gets the value of the moneySendSPAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneySendSPAmount() {
        return moneySendSPAmount;
    }

    /**
     * Sets the value of the moneySendSPAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneySendSPAmount(BigDecimal value) {
        this.moneySendSPAmount = value;
    }

    /**
     * Gets the value of the moneySendSPCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneySendSPCount() {
        return moneySendSPCount;
    }

    /**
     * Sets the value of the moneySendSPCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneySendSPCount(BigDecimal value) {
        this.moneySendSPCount = value;
    }

    /**
     * Gets the value of the terminalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    /**
     * Gets the value of the payments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TakeoverResponse.Payments }
     * 
     * 
     */
    public List<TakeoverResponse.Payments> getPayments() {
        if (payments == null) {
            payments = new ArrayList<TakeoverResponse.Payments>();
        }
        return this.payments;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
     *         &lt;element name="payment" type="{http://www.ekolky.gov.sk/estamp/xsd10}operation" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "key",
        "payment"
    })
    public static class Payments {

        protected Key key;
        protected Operation payment;

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
         * Gets the value of the payment property.
         * 
         * @return
         *     possible object is
         *     {@link Operation }
         *     
         */
        public Operation getPayment() {
            return payment;
        }

        /**
         * Sets the value of the payment property.
         * 
         * @param value
         *     allowed object is
         *     {@link Operation }
         *     
         */
        public void setPayment(Operation value) {
            this.payment = value;
        }

    }

}
