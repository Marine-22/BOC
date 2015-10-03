
package sk.gov.ekolky.estamp.fo10.estamp;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.CreditNote;
import sk.gov.ekolky.estamp.xsd10.Estamp;
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
 *         &lt;element name="estamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}estamp"/>
 *         &lt;element name="creditNote" type="{http://www.ekolky.gov.sk/estamp/xsd10}creditNote" minOccurs="0"/>
 *         &lt;element name="assessment" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *                   &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "estamp",
    "creditNote",
    "assessment"
})
@XmlRootElement(name = "createRequest")
public class CreateRequest
    extends RequestOEK
{

    @XmlElement(required = true)
    protected Estamp estamp;
    protected CreditNote creditNote;
    protected CreateRequest.Assessment assessment;

    /**
     * Gets the value of the estamp property.
     * 
     * @return
     *     possible object is
     *     {@link Estamp }
     *     
     */
    public Estamp getEstamp() {
        return estamp;
    }

    /**
     * Sets the value of the estamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Estamp }
     *     
     */
    public void setEstamp(Estamp value) {
        this.estamp = value;
    }

    /**
     * Gets the value of the creditNote property.
     * 
     * @return
     *     possible object is
     *     {@link CreditNote }
     *     
     */
    public CreditNote getCreditNote() {
        return creditNote;
    }

    /**
     * Sets the value of the creditNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditNote }
     *     
     */
    public void setCreditNote(CreditNote value) {
        this.creditNote = value;
    }

    /**
     * Gets the value of the assessment property.
     * 
     * @return
     *     possible object is
     *     {@link CreateRequest.Assessment }
     *     
     */
    public CreateRequest.Assessment getAssessment() {
        return assessment;
    }

    /**
     * Sets the value of the assessment property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateRequest.Assessment }
     *     
     */
    public void setAssessment(CreateRequest.Assessment value) {
        this.assessment = value;
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
     *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "order"
    })
    public static class Assessment {

        protected Key key;
        protected BigInteger order;

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
         * Gets the value of the order property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOrder() {
            return order;
        }

        /**
         * Sets the value of the order property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOrder(BigInteger value) {
            this.order = value;
        }

    }

}
