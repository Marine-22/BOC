
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.fo10.assessment.CancelRequest;
import sk.gov.ekolky.estamp.fo10.assessment.CreateRequest;
import sk.gov.ekolky.estamp.fo10.assessment.GetRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationDeclareRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationExecutionDELTEDRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationPaymentRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationRefundRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationReserveRequest;
import sk.gov.ekolky.estamp.fo10.assessment.OperationTransferRequest;
import sk.gov.ekolky.estamp.fo10.assessment.PrintDELETEDRequest;
import sk.gov.ekolky.estamp.fo10.assessment.UpdateRequest;
import sk.gov.ekolky.estamp.fo10.nominal.CheckStateRequest;


/**
 * <p>Java class for requestOEK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestOEK">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestFE">
 *       &lt;sequence>
 *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestOEK", propOrder = {
    "internalUserID",
    "internalUserName",
    "identityID"
})
@XmlSeeAlso({
    sk.gov.ekolky.estamp.fo10.estamp.ListOperationsRequest.class,
    sk.gov.ekolky.estamp.fo10.estamp.OperationConsumeRequest.class,
    sk.gov.ekolky.estamp.fo10.estamp.ListRequest.class,
    RequestSWP.class,
    OperationExecutionDELTEDRequest.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListRequest.class,
    PrintDELETEDRequest.class,
    OperationRefundRequest.class,
    OperationTransferRequest.class,
    OperationPaymentRequest.class,
    OperationDeclareRequest.class,
    GetRequest.class,
    CreateRequest.class,
    UpdateRequest.class,
    sk.gov.ekolky.estamp.fo10.assessment.OperationConsumeRequest.class,
    sk.gov.ekolky.estamp.fo10.assessment.ListOperationsRequest.class,
    OperationReserveRequest.class,
    CancelRequest.class,
    CheckStateRequest.class
})
public class RequestOEK
    extends RequestFE
{

    protected String internalUserID;
    protected String internalUserName;
    protected String identityID;

    /**
     * Gets the value of the internalUserID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalUserID() {
        return internalUserID;
    }

    /**
     * Sets the value of the internalUserID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalUserID(String value) {
        this.internalUserID = value;
    }

    /**
     * Gets the value of the internalUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalUserName() {
        return internalUserName;
    }

    /**
     * Sets the value of the internalUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalUserName(String value) {
        this.internalUserName = value;
    }

    /**
     * Gets the value of the identityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityID() {
        return identityID;
    }

    /**
     * Sets the value of the identityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityID(String value) {
        this.identityID = value;
    }

}
