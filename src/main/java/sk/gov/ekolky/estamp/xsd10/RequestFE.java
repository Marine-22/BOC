
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.jump_soft.estamp.fo10.common.BindingManagementRequest;
import com.jump_soft.estamp.fo10.common.DeviceEditRequest;
import com.jump_soft.estamp.fo10.common.EStampConsumedStornoRequest;
import com.jump_soft.estamp.fo10.common.EStampCreateNegativeRequest;
import com.jump_soft.estamp.fo10.common.EStampMonthlyReportRequest;
import com.jump_soft.estamp.fo10.common.EStampSearchRequest;
import com.jump_soft.estamp.fo10.common.EnumItemRequest;
import com.jump_soft.estamp.fo10.common.EnumListRequest;
import com.jump_soft.estamp.fo10.common.EnumNoteRequest;
import com.jump_soft.estamp.fo10.common.ErrorListRequest;
import com.jump_soft.estamp.fo10.common.ExportSAPRequest;
import com.jump_soft.estamp.fo10.common.PaymentPairingRequest;
import com.jump_soft.estamp.fo10.common.ServiceInfoRequest;
import com.jump_soft.estamp.fo10.common.ServiceTerminationRequest;
import com.jump_soft.estamp.fo10.common.UserProfileCreateRequest;
import com.jump_soft.estamp.fo10.common.UserProfileEditRequest;
import sk.gov.ekolky.estamp.fo10.estamp.ExchangeRequest;
import sk.gov.ekolky.estamp.fo10.estamp.GetRequest;
import sk.gov.ekolky.estamp.fo10.estamp.LockRequest;
import sk.gov.ekolky.estamp.fo10.estamp.OperationPaymentRequest;
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
    EStampCreateNegativeRequest.class,
    EnumListRequest.class,
    EStampConsumedStornoRequest.class,
    EStampMonthlyReportRequest.class,
    DeviceEditRequest.class,
    EnumItemRequest.class,
    EnumNoteRequest.class,
    ServiceTerminationRequest.class,
    UserProfileEditRequest.class,
    BindingManagementRequest.class,
    UserProfileCreateRequest.class,
    ExportSAPRequest.class,
    ServiceInfoRequest.class,
    ErrorListRequest.class,
    PaymentPairingRequest.class,
    EStampSearchRequest.class,
    GetRequest.class,
    LockRequest.class,
    RequestOEK.class,
    ExchangeRequest.class,
    UnlockRequest.class,
    OperationPaymentRequest.class
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
