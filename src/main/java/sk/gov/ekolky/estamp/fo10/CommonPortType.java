
package sk.gov.ekolky.estamp.fo10;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import sk.posta.boc.ispep.PepConfig;

import com.jump_soft.estamp.fo10.common.BindingManagementRequest;
import com.jump_soft.estamp.fo10.common.BindingManagementResponse;
import com.jump_soft.estamp.fo10.common.DeviceEditRequest;
import com.jump_soft.estamp.fo10.common.DeviceEditResponse;
import com.jump_soft.estamp.fo10.common.EStampConsumedStornoRequest;
import com.jump_soft.estamp.fo10.common.EStampConsumedStornoResponse;
import com.jump_soft.estamp.fo10.common.EStampCreateNegativeRequest;
import com.jump_soft.estamp.fo10.common.EStampCreateNegativeResponse;
import com.jump_soft.estamp.fo10.common.EStampMonthlyReportRequest;
import com.jump_soft.estamp.fo10.common.EStampMonthlyReportResponse;
import com.jump_soft.estamp.fo10.common.EStampSearchRequest;
import com.jump_soft.estamp.fo10.common.EStampSearchResponse;
import com.jump_soft.estamp.fo10.common.EnumItemRequest;
import com.jump_soft.estamp.fo10.common.EnumItemResponse;
import com.jump_soft.estamp.fo10.common.EnumListRequest;
import com.jump_soft.estamp.fo10.common.EnumListResponse;
import com.jump_soft.estamp.fo10.common.EnumNoteRequest;
import com.jump_soft.estamp.fo10.common.EnumNoteResponse;
import com.jump_soft.estamp.fo10.common.ErrorListRequest;
import com.jump_soft.estamp.fo10.common.ErrorListResponse;
import com.jump_soft.estamp.fo10.common.ExportSAPRequest;
import com.jump_soft.estamp.fo10.common.ExportSAPResponse;
import com.jump_soft.estamp.fo10.common.PaymentPairingRequest;
import com.jump_soft.estamp.fo10.common.PaymentPairingResponse;
import com.jump_soft.estamp.fo10.common.ServiceInfoRequest;
import com.jump_soft.estamp.fo10.common.ServiceInfoResponse;
import com.jump_soft.estamp.fo10.common.ServiceTerminationRequest;
import com.jump_soft.estamp.fo10.common.ServiceTerminationResponse;
import com.jump_soft.estamp.fo10.common.UserProfileCreateRequest;
import com.jump_soft.estamp.fo10.common.UserProfileCreateResponse;
import com.jump_soft.estamp.fo10.common.UserProfileEditRequest;
import com.jump_soft.estamp.fo10.common.UserProfileEditResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "common_PortType", targetNamespace = PepConfig.TARGET_NAMESPACE)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    sk.gov.ekolky.estamp.fo10.nominal.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.aponet.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.assessment.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.cashdesk.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.infra.ObjectFactory.class,
    sk.gov.ekolky.estamp.xsd10.ObjectFactory.class,
    com.jump_soft.estamp.fo10.common.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.estamp.ObjectFactory.class
})
public interface CommonPortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.ServiceInfoResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "serviceInfoResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public ServiceInfoResponse serviceInfo(
        @WebParam(name = "serviceInfoRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        ServiceInfoRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.ServiceTerminationResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "serviceTerminationResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public ServiceTerminationResponse serviceTermination(
        @WebParam(name = "serviceTerminationRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        ServiceTerminationRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EnumNoteResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "enumNoteResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EnumNoteResponse enumNote(
        @WebParam(name = "enumNoteRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EnumNoteRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EnumItemResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "enumItemResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EnumItemResponse enumItem(
        @WebParam(name = "enumItemRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EnumItemRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EnumListResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "enumListResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EnumListResponse enumList(
        @WebParam(name = "enumListRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EnumListRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.UserProfileCreateResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "userProfileCreateResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public UserProfileCreateResponse userProfileCreate(
        @WebParam(name = "userProfileCreateRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        UserProfileCreateRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.UserProfileEditResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "userProfileEditResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public UserProfileEditResponse userProfileEdit(
        @WebParam(name = "userProfileEditRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        UserProfileEditRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EStampSearchResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "eStampSearchResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EStampSearchResponse eStampSearch(
        @WebParam(name = "eStampSearchRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EStampSearchRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EStampConsumedStornoResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "eStampConsumedStornoResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EStampConsumedStornoResponse eStampConsumedStorno(
        @WebParam(name = "eStampConsumedStornoRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EStampConsumedStornoRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EStampCreateNegativeResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "eStampCreateNegativeResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EStampCreateNegativeResponse eStampCreateNegative(
        @WebParam(name = "eStampCreateNegativeRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EStampCreateNegativeRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.EStampMonthlyReportResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "eStampMonthlyReportResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public EStampMonthlyReportResponse eStampMonthlyReport(
        @WebParam(name = "eStampMonthlyReportRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        EStampMonthlyReportRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.ErrorListResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "errorListResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public ErrorListResponse errorList(
        @WebParam(name = "errorListRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        ErrorListRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.ExportSAPResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "exportSAPResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public ExportSAPResponse exportSAP(
        @WebParam(name = "exportSAPRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        ExportSAPRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.PaymentPairingResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "paymentPairingResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public PaymentPairingResponse paymentPairing(
        @WebParam(name = "paymentPairingRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        PaymentPairingRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.DeviceEditResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "deviceEditResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public DeviceEditResponse deviceEdit(
        @WebParam(name = "deviceEditRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        DeviceEditRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns com.jump_soft.estamp.fo10.common.BindingManagementResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "bindingManagementResponse", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
    public BindingManagementResponse bindingManagement(
        @WebParam(name = "bindingManagementRequest", targetNamespace = "http://www.jump-soft.com/estamp/fo10/common", partName = "parameters")
        BindingManagementRequest parameters)
        throws BloxFaultMessage
    ;

}
