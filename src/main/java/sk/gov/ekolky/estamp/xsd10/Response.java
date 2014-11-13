
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.fo10.assessment.CancelResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationDeclareResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationExecutionDELTEDResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationPaymentResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationRefundResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationReserveResponse;
import sk.gov.ekolky.estamp.fo10.assessment.OperationTransferResponse;
import sk.gov.ekolky.estamp.fo10.assessment.PrintDELETEDResponse;
import sk.gov.ekolky.estamp.fo10.assessment.UpdateResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.CloseResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoResponse;
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
    GetInfoResponse.class,
    sk.gov.ekolky.estamp.fo10.cashdesk.ListResponse.class,
    CloseResponse.class,
    MoneySendSPResponse.class,
    MoneyTransferResponse.class,
    TakeoverResponse.class,
    OpenResponse.class,
    CheckStateResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.ListResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.CreateResponse.class,
    UnlockResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.OperationConsumeResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.ListOperationsResponse.class,
    sk.gov.ekolky.estamp.fo10.estamp.GetResponse.class,
    LockResponse.class,
    ExchangeResponse.class,
    OperationDeclareResponse.class,
    PrintDELETEDResponse.class,
    OperationReserveResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListResponse.class,
    OperationExecutionDELTEDResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.OperationConsumeResponse.class,
    OperationPaymentResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.GetResponse.class,
    OperationTransferResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.CreateResponse.class,
    UpdateResponse.class,
    CancelResponse.class,
    OperationRefundResponse.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListOperationsResponse.class
})
public class Response {


}
