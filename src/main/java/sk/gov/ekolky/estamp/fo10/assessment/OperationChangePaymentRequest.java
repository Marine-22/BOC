
package sk.gov.ekolky.estamp.fo10.assessment;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.RequestMSP;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestMSP">
 *       &lt;sequence>
 *         &lt;element name="cashDeskID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="operationCash">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="operationCard">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="posTransaction">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="sellerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="applicationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "cashDeskID",
    "key",
    "operationCash",
    "operationCard"
})
@XmlRootElement(name = "operationChangePaymentRequest")
public class OperationChangePaymentRequest
    extends RequestMSP
{

    @XmlElement(required = true)
    protected String cashDeskID;
    @XmlElement(required = true)
    protected Key key;
    @XmlElement(required = true)
    protected OperationChangePaymentRequest.OperationCash operationCash;
    @XmlElement(required = true)
    protected OperationChangePaymentRequest.OperationCard operationCard;

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
     * Gets the value of the operationCash property.
     * 
     * @return
     *     possible object is
     *     {@link OperationChangePaymentRequest.OperationCash }
     *     
     */
    public OperationChangePaymentRequest.OperationCash getOperationCash() {
        return operationCash;
    }

    /**
     * Sets the value of the operationCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationChangePaymentRequest.OperationCash }
     *     
     */
    public void setOperationCash(OperationChangePaymentRequest.OperationCash value) {
        this.operationCash = value;
    }

    /**
     * Gets the value of the operationCard property.
     * 
     * @return
     *     possible object is
     *     {@link OperationChangePaymentRequest.OperationCard }
     *     
     */
    public OperationChangePaymentRequest.OperationCard getOperationCard() {
        return operationCard;
    }

    /**
     * Sets the value of the operationCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationChangePaymentRequest.OperationCard }
     *     
     */
    public void setOperationCard(OperationChangePaymentRequest.OperationCard value) {
        this.operationCard = value;
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
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="posTransaction">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="cardType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    @XmlType(name = "", propOrder = {
        "date",
        "amount",
        "posTransaction"
    })
    public static class OperationCard {

        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar date;
        @XmlElement(required = true)
        protected BigDecimal amount;
        @XmlElement(required = true)
        protected OperationChangePaymentRequest.OperationCard.PosTransaction posTransaction;

        /**
         * Gets the value of the date property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the posTransaction property.
         * 
         * @return
         *     possible object is
         *     {@link OperationChangePaymentRequest.OperationCard.PosTransaction }
         *     
         */
        public OperationChangePaymentRequest.OperationCard.PosTransaction getPosTransaction() {
            return posTransaction;
        }

        /**
         * Sets the value of the posTransaction property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperationChangePaymentRequest.OperationCard.PosTransaction }
         *     
         */
        public void setPosTransaction(OperationChangePaymentRequest.OperationCard.PosTransaction value) {
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
         *         &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            @XmlElement(required = true)
            protected String receiptNumber;
            @XmlElement(required = true)
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
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
        "date",
        "amount"
    })
    public static class OperationCash {

        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar date;
        @XmlElement(required = true)
        protected BigDecimal amount;

        /**
         * Gets the value of the date property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

    }

}
