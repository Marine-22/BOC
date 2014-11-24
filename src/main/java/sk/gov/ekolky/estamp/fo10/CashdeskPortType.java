
package sk.gov.ekolky.estamp.fo10;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import sk.gov.ekolky.estamp.fo10.cashdesk.CloseRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.CloseResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.ListRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.ListResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneySendSPRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneySendSPResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneyTransferRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.MoneyTransferResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.OpenRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.OpenResponse;
import sk.gov.ekolky.estamp.fo10.cashdesk.TakeoverRequest;
import sk.gov.ekolky.estamp.fo10.cashdesk.TakeoverResponse;
import sk.posta.boc.ispep.PepConfig;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "cashdesk_PortType", targetNamespace = PepConfig.TARGET_NAMESPACE)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    sk.gov.ekolky.estamp.fo10.infra.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.assessment.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.nominal.ObjectFactory.class,
    sk.gov.ekolky.estamp.xsd10.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.cashdesk.ObjectFactory.class,
    sk.gov.ekolky.estamp.fo10.estamp.ObjectFactory.class
})
public interface CashdeskPortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.GetInfoResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "getInfoResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public GetInfoResponse getInfo(
        @WebParam(name = "getInfoRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        GetInfoRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.ListResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "listResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public ListResponse list(
        @WebParam(name = "listRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        ListRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.OpenResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "openResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public OpenResponse open(
        @WebParam(name = "openRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        OpenRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.TakeoverResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "takeoverResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public TakeoverResponse takeover(
        @WebParam(name = "takeoverRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        TakeoverRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.CloseResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "closeResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public CloseResponse close(
        @WebParam(name = "closeRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        CloseRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.MoneySendSPResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "moneySendSPResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public MoneySendSPResponse moneySendSP(
        @WebParam(name = "moneySendSPRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        MoneySendSPRequest parameters)
        throws BloxFaultMessage
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns sk.gov.ekolky.estamp.fo10.cashdesk.MoneyTransferResponse
     * @throws BloxFaultMessage
     */
    @WebMethod
    @WebResult(name = "moneyTransferResponse", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
    public MoneyTransferResponse moneyTransfer(
        @WebParam(name = "moneyTransferRequest", targetNamespace = PepConfig.TARGET_NAMESPACE + "/cashdesk", partName = "parameters")
        MoneyTransferRequest parameters)
        throws BloxFaultMessage
    ;

}
