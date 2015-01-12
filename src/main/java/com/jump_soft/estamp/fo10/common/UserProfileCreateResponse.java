
package com.jump_soft.estamp.fo10.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Response;
import sk.gov.ekolky.estamp.xsd10.Service;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}response">
 *       &lt;sequence>
 *         &lt;element name="userID" type="{http://www.ekolky.gov.sk/estamp/xsd10}service"/>
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
    "userID"
})
@XmlRootElement(name = "userProfileCreateResponse")
public class UserProfileCreateResponse
    extends Response
{

    @XmlElement(required = true)
    protected Service userID;

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setUserID(Service value) {
        this.userID = value;
    }

}
