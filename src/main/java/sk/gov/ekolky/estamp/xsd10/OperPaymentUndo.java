
package sk.gov.ekolky.estamp.xsd10;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operPaymentUndo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operPaymentUndo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="payType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="cash" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCash" minOccurs="0"/>
 *                   &lt;element name="return" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentReturn" minOccurs="0"/>
 *                   &lt;element name="card" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCard" minOccurs="0"/>
 *                   &lt;element name="eStamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentEStamp" minOccurs="0"/>
 *                   &lt;element name="nominal" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentNominal" minOccurs="0"/>
 *                   &lt;element name="bank" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentBank" minOccurs="0"/>
 *                   &lt;element name="pps" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentPPS" minOccurs="0"/>
 *                   &lt;element name="swpCash" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentSwpCash" minOccurs="0"/>
 *                   &lt;element name="swpCard" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentSwpCard" minOccurs="0"/>
 *                   &lt;element name="maspCard" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCard" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="participantOrder" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operPaymentUndo", propOrder = {
    "amount",
    "payType",
    "participantOrder",
    "info"
})
public class OperPaymentUndo {

    protected float amount;
    protected OperPaymentUndo.PayType payType;
    protected BigInteger participantOrder;
    protected String info;

    /**
     * Gets the value of the amount property.
     * 
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(float value) {
        this.amount = value;
    }

    /**
     * Gets the value of the payType property.
     * 
     * @return
     *     possible object is
     *     {@link OperPaymentUndo.PayType }
     *     
     */
    public OperPaymentUndo.PayType getPayType() {
        return payType;
    }

    /**
     * Sets the value of the payType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperPaymentUndo.PayType }
     *     
     */
    public void setPayType(OperPaymentUndo.PayType value) {
        this.payType = value;
    }

    /**
     * Gets the value of the participantOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParticipantOrder() {
        return participantOrder;
    }

    /**
     * Sets the value of the participantOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParticipantOrder(BigInteger value) {
        this.participantOrder = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
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
     *         &lt;element name="cash" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCash" minOccurs="0"/>
     *         &lt;element name="return" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentReturn" minOccurs="0"/>
     *         &lt;element name="card" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCard" minOccurs="0"/>
     *         &lt;element name="eStamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentEStamp" minOccurs="0"/>
     *         &lt;element name="nominal" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentNominal" minOccurs="0"/>
     *         &lt;element name="bank" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentBank" minOccurs="0"/>
     *         &lt;element name="pps" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentPPS" minOccurs="0"/>
     *         &lt;element name="swpCash" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentSwpCash" minOccurs="0"/>
     *         &lt;element name="swpCard" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentSwpCard" minOccurs="0"/>
     *         &lt;element name="maspCard" type="{http://www.ekolky.gov.sk/estamp/xsd10}operPaymentCard" minOccurs="0"/>
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
        "cash",
        "_return",
        "card",
        "eStamp",
        "nominal",
        "bank",
        "pps",
        "swpCash",
        "swpCard",
        "maspCard"
    })
    public static class PayType {

        protected OperPaymentCash cash;
        @XmlElement(name = "return")
        protected OperPaymentReturn _return;
        protected OperPaymentCard card;
        protected OperPaymentEStamp eStamp;
        protected OperPaymentNominal nominal;
        protected OperPaymentBank bank;
        protected OperPaymentPPS pps;
        protected OperPaymentSwpCash swpCash;
        protected OperPaymentSwpCard swpCard;
        protected OperPaymentCard maspCard;

        /**
         * Gets the value of the cash property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentCash }
         *     
         */
        public OperPaymentCash getCash() {
            return cash;
        }

        /**
         * Sets the value of the cash property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentCash }
         *     
         */
        public void setCash(OperPaymentCash value) {
            this.cash = value;
        }

        /**
         * Gets the value of the return property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentReturn }
         *     
         */
        public OperPaymentReturn getReturn() {
            return _return;
        }

        /**
         * Sets the value of the return property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentReturn }
         *     
         */
        public void setReturn(OperPaymentReturn value) {
            this._return = value;
        }

        /**
         * Gets the value of the card property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentCard }
         *     
         */
        public OperPaymentCard getCard() {
            return card;
        }

        /**
         * Sets the value of the card property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentCard }
         *     
         */
        public void setCard(OperPaymentCard value) {
            this.card = value;
        }

        /**
         * Gets the value of the eStamp property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentEStamp }
         *     
         */
        public OperPaymentEStamp getEStamp() {
            return eStamp;
        }

        /**
         * Sets the value of the eStamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentEStamp }
         *     
         */
        public void setEStamp(OperPaymentEStamp value) {
            this.eStamp = value;
        }

        /**
         * Gets the value of the nominal property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentNominal }
         *     
         */
        public OperPaymentNominal getNominal() {
            return nominal;
        }

        /**
         * Sets the value of the nominal property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentNominal }
         *     
         */
        public void setNominal(OperPaymentNominal value) {
            this.nominal = value;
        }

        /**
         * Gets the value of the bank property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentBank }
         *     
         */
        public OperPaymentBank getBank() {
            return bank;
        }

        /**
         * Sets the value of the bank property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentBank }
         *     
         */
        public void setBank(OperPaymentBank value) {
            this.bank = value;
        }

        /**
         * Gets the value of the pps property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentPPS }
         *     
         */
        public OperPaymentPPS getPps() {
            return pps;
        }

        /**
         * Sets the value of the pps property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentPPS }
         *     
         */
        public void setPps(OperPaymentPPS value) {
            this.pps = value;
        }

        /**
         * Gets the value of the swpCash property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentSwpCash }
         *     
         */
        public OperPaymentSwpCash getSwpCash() {
            return swpCash;
        }

        /**
         * Sets the value of the swpCash property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentSwpCash }
         *     
         */
        public void setSwpCash(OperPaymentSwpCash value) {
            this.swpCash = value;
        }

        /**
         * Gets the value of the swpCard property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentSwpCard }
         *     
         */
        public OperPaymentSwpCard getSwpCard() {
            return swpCard;
        }

        /**
         * Sets the value of the swpCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentSwpCard }
         *     
         */
        public void setSwpCard(OperPaymentSwpCard value) {
            this.swpCard = value;
        }

        /**
         * Gets the value of the maspCard property.
         * 
         * @return
         *     possible object is
         *     {@link OperPaymentCard }
         *     
         */
        public OperPaymentCard getMaspCard() {
            return maspCard;
        }

        /**
         * Sets the value of the maspCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperPaymentCard }
         *     
         */
        public void setMaspCard(OperPaymentCard value) {
            this.maspCard = value;
        }

    }

}
