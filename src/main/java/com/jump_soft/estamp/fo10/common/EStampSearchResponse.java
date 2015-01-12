
package com.jump_soft.estamp.fo10.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Estamp;
import sk.gov.ekolky.estamp.xsd10.Response;


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
 *         &lt;element name="estamp" type="{http://www.ekolky.gov.sk/estamp/xsd10}estamp"/>
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
    "estamp"
})
@XmlRootElement(name = "eStampSearchResponse")
public class EStampSearchResponse
    extends Response
{

    @XmlElement(required = true)
    protected Estamp estamp;

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

}
