
package sk.gov.ekolky.estamp.fo10.aponet;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.RequestOEK;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestOEK">
 *       &lt;sequence>
 *         &lt;element name="dokument">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="eStampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *                   &lt;element name="creditNoteKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *                   &lt;element name="nominalKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "dokument",
    "amount"
})
@XmlRootElement(name = "refundReserveRequest")
public class RefundReserveRequest
    extends RequestOEK
{

    @XmlElement(required = true)
    protected RefundReserveRequest.Dokument dokument;
    @XmlElement(required = true)
    protected BigDecimal amount;

    /**
     * Gets the value of the dokument property.
     * 
     * @return
     *     possible object is
     *     {@link RefundReserveRequest.Dokument }
     *     
     */
    public RefundReserveRequest.Dokument getDokument() {
        return dokument;
    }

    /**
     * Sets the value of the dokument property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundReserveRequest.Dokument }
     *     
     */
    public void setDokument(RefundReserveRequest.Dokument value) {
        this.dokument = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="eStampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
     *         &lt;element name="creditNoteKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
     *         &lt;element name="nominalKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
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
        "eStampKey",
        "creditNoteKey",
        "nominalKey"
    })
    public static class Dokument {

        protected Key eStampKey;
        protected Key creditNoteKey;
        protected Key nominalKey;

        /**
         * Gets the value of the eStampKey property.
         * 
         * @return
         *     possible object is
         *     {@link Key }
         *     
         */
        public Key getEStampKey() {
            return eStampKey;
        }

        /**
         * Sets the value of the eStampKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link Key }
         *     
         */
        public void setEStampKey(Key value) {
            this.eStampKey = value;
        }

        /**
         * Gets the value of the creditNoteKey property.
         * 
         * @return
         *     possible object is
         *     {@link Key }
         *     
         */
        public Key getCreditNoteKey() {
            return creditNoteKey;
        }

        /**
         * Sets the value of the creditNoteKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link Key }
         *     
         */
        public void setCreditNoteKey(Key value) {
            this.creditNoteKey = value;
        }

        /**
         * Gets the value of the nominalKey property.
         * 
         * @return
         *     possible object is
         *     {@link Key }
         *     
         */
        public Key getNominalKey() {
            return nominalKey;
        }

        /**
         * Sets the value of the nominalKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link Key }
         *     
         */
        public void setNominalKey(Key value) {
            this.nominalKey = value;
        }

    }

}
