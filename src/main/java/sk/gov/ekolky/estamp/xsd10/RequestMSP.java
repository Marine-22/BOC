
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.fo10.assessment.CancelRequest;
import sk.gov.ekolky.estamp.fo10.assessment.CreateRequest;
import sk.gov.ekolky.estamp.fo10.assessment.GetRequest;
import sk.gov.ekolky.estamp.fo10.assessment.ListOperationsRequest;
import sk.gov.ekolky.estamp.fo10.assessment.ListRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationChangePaymentRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationConsumeRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationDeclareRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationPaymentRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationRefundRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationReserveRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationTransferRequest;
import sk.gov.ekolky.estamp.fo10.assessment.UpdateRequest;


/**
 * <p>Java class for requestMSP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestMSP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestOEK">
 *       &lt;sequence>
 *         &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestMSP", propOrder = {
    "officeID"
})
@XmlSeeAlso({
    sk.gov.ekolky.estamp.fo10.nominal.GetReportRequest.class,
    OperationChangePaymentRequest.class,
    ListRequest.class,
    OperationRefundRequest.class,
    OperationTransferRequest.class,
    OperationPaymentRequest.class,
    OperationDeclareRequest.class,
    GetRequest.class,
    CreateRequest.class,
    UpdateRequest.class,
    OperationConsumeRequest.class,
    ListOperationsRequest.class,
    sk.gov.ekolky.estamp.fo10.assessment.GetReportRequest.class,
    OperationReserveRequest.class,
    CancelRequest.class,
    sk.gov.ekolky.estamp.fo10.estamp.GetReportRequest.class
})
public class RequestMSP
    extends RequestOEK
{

    protected String officeID;

    /**
     * Gets the value of the officeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeID() {
        return officeID;
    }

    /**
     * Sets the value of the officeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeID(String value) {
        this.officeID = value;
    }

}
