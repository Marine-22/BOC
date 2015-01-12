
package com.jump_soft.estamp.fo10.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.RequestFE;
import sk.gov.ekolky.estamp.xsd10.Service;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestFE">
 *       &lt;sequence>
 *         &lt;element name="enumID" type="{http://www.ekolky.gov.sk/estamp/xsd10}service"/>
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
    "enumID"
})
@XmlRootElement(name = "enumNoteRequest")
public class EnumNoteRequest
    extends RequestFE
{

    @XmlElement(required = true)
    protected Service enumID;

    /**
     * Gets the value of the enumID property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getEnumID() {
        return enumID;
    }

    /**
     * Sets the value of the enumID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setEnumID(Service value) {
        this.enumID = value;
    }

}
