
package sk.gov.ekolky.estamp.xsd10;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TxsSummry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TxsSummry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TtlNtries" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TtlNetNtryAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CdtDbtInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TtlCdtNtries" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TtlDbtNtries" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "TxsSummry", propOrder = {
    "ttlNtries",
    "ttlCdtNtries",
    "ttlDbtNtries"
})
public class TxsSummry {

    @XmlElement(name = "TtlNtries")
    protected TxsSummry.TtlNtries ttlNtries;
    @XmlElement(name = "TtlCdtNtries")
    protected TxsSummry.TtlCdtNtries ttlCdtNtries;
    @XmlElement(name = "TtlDbtNtries")
    protected TxsSummry.TtlDbtNtries ttlDbtNtries;

    /**
     * Gets the value of the ttlNtries property.
     * 
     * @return
     *     possible object is
     *     {@link TxsSummry.TtlNtries }
     *     
     */
    public TxsSummry.TtlNtries getTtlNtries() {
        return ttlNtries;
    }

    /**
     * Sets the value of the ttlNtries property.
     * 
     * @param value
     *     allowed object is
     *     {@link TxsSummry.TtlNtries }
     *     
     */
    public void setTtlNtries(TxsSummry.TtlNtries value) {
        this.ttlNtries = value;
    }

    /**
     * Gets the value of the ttlCdtNtries property.
     * 
     * @return
     *     possible object is
     *     {@link TxsSummry.TtlCdtNtries }
     *     
     */
    public TxsSummry.TtlCdtNtries getTtlCdtNtries() {
        return ttlCdtNtries;
    }

    /**
     * Sets the value of the ttlCdtNtries property.
     * 
     * @param value
     *     allowed object is
     *     {@link TxsSummry.TtlCdtNtries }
     *     
     */
    public void setTtlCdtNtries(TxsSummry.TtlCdtNtries value) {
        this.ttlCdtNtries = value;
    }

    /**
     * Gets the value of the ttlDbtNtries property.
     * 
     * @return
     *     possible object is
     *     {@link TxsSummry.TtlDbtNtries }
     *     
     */
    public TxsSummry.TtlDbtNtries getTtlDbtNtries() {
        return ttlDbtNtries;
    }

    /**
     * Sets the value of the ttlDbtNtries property.
     * 
     * @param value
     *     allowed object is
     *     {@link TxsSummry.TtlDbtNtries }
     *     
     */
    public void setTtlDbtNtries(TxsSummry.TtlDbtNtries value) {
        this.ttlDbtNtries = value;
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
     *         &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "nbOfNtries",
        "sum"
    })
    public static class TtlCdtNtries {

        @XmlElement(name = "NbOfNtries")
        protected BigInteger nbOfNtries;
        @XmlElement(name = "Sum")
        protected String sum;

        /**
         * Gets the value of the nbOfNtries property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNbOfNtries() {
            return nbOfNtries;
        }

        /**
         * Sets the value of the nbOfNtries property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNbOfNtries(BigInteger value) {
            this.nbOfNtries = value;
        }

        /**
         * Gets the value of the sum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSum() {
            return sum;
        }

        /**
         * Sets the value of the sum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSum(String value) {
            this.sum = value;
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
     *         &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "nbOfNtries",
        "sum"
    })
    public static class TtlDbtNtries {

        @XmlElement(name = "NbOfNtries")
        protected BigInteger nbOfNtries;
        @XmlElement(name = "Sum")
        protected String sum;

        /**
         * Gets the value of the nbOfNtries property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNbOfNtries() {
            return nbOfNtries;
        }

        /**
         * Sets the value of the nbOfNtries property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNbOfNtries(BigInteger value) {
            this.nbOfNtries = value;
        }

        /**
         * Gets the value of the sum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSum() {
            return sum;
        }

        /**
         * Sets the value of the sum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSum(String value) {
            this.sum = value;
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
     *         &lt;element name="NbOfNtries" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Sum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TtlNetNtryAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CdtDbtInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "nbOfNtries",
        "sum",
        "ttlNetNtryAmt",
        "cdtDbtInd"
    })
    public static class TtlNtries {

        @XmlElement(name = "NbOfNtries")
        protected BigInteger nbOfNtries;
        @XmlElement(name = "Sum")
        protected String sum;
        @XmlElement(name = "TtlNetNtryAmt")
        protected String ttlNetNtryAmt;
        @XmlElement(name = "CdtDbtInd")
        protected String cdtDbtInd;

        /**
         * Gets the value of the nbOfNtries property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNbOfNtries() {
            return nbOfNtries;
        }

        /**
         * Sets the value of the nbOfNtries property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNbOfNtries(BigInteger value) {
            this.nbOfNtries = value;
        }

        /**
         * Gets the value of the sum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSum() {
            return sum;
        }

        /**
         * Sets the value of the sum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSum(String value) {
            this.sum = value;
        }

        /**
         * Gets the value of the ttlNetNtryAmt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTtlNetNtryAmt() {
            return ttlNetNtryAmt;
        }

        /**
         * Sets the value of the ttlNetNtryAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTtlNetNtryAmt(String value) {
            this.ttlNetNtryAmt = value;
        }

        /**
         * Gets the value of the cdtDbtInd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCdtDbtInd() {
            return cdtDbtInd;
        }

        /**
         * Sets the value of the cdtDbtInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCdtDbtInd(String value) {
            this.cdtDbtInd = value;
        }

    }

}
