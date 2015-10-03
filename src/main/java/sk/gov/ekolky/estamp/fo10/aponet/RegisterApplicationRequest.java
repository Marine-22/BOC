
package sk.gov.ekolky.estamp.fo10.aponet;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Application;
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
 *         &lt;element name="dokuments">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="eStampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="creditNoteKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="nominalKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="payed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="application" type="{http://www.ekolky.gov.sk/estamp/xsd10}application"/>
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
    "dokuments",
    "payed",
    "application"
})
@XmlRootElement(name = "registerApplicationRequest")
public class RegisterApplicationRequest
    extends RequestOEK
{

    @XmlElement(required = true)
    protected RegisterApplicationRequest.Dokuments dokuments;
    protected boolean payed;
    @XmlElement(required = true)
    protected Application application;

    /**
     * Gets the value of the dokuments property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterApplicationRequest.Dokuments }
     *     
     */
    public RegisterApplicationRequest.Dokuments getDokuments() {
        return dokuments;
    }

    /**
     * Sets the value of the dokuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterApplicationRequest.Dokuments }
     *     
     */
    public void setDokuments(RegisterApplicationRequest.Dokuments value) {
        this.dokuments = value;
    }

    /**
     * Gets the value of the payed property.
     * 
     */
    public boolean isPayed() {
        return payed;
    }

    /**
     * Sets the value of the payed property.
     * 
     */
    public void setPayed(boolean value) {
        this.payed = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link Application }
     *     
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link Application }
     *     
     */
    public void setApplication(Application value) {
        this.application = value;
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
     *         &lt;element name="eStampKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="creditNoteKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" maxOccurs="unbounded" minOccurs="0"/>
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
        "eStampKey",
        "creditNoteKey",
        "nominalKey"
    })
    public static class Dokuments {

        protected List<Key> eStampKey;
        protected List<Key> creditNoteKey;
        protected List<Key> nominalKey;

        /**
         * Gets the value of the eStampKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the eStampKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEStampKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Key }
         * 
         * 
         */
        public List<Key> getEStampKey() {
            if (eStampKey == null) {
                eStampKey = new ArrayList<Key>();
            }
            return this.eStampKey;
        }

        /**
         * Gets the value of the creditNoteKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the creditNoteKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCreditNoteKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Key }
         * 
         * 
         */
        public List<Key> getCreditNoteKey() {
            if (creditNoteKey == null) {
                creditNoteKey = new ArrayList<Key>();
            }
            return this.creditNoteKey;
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
