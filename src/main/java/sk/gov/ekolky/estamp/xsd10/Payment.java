
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creator" type="{http://www.ekolky.gov.sk/estamp/xsd10}user" minOccurs="0"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="type">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="assessmentCredit" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPayment" minOccurs="0"/>
 *                   &lt;element name="transferPEP" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsume" minOccurs="0"/>
 *                   &lt;element name="transferFrom" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
 *                   &lt;element name="transferTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
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
@XmlType(name = "payment", propOrder = {
    "creator",
    "paymentDate",
    "type"
})
public class Payment {

    protected User creator;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDate;
    @XmlElement(required = true)
    protected Payment.Type type;

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
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Payment.Type }
     *     
     */
    public Payment.Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.Type }
     *     
     */
    public void setType(Payment.Type value) {
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
     *         &lt;element name="assessmentCredit" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPayment" minOccurs="0"/>
     *         &lt;element name="transferPEP" type="{http://www.ekolky.gov.sk/estamp/xsd10}operConsume" minOccurs="0"/>
     *         &lt;element name="transferFrom" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
     *         &lt;element name="transferTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" minOccurs="0"/>
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
        "assessmentCredit",
        "transferPEP",
        "transferFrom",
        "transferTo"
    })
    public static class Type {

        protected OperPayment assessmentCredit;
        protected OperConsume transferPEP;
        protected OperExecution transferFrom;
        protected OperExecution transferTo;

        /**
         * Gets the value of the assessmentCredit property.
         * 
         * @return
         *     possible object is
         *     {@link OperPayment }
         *     
         */
        public OperPayment getAssessmentCredit() {
            return assessmentCredit;
        }

        /**
         * Sets the value of the assessmentCredit property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPayment }
         *     
         */
        public void setAssessmentCredit(OperPayment value) {
            this.assessmentCredit = value;
        }

        /**
         * Gets the value of the transferPEP property.
         * 
         * @return
         *     possible object is
         *     {@link OperConsume }
         *     
         */
        public OperConsume getTransferPEP() {
            return transferPEP;
        }

        /**
         * Sets the value of the transferPEP property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperConsume }
         *     
         */
        public void setTransferPEP(OperConsume value) {
            this.transferPEP = value;
        }

        /**
         * Gets the value of the transferFrom property.
         * 
         * @return
         *     possible object is
         *     {@link OperExecution }
         *     
         */
        public OperExecution getTransferFrom() {
            return transferFrom;
        }

        /**
         * Sets the value of the transferFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperExecution }
         *     
         */
        public void setTransferFrom(OperExecution value) {
            this.transferFrom = value;
        }

        /**
         * Gets the value of the transferTo property.
         * 
         * @return
         *     possible object is
         *     {@link OperExecution }
         *     
         */
        public OperExecution getTransferTo() {
            return transferTo;
        }

        /**
         * Sets the value of the transferTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperExecution }
         *     
         */
        public void setTransferTo(OperExecution value) {
            this.transferTo = value;
        }

    }

}
