
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operPaymentCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operPaymentCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cashDeskID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posTransaction" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sellerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="applicationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operPaymentCard", propOrder = {
    "cashDeskID",
    "posTransaction"
})
public class OperPaymentCard {

    protected String cashDeskID;
    protected OperPaymentCard.PosTransaction posTransaction;

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
     * Gets the value of the posTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link OperPaymentCard.PosTransaction }
     *     
     */
    public OperPaymentCard.PosTransaction getPosTransaction() {
        return posTransaction;
    }

    /**
     * Sets the value of the posTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperPaymentCard.PosTransaction }
     *     
     */
    public void setPosTransaction(OperPaymentCard.PosTransaction value) {
        this.posTransaction = value;
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
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sellerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="applicationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "id",
        "cardNumber",
        "cardType",
        "receiptNumber",
        "authorizationCode",
        "sellerID",
        "terminalID",
        "applicationID",
        "applicationName",
        "response"
    })
    public static class PosTransaction {

        @XmlElement(required = true)
        protected String id;
        @XmlElement(required = true)
        protected String cardNumber;
        @XmlElement(required = true)
        protected String cardType;
        protected String receiptNumber;
        protected String authorizationCode;
        @XmlElement(required = true)
        protected String sellerID;
        @XmlElement(required = true)
        protected String terminalID;
        @XmlElement(required = true)
        protected String applicationID;
        @XmlElement(required = true)
        protected String applicationName;
        @XmlElement(required = true)
        protected String response;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the cardNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardNumber() {
            return cardNumber;
        }

        /**
         * Sets the value of the cardNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardNumber(String value) {
            this.cardNumber = value;
        }

        /**
         * Gets the value of the cardType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardType() {
            return cardType;
        }

        /**
         * Sets the value of the cardType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardType(String value) {
            this.cardType = value;
        }

        /**
         * Gets the value of the receiptNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReceiptNumber() {
            return receiptNumber;
        }

        /**
         * Sets the value of the receiptNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReceiptNumber(String value) {
            this.receiptNumber = value;
        }

        /**
         * Gets the value of the authorizationCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthorizationCode() {
            return authorizationCode;
        }

        /**
         * Sets the value of the authorizationCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthorizationCode(String value) {
            this.authorizationCode = value;
        }

        /**
         * Gets the value of the sellerID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSellerID() {
            return sellerID;
        }

        /**
         * Sets the value of the sellerID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSellerID(String value) {
            this.sellerID = value;
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
         * Gets the value of the applicationID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplicationID() {
            return applicationID;
        }

        /**
         * Sets the value of the applicationID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplicationID(String value) {
            this.applicationID = value;
        }

        /**
         * Gets the value of the applicationName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplicationName() {
            return applicationName;
        }

        /**
         * Sets the value of the applicationName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplicationName(String value) {
            this.applicationName = value;
        }

        /**
         * Gets the value of the response property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResponse() {
            return response;
        }

        /**
         * Sets the value of the response property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResponse(String value) {
            this.response = value;
        }

    }

}
