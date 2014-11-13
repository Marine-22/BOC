
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.fo10.estamp.CreateRequest;
import sk.gov.ekolky.estamp.fo10.estamp.ExchangeRequest;
import sk.gov.ekolky.estamp.fo10.estamp.GetRequest;
import sk.gov.ekolky.estamp.fo10.estamp.LockRequest;
import sk.gov.ekolky.estamp.fo10.estamp.UnlockRequest;
import sk.gov.ekolky.estamp.fo10.infra.DeviceStateCheckRequest;
import sk.gov.ekolky.estamp.fo10.infra.IncidentRegisterRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListCountryRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListDeviceInfoRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListFeDevicesRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListFeeRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListOfficeRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListParameterRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListSWPRequest;
import sk.gov.ekolky.estamp.fo10.infra.ListServiceRequest;


/**
 * <p>Java class for requestFE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestFE">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}request">
 *       &lt;sequence>
 *         &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="offline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestFE", propOrder = {
    "feDeviceID",
    "offline"
})
@XmlSeeAlso({
    GetRequest.class,
    CreateRequest.class,
    LockRequest.class,
    ExchangeRequest.class,
    UnlockRequest.class,
    ListFeDevicesRequest.class,
    ListServiceRequest.class,
    ListOfficeRequest.class,
    ListFeeRequest.class,
    ListCountryRequest.class,
    ListParameterRequest.class,
    ListSWPRequest.class,
    ListDeviceInfoRequest.class,
    DeviceStateCheckRequest.class,
    IncidentRegisterRequest.class,
    RequestOEK.class
})
public class RequestFE
    extends Request
{

    @XmlElement(required = true)
    protected String feDeviceID;
    protected Boolean offline;

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
     * Gets the value of the offline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOffline() {
        return offline;
    }

    /**
     * Sets the value of the offline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffline(Boolean value) {
        this.offline = value;
    }

}
