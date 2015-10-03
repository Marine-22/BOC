
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.jump_soft.estamp.fo10.common.BindingManagementResponse;
import com.jump_soft.estamp.fo10.common.DeviceEditResponse;
import com.jump_soft.estamp.fo10.common.EStampConsumedStornoResponse;
import com.jump_soft.estamp.fo10.common.EStampCreateNegativeResponse;
import com.jump_soft.estamp.fo10.common.EStampMonthlyReportResponse;
import com.jump_soft.estamp.fo10.common.EStampSearchResponse;
import com.jump_soft.estamp.fo10.common.EnumItemResponse;
import com.jump_soft.estamp.fo10.common.EnumListResponse;
import com.jump_soft.estamp.fo10.common.EnumNoteResponse;
import com.jump_soft.estamp.fo10.common.ErrorListResponse;
import com.jump_soft.estamp.fo10.common.ExportSAPResponse;
import com.jump_soft.estamp.fo10.common.PaymentPairingResponse;
import com.jump_soft.estamp.fo10.common.ServiceInfoResponse;
import com.jump_soft.estamp.fo10.common.ServiceTerminationResponse;
import com.jump_soft.estamp.fo10.common.UserProfileCreateResponse;
import com.jump_soft.estamp.fo10.common.UserProfileEditResponse;
import sk.gov.ekolky.estamp.fo10.aponet.RefundReserveResponse;
import sk.gov.ekolky.estamp.fo10.aponet.RefundReserveUndoResponse;
import sk.gov.ekolky.estamp.fo10.aponet.RegisterApplicationResponse;
import sk.gov.ekolky.estamp.fo10.assessment.CancelResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationChangePaymentResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationDeclareResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationExecutionDELTEDResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationRefundResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationReserveResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationTransferResponse;
import sk.gov.ekolky.estamp.fo10.assessment.PrintDELETEDResponse;
import sk.gov.ekolky.estamp.fo10.assessment.UpdateResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.CloseResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetClosureResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetMoneySendSPResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneySendSPResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneyTransferResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.OpenResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.TakeoverResponse;
import sk.gov.ekolky.estamp.fo10.estamp.ExchangeResponse;
import sk.gov.ekolky.estamp.fo10.estamp.LockResponse;
import sk.gov.ekolky.estamp.fo10.estamp.UnlockResponse;
import sk.gov.ekolky.estamp.fo10.infra.DeviceStateCheckResponse;
import sk.gov.ekolky.estamp.fo10.infra.IncidentRegisterResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListCountryResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListDeviceInfoResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListFeDevicesResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListFeeResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListOfficeResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListParameterResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListSWPResponse;
import sk.gov.ekolky.estamp.fo10.infra.ListServiceResponse;
import sk.gov.ekolky.estamp.fo10.nominal.CheckStateResponse;


/**
 * <p>Java class for response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response")
@XmlSeeAlso({
    GetInfoResponse.class,
    sk.gov.ekolky.estamp.fo10.cashdesk.ListResponse.class,
    CloseResponse.class,
    MoneySendSPResponse.class,
    MoneyTransferResponse.class,
    TakeoverResponse.class,
    GetClosureResponse.class,
    OpenResponse.class,
    GetMoneySendSPResponse.class,
    CheckStateResponse.class,
    sk.gov.ekolky.estamp.fo10.nominal.GetReportResponse.class,
    RegisterApplicationResponse.class,
    RefundReserveUndoResponse.class,
    RefundReserveResponse.class,
    IncidentRegisterResponse.class,
    ListServiceResponse.class,
    ListCountryResponse.class,
    ListFeDevicesResponse.class,
    ListOfficeResponse.class,
    ListParameterResponse.class,
    ListSWPResponse.class,
    DeviceStateCheckResponse.class,
    ListDeviceInfoResponse.class,
    ListFeeResponse.class,
    DeviceEditResponse.class,
    EStampMonthlyReportResponse.class,
    EStampCreateNegativeResponse.class,
    EStampConsumedStornoResponse.class,
    ServiceInfoResponse.class,
    ServiceTerminationResponse.class,
    UserProfileCreateResponse.class,
    UserProfileEditResponse.class,
    EnumNoteResponse.class,
    EnumListResponse.class,
    BindingManagementResponse.class,
    EnumItemResponse.class,
    ErrorListResponse.class,
    EStampSearchResponse.class,
    ExportSAPResponse.class,
    PaymentPairingResponse.class,
    OperationDeclareResponse.class,
    PrintDELETEDResponse.class,
    OperationReserveResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListResponse.class,
    OperationExecutionDELTEDResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.OperationConsumeResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.OperationPaymentResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.GetResponse.class,
    OperationTransferResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.GetReportResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.CreateResponse.class,
    UpdateResponse.class,
    CancelResponse.class,
    OperationChangePaymentResponse.class,
    OperationRefundResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListOperationsResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.ListResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.CreateResponse.class,
    UnlockResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.OperationConsumeResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.ListOperationsResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.OperationPaymentResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.GetResponse.class,
    LockResponse.class,
    ExchangeResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.GetReportResponse.class
})
public class Response {


}
