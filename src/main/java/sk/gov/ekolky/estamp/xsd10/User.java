
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "feDeviceID",
    "internalUserID",
    "internalUserName",
    "identityID"
})
public class User {

    protected String feDeviceID;
    protected String internalUserID;
    protected String internalUserName;
    protected String identityID;

    /**
     * Gets the value of the feDeviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeDeviceID() {
        return feDeviceID;
    }

    /**
     * Sets the value of the feDeviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeDeviceID(String value) {
        this.feDeviceID = value;
    }

    /**
     * Gets the value of the internalUserID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalUserID() {
        return internalUserID;
    }

    /**
     * Sets the value of the internalUserID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalUserID(String value) {
        this.internalUserID = value;
    }

    /**
     * Gets the value of the internalUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalUserName() {
        return internalUserName;
    }

    /**
     * Sets the value of the internalUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalUserName(String value) {
        this.internalUserName = value;
    }

    /**
     * Gets the value of the identityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityID() {
        return identityID;
    }

    /**
     * Sets the value of the identityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityID(String value) {
        this.identityID = value;
    }

}
