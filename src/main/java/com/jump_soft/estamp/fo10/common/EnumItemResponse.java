
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
 *         &lt;element name="enum" type="{http://www.ekolky.gov.sk/estamp/xsd10}service"/>
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
    "_enum"
})
@XmlRootElement(name = "enumItemResponse")
public class EnumItemResponse
    extends Response
{

    @XmlElement(name = "enum", required = true)
    protected Service _enum;

    /**
     * Gets the value of the enum property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getEnum() {
        return _enum;
    }

    /**
     * Sets the value of the enum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setEnum(Service value) {
        this._enum = value;
    }

}
