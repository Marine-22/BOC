
package sk.gov.ekolky.estamp.fo10.infra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="serviceVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameterVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="softwareVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="officeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countryVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceLock" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "serviceVersion",
    "parameterVersion",
    "softwareVersion",
    "officeVersion",
    "feeVersion",
    "countryVersion",
    "deviceLock"
})
@XmlRootElement(name = "deviceStateCheckResponse")
public class DeviceStateCheckResponse
    extends Response
{

    protected String serviceVersion;
    protected String parameterVersion;
    protected String softwareVersion;
    protected String officeVersion;
    protected String feeVersion;
    protected String countryVersion;
    protected Boolean deviceLock;

    /**
     * Gets the value of the serviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Sets the value of the serviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceVersion(String value) {
        this.serviceVersion = value;
    }

    /**
     * Gets the value of the parameterVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterVersion() {
        return parameterVersion;
    }

    /**
     * Sets the value of the parameterVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterVersion(String value) {
        this.parameterVersion = value;
    }

    /**
     * Gets the value of the softwareVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Sets the value of the softwareVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareVersion(String value) {
        this.softwareVersion = value;
    }

    /**
     * Gets the value of the officeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeVersion() {
        return officeVersion;
    }

    /**
     * Sets the value of the officeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeVersion(String value) {
        this.officeVersion = value;
    }

    /**
     * Gets the value of the feeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeVersion() {
        return feeVersion;
    }

    /**
     * Sets the value of the feeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeVersion(String value) {
        this.feeVersion = value;
    }

    /**
     * Gets the value of the countryVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryVersion() {
        return countryVersion;
    }

    /**
     * Sets the value of the countryVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryVersion(String value) {
        this.countryVersion = value;
    }

    /**
     * Gets the value of the deviceLock property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeviceLock() {
        return deviceLock;
    }

    /**
     * Sets the value of the deviceLock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeviceLock(Boolean value) {
        this.deviceLock = value;
    }

}
