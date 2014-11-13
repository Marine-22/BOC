
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTicketKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eTicketKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eStamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *         &lt;element name="creditNote" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *         &lt;element name="assessment" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *         &lt;element name="nominal" type="{http://www.ekolky.gov.sk/estamp/xsd10}key" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eTicketKey", propOrder = {
    "eStamp",
    "creditNote",
    "assessment",
    "nominal"
})
public class ETicketKey {

    protected Key eStamp;
    protected Key creditNote;
    protected Key assessment;
    protected Key nominal;

    /**
     * Gets the value of the eStamp property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getEStamp() {
        return eStamp;
    }

    /**
     * Sets the value of the eStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setEStamp(Key value) {
        this.eStamp = value;
    }

    /**
     * Gets the value of the creditNote property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getCreditNote() {
        return creditNote;
    }

    /**
     * Sets the value of the creditNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setCreditNote(Key value) {
        this.creditNote = value;
    }

    /**
     * Gets the value of the assessment property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getAssessment() {
        return assessment;
    }

    /**
     * Sets the value of the assessment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setAssessment(Key value) {
        this.assessment = value;
    }

    /**
     * Gets the value of the nominal property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getNominal() {
        return nominal;
    }

    /**
     * Sets the value of the nominal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setNominal(Key value) {
        this.nominal = value;
    }

}
