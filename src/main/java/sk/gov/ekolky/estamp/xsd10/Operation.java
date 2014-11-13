
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for operation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creator" type="{http://www.ekolky.gov.sk/estamp/xsd10}user" minOccurs="0"/>
 *         &lt;element name="operationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="type">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="payment" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPayment" minOccurs="0"/>
 *                   &lt;element name="paymentTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentTo" minOccurs="0"/>
 *                   &lt;element name="transferTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operTransferTo" minOccurs="0"/>
 *                   &lt;element name="transferFrom" type="{http://www.ekolky.gov.sk/estamp/xsd10}operTransferFrom" minOccurs="0"/>
 *                   &lt;element name="consume" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsume" minOccurs="0"/>
 *                   &lt;element name="consumeUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsumeUndo" minOccurs="0"/>
 *                   &lt;element name="refundSend" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
 *                   &lt;element name="refundCancel" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundCancel" minOccurs="0"/>
 *                   &lt;element name="refundDone" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundDone" minOccurs="0"/>
 *                   &lt;element name="expire" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExprire" minOccurs="0"/>
 *                   &lt;element name="expireUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExpireUndo" minOccurs="0"/>
 *                   &lt;element name="application" type="{http://www.ekolky.gov.sk/estamp/xsd10}operApplication" minOccurs="0"/>
 *                   &lt;element name="applicationUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operApplicationUndo" minOccurs="0"/>
 *                   &lt;element name="fraud" type="{http://www.ekolky.gov.sk/estamp/xsd10}operFraud" minOccurs="0"/>
 *                   &lt;element name="fraudUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operFraudUndo" minOccurs="0"/>
 *                   &lt;element name="declare" type="{http://www.ekolky.gov.sk/estamp/xsd10}operDeclare" minOccurs="0"/>
 *                   &lt;element name="declareUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operDeclareUndo" minOccurs="0"/>
 *                   &lt;element name="reserve" type="{http://www.ekolky.gov.sk/estamp/xsd10}operReserve" minOccurs="0"/>
 *                   &lt;element name="reserveUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operReserveUndo" minOccurs="0"/>
 *                   &lt;element name="execution" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
 *                   &lt;element name="cancel" type="{http://www.ekolky.gov.sk/estamp/xsd10}operCancel" minOccurs="0"/>
 *                   &lt;element name="refundReserve" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
 *                   &lt;element name="refundReserveUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
 *                 &lt;/choice>
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
@XmlType(name = "operation", propOrder = {
    "creator",
    "operationDate",
    "type"
})
public class Operation {

    protected User creator;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operationDate;
    @XmlElement(required = true)
    protected Operation.Type type;

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setCreator(User value) {
        this.creator = value;
    }

    /**
     * Gets the value of the operationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperationDate() {
        return operationDate;
    }

    /**
     * Sets the value of the operationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperationDate(XMLGregorianCalendar value) {
        this.operationDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Operation.Type }
     *     
     */
    public Operation.Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operation.Type }
     *     
     */
    public void setType(Operation.Type value) {
        this.type = value;
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
     *       &lt;choice>
     *         &lt;element name="payment" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPayment" minOccurs="0"/>
     *         &lt;element name="paymentTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentTo" minOccurs="0"/>
     *         &lt;element name="transferTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operTransferTo" minOccurs="0"/>
     *         &lt;element name="transferFrom" type="{http://www.ekolky.gov.sk/estamp/xsd10}operTransferFrom" minOccurs="0"/>
     *         &lt;element name="consume" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsume" minOccurs="0"/>
     *         &lt;element name="consumeUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsumeUndo" minOccurs="0"/>
     *         &lt;element name="refundSend" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
     *         &lt;element name="refundCancel" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundCancel" minOccurs="0"/>
     *         &lt;element name="refundDone" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundDone" minOccurs="0"/>
     *         &lt;element name="expire" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExprire" minOccurs="0"/>
     *         &lt;element name="expireUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExpireUndo" minOccurs="0"/>
     *         &lt;element name="application" type="{http://www.ekolky.gov.sk/estamp/xsd10}operApplication" minOccurs="0"/>
     *         &lt;element name="applicationUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operApplicationUndo" minOccurs="0"/>
     *         &lt;element name="fraud" type="{http://www.ekolky.gov.sk/estamp/xsd10}operFraud" minOccurs="0"/>
     *         &lt;element name="fraudUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operFraudUndo" minOccurs="0"/>
     *         &lt;element name="declare" type="{http://www.ekolky.gov.sk/estamp/xsd10}operDeclare" minOccurs="0"/>
     *         &lt;element name="declareUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operDeclareUndo" minOccurs="0"/>
     *         &lt;element name="reserve" type="{http://www.ekolky.gov.sk/estamp/xsd10}operReserve" minOccurs="0"/>
     *         &lt;element name="reserveUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operReserveUndo" minOccurs="0"/>
     *         &lt;element name="execution" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
     *         &lt;element name="cancel" type="{http://www.ekolky.gov.sk/estamp/xsd10}operCancel" minOccurs="0"/>
     *         &lt;element name="refundReserve" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
     *         &lt;element name="refundReserveUndo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operRefundSend" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "payment",
        "paymentTo",
        "transferTo",
        "transferFrom",
        "consume",
        "consumeUndo",
        "refundSend",
        "refundCancel",
        "refundDone",
        "expire",
        "expireUndo",
        "application",
        "applicationUndo",
        "fraud",
        "fraudUndo",
        "declare",
        "declareUndo",
        "reserve",
        "reserveUndo",
        "execution",
        "cancel",
        "refundReserve",
        "refundReserveUndo"
    })
    public static class Type {

        protected OperPayment payment;
        protected OperPaymentTo paymentTo;
        protected OperTransferTo transferTo;
        protected OperTransferFrom transferFrom;
        protected OperConsume consume;
        protected OperConsumeUndo consumeUndo;
        protected OperRefundSend refundSend;
        protected OperRefundCancel refundCancel;
        protected OperRefundDone refundDone;
        protected OperExprire expire;
        protected OperExpireUndo expireUndo;
        protected OperApplication application;
        protected OperApplicationUndo applicationUndo;
        protected OperFraud fraud;
        protected OperFraudUndo fraudUndo;
        protected OperDeclare declare;
        protected OperDeclareUndo declareUndo;
        protected OperReserve reserve;
        protected OperReserveUndo reserveUndo;
        protected OperExecution execution;
        protected OperCancel cancel;
        protected OperRefundSend refundReserve;
        protected OperRefundSend refundReserveUndo;

        /**
         * Gets the value of the payment property.
         * 
         * @return
         *     possible object is
         *     {@link OperPayment }
         *     
         */
        public OperPayment getPayment() {
            return payment;
        }

        /**
         * Sets the value of the payment property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPayment }
         *     
         */
        public void setPayment(OperPayment value) {
            this.payment = value;
        }

        /**
         * Gets the value of the paymentTo property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentTo }
         *     
         */
        public OperPaymentTo getPaymentTo() {
            return paymentTo;
        }

        /**
         * Sets the value of the paymentTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentTo }
         *     
         */
        public void setPaymentTo(OperPaymentTo value) {
            this.paymentTo = value;
        }

        /**
         * Gets the value of the transferTo property.
         * 
         * @return
         *     possible object is
         *     {@link OperTransferTo }
         *     
         */
        public OperTransferTo getTransferTo() {
            return transferTo;
        }

        /**
         * Sets the value of the transferTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperTransferTo }
         *     
         */
        public void setTransferTo(OperTransferTo value) {
            this.transferTo = value;
        }

        /**
         * Gets the value of the transferFrom property.
         * 
         * @return
         *     possible object is
         *     {@link OperTransferFrom }
         *     
         */
        public OperTransferFrom getTransferFrom() {
            return transferFrom;
        }

        /**
         * Sets the value of the transferFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperTransferFrom }
         *     
         */
        public void setTransferFrom(OperTransferFrom value) {
            this.transferFrom = value;
        }

        /**
         * Gets the value of the consume property.
         * 
         * @return
         *     possible object is
         *     {@link OperConsume }
         *     
         */
        public OperConsume getConsume() {
            return consume;
        }

        /**
         * Sets the value of the consume property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperConsume }
         *     
         */
        public void setConsume(OperConsume value) {
            this.consume = value;
        }

        /**
         * Gets the value of the consumeUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperConsumeUndo }
         *     
         */
        public OperConsumeUndo getConsumeUndo() {
            return consumeUndo;
        }

        /**
         * Sets the value of the consumeUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperConsumeUndo }
         *     
         */
        public void setConsumeUndo(OperConsumeUndo value) {
            this.consumeUndo = value;
        }

        /**
         * Gets the value of the refundSend property.
         * 
         * @return
         *     possible object is
         *     {@link OperRefundSend }
         *     
         */
        public OperRefundSend getRefundSend() {
            return refundSend;
        }

        /**
         * Sets the value of the refundSend property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperRefundSend }
         *     
         */
        public void setRefundSend(OperRefundSend value) {
            this.refundSend = value;
        }

        /**
         * Gets the value of the refundCancel property.
         * 
         * @return
         *     possible object is
         *     {@link OperRefundCancel }
         *     
         */
        public OperRefundCancel getRefundCancel() {
            return refundCancel;
        }

        /**
         * Sets the value of the refundCancel property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperRefundCancel }
         *     
         */
        public void setRefundCancel(OperRefundCancel value) {
            this.refundCancel = value;
        }

        /**
         * Gets the value of the refundDone property.
         * 
         * @return
         *     possible object is
         *     {@link OperRefundDone }
         *     
         */
        public OperRefundDone getRefundDone() {
            return refundDone;
        }

        /**
         * Sets the value of the refundDone property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperRefundDone }
         *     
         */
        public void setRefundDone(OperRefundDone value) {
            this.refundDone = value;
        }

        /**
         * Gets the value of the expire property.
         * 
         * @return
         *     possible object is
         *     {@link OperExprire }
         *     
         */
        public OperExprire getExpire() {
            return expire;
        }

        /**
         * Sets the value of the expire property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperExprire }
         *     
         */
        public void setExpire(OperExprire value) {
            this.expire = value;
        }

        /**
         * Gets the value of the expireUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperExpireUndo }
         *     
         */
        public OperExpireUndo getExpireUndo() {
            return expireUndo;
        }

        /**
         * Sets the value of the expireUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperExpireUndo }
         *     
         */
        public void setExpireUndo(OperExpireUndo value) {
            this.expireUndo = value;
        }

        /**
         * Gets the value of the application property.
         * 
         * @return
         *     possible object is
         *     {@link OperApplication }
         *     
         */
        public OperApplication getApplication() {
            return application;
        }

        /**
         * Sets the value of the application property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperApplication }
         *     
         */
        public void setApplication(OperApplication value) {
            this.application = value;
        }

        /**
         * Gets the value of the applicationUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperApplicationUndo }
         *     
         */
        public OperApplicationUndo getApplicationUndo() {
            return applicationUndo;
        }

        /**
         * Sets the value of the applicationUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperApplicationUndo }
         *     
         */
        public void setApplicationUndo(OperApplicationUndo value) {
            this.applicationUndo = value;
        }

        /**
         * Gets the value of the fraud property.
         * 
         * @return
         *     possible object is
         *     {@link OperFraud }
         *     
         */
        public OperFraud getFraud() {
            return fraud;
        }

        /**
         * Sets the value of the fraud property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperFraud }
         *     
         */
        public void setFraud(OperFraud value) {
            this.fraud = value;
        }

        /**
         * Gets the value of the fraudUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperFraudUndo }
         *     
         */
        public OperFraudUndo getFraudUndo() {
            return fraudUndo;
        }

        /**
         * Sets the value of the fraudUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperFraudUndo }
         *     
         */
        public void setFraudUndo(OperFraudUndo value) {
            this.fraudUndo = value;
        }

        /**
         * Gets the value of the declare property.
         * 
         * @return
         *     possible object is
         *     {@link OperDeclare }
         *     
         */
        public OperDeclare getDeclare() {
            return declare;
        }

        /**
         * Sets the value of the declare property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperDeclare }
         *     
         */
        public void setDeclare(OperDeclare value) {
            this.declare = value;
        }

        /**
         * Gets the value of the declareUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperDeclareUndo }
         *     
         */
        public OperDeclareUndo getDeclareUndo() {
            return declareUndo;
        }

        /**
         * Sets the value of the declareUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperDeclareUndo }
         *     
         */
        public void setDeclareUndo(OperDeclareUndo value) {
            this.declareUndo = value;
        }

        /**
         * Gets the value of the reserve property.
         * 
         * @return
         *     possible object is
         *     {@link OperReserve }
         *     
         */
        public OperReserve getReserve() {
            return reserve;
        }

        /**
         * Sets the value of the reserve property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperReserve }
         *     
         */
        public void setReserve(OperReserve value) {
            this.reserve = value;
        }

        /**
         * Gets the value of the reserveUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperReserveUndo }
         *     
         */
        public OperReserveUndo getReserveUndo() {
            return reserveUndo;
        }

        /**
         * Sets the value of the reserveUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperReserveUndo }
         *     
         */
        public void setReserveUndo(OperReserveUndo value) {
            this.reserveUndo = value;
        }

        /**
         * Gets the value of the execution property.
         * 
         * @return
         *     possible object is
         *     {@link OperExecution }
         *     
         */
        public OperExecution getExecution() {
            return execution;
        }

        /**
         * Sets the value of the execution property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperExecution }
         *     
         */
        public void setExecution(OperExecution value) {
            this.execution = value;
        }

        /**
         * Gets the value of the cancel property.
         * 
         * @return
         *     possible object is
         *     {@link OperCancel }
         *     
         */
        public OperCancel getCancel() {
            return cancel;
        }

        /**
         * Sets the value of the cancel property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperCancel }
         *     
         */
        public void setCancel(OperCancel value) {
            this.cancel = value;
        }

        /**
         * Gets the value of the refundReserve property.
         * 
         * @return
         *     possible object is
         *     {@link OperRefundSend }
         *     
         */
        public OperRefundSend getRefundReserve() {
            return refundReserve;
        }

        /**
         * Sets the value of the refundReserve property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperRefundSend }
         *     
         */
        public void setRefundReserve(OperRefundSend value) {
            this.refundReserve = value;
        }

        /**
         * Gets the value of the refundReserveUndo property.
         * 
         * @return
         *     possible object is
         *     {@link OperRefundSend }
         *     
         */
        public OperRefundSend getRefundReserveUndo() {
            return refundReserveUndo;
        }

        /**
         * Sets the value of the refundReserveUndo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperRefundSend }
         *     
         */
        public void setRefundReserveUndo(OperRefundSend value) {
            this.refundReserveUndo = value;
        }

    }

}
