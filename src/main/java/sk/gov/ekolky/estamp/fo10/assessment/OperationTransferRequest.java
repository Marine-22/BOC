
package sk.gov.ekolky.estamp.fo10.assessment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="keyFrom" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="keyTo" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="documents" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="estampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="nominalKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
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
    "keyFrom",
    "keyTo",
    "amount",
    "documents"
})
@XmlRootElement(name = "operationTransferRequest")
public class OperationTransferRequest
    extends RequestMSP
{

    @XmlElement(required = true)
    protected Key keyFrom;
    @XmlElement(required = true)
    protected Key keyTo;
    protected BigDecimal amount;
    protected OperationTransferRequest.Documents documents;

    /**
     * Gets the value of the keyFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getKeyFrom() {
        return keyFrom;
    }

    /**
     * Sets the value of the keyFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setKeyFrom(Key value) {
        this.keyFrom = value;
    }

    /**
     * Gets the value of the keyTo property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getKeyTo() {
        return keyTo;
    }

    /**
     * Sets the value of the keyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setKeyTo(Key value) {
        this.keyTo = value;
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
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link OperationTransferRequest.Documents }
     *     
     */
    public OperationTransferRequest.Documents getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationTransferRequest.Documents }
     *     
     */
    public void setDocuments(OperationTransferRequest.Documents value) {
        this.documents = value;
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
     *         &lt;element name="estampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="nominalKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
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
        "estampKey",
        "nominalKey"
    })
    public static class Documents {

        protected List<Key> estampKey;
        protected List<Key> nominalKey;

        /**
         * Gets the value of the estampKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the estampKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEstampKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Key }
         * 
         * 
         */
        public List<Key> getEstampKey() {
            if (estampKey == null) {
                estampKey = new ArrayList<Key>();
            }
            return this.estampKey;
        }

        /**
         * Gets the value of the nominalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nominalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNominalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Key }
         * 
         * 
         */
        public List<Key> getNominalKey() {
            if (nominalKey == null) {
                nominalKey = new ArrayList<Key>();
            }
            return this.nominalKey;
        }

    }

}
