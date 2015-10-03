
package sk.gov.ekolky.estamp.fo10.assessment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="assessmentList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="assessment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="variableSymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="lastOperationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="lastOperation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="paymentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="payments" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="services" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="service" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="serviceList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="service" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="officeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="office" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="userList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="paymentList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="summary">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="payedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "assessmentList",
    "serviceList",
    "officeList",
    "userList",
    "paymentList",
    "summary"
})
@XmlRootElement(name = "getReportResponse")
public class GetReportResponse
    extends Response
{

    protected GetReportResponse.AssessmentList assessmentList;
    protected GetReportResponse.ServiceList serviceList;
    protected GetReportResponse.OfficeList officeList;
    protected GetReportResponse.UserList userList;
    protected GetReportResponse.PaymentList paymentList;
    @XmlElement(required = true)
    protected GetReportResponse.Summary summary;

    /**
     * Gets the value of the assessmentList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.AssessmentList }
     *     
     */
    public GetReportResponse.AssessmentList getAssessmentList() {
        return assessmentList;
    }

    /**
     * Sets the value of the assessmentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.AssessmentList }
     *     
     */
    public void setAssessmentList(GetReportResponse.AssessmentList value) {
        this.assessmentList = value;
    }

    /**
     * Gets the value of the serviceList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.ServiceList }
     *     
     */
    public GetReportResponse.ServiceList getServiceList() {
        return serviceList;
    }

    /**
     * Sets the value of the serviceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.ServiceList }
     *     
     */
    public void setServiceList(GetReportResponse.ServiceList value) {
        this.serviceList = value;
    }

    /**
     * Gets the value of the officeList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.OfficeList }
     *     
     */
    public GetReportResponse.OfficeList getOfficeList() {
        return officeList;
    }

    /**
     * Sets the value of the officeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.OfficeList }
     *     
     */
    public void setOfficeList(GetReportResponse.OfficeList value) {
        this.officeList = value;
    }

    /**
     * Gets the value of the userList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.UserList }
     *     
     */
    public GetReportResponse.UserList getUserList() {
        return userList;
    }

    /**
     * Sets the value of the userList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.UserList }
     *     
     */
    public void setUserList(GetReportResponse.UserList value) {
        this.userList = value;
    }

    /**
     * Gets the value of the paymentList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.PaymentList }
     *     
     */
    public GetReportResponse.PaymentList getPaymentList() {
        return paymentList;
    }

    /**
     * Sets the value of the paymentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.PaymentList }
     *     
     */
    public void setPaymentList(GetReportResponse.PaymentList value) {
        this.paymentList = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.Summary }
     *     
     */
    public GetReportResponse.Summary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.Summary }
     *     
     */
    public void setSummary(GetReportResponse.Summary value) {
        this.summary = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="assessment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="variableSymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="lastOperationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="lastOperation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="paymentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="payments" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="services" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="service" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "assessment"
    })
    public static class AssessmentList {

        protected List<GetReportResponse.AssessmentList.Assessment> assessment;

        /**
         * Gets the value of the assessment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the assessment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAssessment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.AssessmentList.Assessment }
         * 
         * 
         */
        public List<GetReportResponse.AssessmentList.Assessment> getAssessment() {
            if (assessment == null) {
                assessment = new ArrayList<GetReportResponse.AssessmentList.Assessment>();
            }
            return this.assessment;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="variableSymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="lastOperationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="lastOperation" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="paymentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="payments" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="services" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="service" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "confirmID",
            "issueDate",
            "amount",
            "variableSymbol",
            "officeID",
            "internalUserID",
            "lastOperationDate",
            "lastOperation",
            "state",
            "paymentState",
            "payments",
            "services"
        })
        public static class Assessment {

            @XmlElement(required = true)
            protected String confirmID;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar issueDate;
            @XmlElement(required = true)
            protected BigDecimal amount;
            @XmlElement(required = true)
            protected String variableSymbol;
            @XmlElement(required = true)
            protected String officeID;
            protected String internalUserID;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar lastOperationDate;
            @XmlElement(required = true)
            protected String lastOperation;
            @XmlElement(required = true)
            protected String state;
            @XmlElement(required = true)
            protected String paymentState;
            protected GetReportResponse.AssessmentList.Assessment.Payments payments;
            protected GetReportResponse.AssessmentList.Assessment.Services services;

            /**
             * Gets the value of the confirmID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConfirmID() {
                return confirmID;
            }

            /**
             * Sets the value of the confirmID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConfirmID(String value) {
                this.confirmID = value;
            }

            /**
             * Gets the value of the issueDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getIssueDate() {
                return issueDate;
            }

            /**
             * Sets the value of the issueDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setIssueDate(XMLGregorianCalendar value) {
                this.issueDate = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

            /**
             * Gets the value of the variableSymbol property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVariableSymbol() {
                return variableSymbol;
            }

            /**
             * Sets the value of the variableSymbol property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVariableSymbol(String value) {
                this.variableSymbol = value;
            }

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
             * Gets the value of the lastOperationDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getLastOperationDate() {
                return lastOperationDate;
            }

            /**
             * Sets the value of the lastOperationDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setLastOperationDate(XMLGregorianCalendar value) {
                this.lastOperationDate = value;
            }

            /**
             * Gets the value of the lastOperation property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLastOperation() {
                return lastOperation;
            }

            /**
             * Sets the value of the lastOperation property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLastOperation(String value) {
                this.lastOperation = value;
            }

            /**
             * Gets the value of the state property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Sets the value of the state property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Gets the value of the paymentState property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentState() {
                return paymentState;
            }

            /**
             * Sets the value of the paymentState property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentState(String value) {
                this.paymentState = value;
            }

            /**
             * Gets the value of the payments property.
             * 
             * @return
             *     possible object is
             *     {@link GetReportResponse.AssessmentList.Assessment.Payments }
             *     
             */
            public GetReportResponse.AssessmentList.Assessment.Payments getPayments() {
                return payments;
            }

            /**
             * Sets the value of the payments property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetReportResponse.AssessmentList.Assessment.Payments }
             *     
             */
            public void setPayments(GetReportResponse.AssessmentList.Assessment.Payments value) {
                this.payments = value;
            }

            /**
             * Gets the value of the services property.
             * 
             * @return
             *     possible object is
             *     {@link GetReportResponse.AssessmentList.Assessment.Services }
             *     
             */
            public GetReportResponse.AssessmentList.Assessment.Services getServices() {
                return services;
            }

            /**
             * Sets the value of the services property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetReportResponse.AssessmentList.Assessment.Services }
             *     
             */
            public void setServices(GetReportResponse.AssessmentList.Assessment.Services value) {
                this.services = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "payment"
            })
            public static class Payments {

                protected List<GetReportResponse.AssessmentList.Assessment.Payments.Payment> payment;

                /**
                 * Gets the value of the payment property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the payment property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPayment().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link GetReportResponse.AssessmentList.Assessment.Payments.Payment }
                 * 
                 * 
                 */
                public List<GetReportResponse.AssessmentList.Assessment.Payments.Payment> getPayment() {
                    if (payment == null) {
                        payment = new ArrayList<GetReportResponse.AssessmentList.Assessment.Payments.Payment>();
                    }
                    return this.payment;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "payType",
                    "amount"
                })
                public static class Payment {

                    @XmlElement(required = true)
                    protected String payType;
                    @XmlElement(required = true)
                    protected BigDecimal amount;

                    /**
                     * Gets the value of the payType property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPayType() {
                        return payType;
                    }

                    /**
                     * Sets the value of the payType property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPayType(String value) {
                        this.payType = value;
                    }

                    /**
                     * Gets the value of the amount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getAmount() {
                        return amount;
                    }

                    /**
                     * Sets the value of the amount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setAmount(BigDecimal value) {
                        this.amount = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="service" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "service"
            })
            public static class Services {

                @XmlElement(required = true)
                protected List<GetReportResponse.AssessmentList.Assessment.Services.Service> service;

                /**
                 * Gets the value of the service property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the service property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link GetReportResponse.AssessmentList.Assessment.Services.Service }
                 * 
                 * 
                 */
                public List<GetReportResponse.AssessmentList.Assessment.Services.Service> getService() {
                    if (service == null) {
                        service = new ArrayList<GetReportResponse.AssessmentList.Assessment.Services.Service>();
                    }
                    return this.service;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "serviceID",
                    "amount"
                })
                public static class Service {

                    @XmlElement(required = true)
                    protected String serviceID;
                    @XmlElement(required = true)
                    protected BigDecimal amount;

                    /**
                     * Gets the value of the serviceID property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getServiceID() {
                        return serviceID;
                    }

                    /**
                     * Sets the value of the serviceID property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setServiceID(String value) {
                        this.serviceID = value;
                    }

                    /**
                     * Gets the value of the amount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getAmount() {
                        return amount;
                    }

                    /**
                     * Sets the value of the amount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setAmount(BigDecimal value) {
                        this.amount = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="office" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "office"
    })
    public static class OfficeList {

        protected List<GetReportResponse.OfficeList.Office> office;

        /**
         * Gets the value of the office property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the office property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOffice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.OfficeList.Office }
         * 
         * 
         */
        public List<GetReportResponse.OfficeList.Office> getOffice() {
            if (office == null) {
                office = new ArrayList<GetReportResponse.OfficeList.Office>();
            }
            return this.office;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "officeID",
            "count",
            "amount"
        })
        public static class Office {

            @XmlElement(required = true)
            protected String officeID;
            protected long count;
            @XmlElement(required = true)
            protected BigDecimal amount;

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

            /**
             * Gets the value of the count property.
             * 
             */
            public long getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCount(long value) {
                this.count = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="payment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "payment"
    })
    public static class PaymentList {

        protected List<GetReportResponse.PaymentList.Payment> payment;

        /**
         * Gets the value of the payment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the payment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPayment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.PaymentList.Payment }
         * 
         * 
         */
        public List<GetReportResponse.PaymentList.Payment> getPayment() {
            if (payment == null) {
                payment = new ArrayList<GetReportResponse.PaymentList.Payment>();
            }
            return this.payment;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="payType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "payType",
            "count",
            "amount"
        })
        public static class Payment {

            @XmlElement(required = true)
            protected String payType;
            protected long count;
            @XmlElement(required = true)
            protected BigDecimal amount;

            /**
             * Gets the value of the payType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPayType() {
                return payType;
            }

            /**
             * Sets the value of the payType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPayType(String value) {
                this.payType = value;
            }

            /**
             * Gets the value of the count property.
             * 
             */
            public long getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCount(long value) {
                this.count = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="service" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "service"
    })
    public static class ServiceList {

        protected List<GetReportResponse.ServiceList.Service> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.ServiceList.Service }
         * 
         * 
         */
        public List<GetReportResponse.ServiceList.Service> getService() {
            if (service == null) {
                service = new ArrayList<GetReportResponse.ServiceList.Service>();
            }
            return this.service;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "serviceID",
            "count",
            "amount"
        })
        public static class Service {

            @XmlElement(required = true)
            protected String serviceID;
            protected long count;
            @XmlElement(required = true)
            protected BigDecimal amount;

            /**
             * Gets the value of the serviceID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceID() {
                return serviceID;
            }

            /**
             * Sets the value of the serviceID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceID(String value) {
                this.serviceID = value;
            }

            /**
             * Gets the value of the count property.
             * 
             */
            public long getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCount(long value) {
                this.count = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="payedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "count",
        "amount",
        "payedAmount"
    })
    public static class Summary {

        protected long count;
        @XmlElement(required = true)
        protected BigDecimal amount;
        @XmlElement(required = true)
        protected BigDecimal payedAmount;

        /**
         * Gets the value of the count property.
         * 
         */
        public long getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         */
        public void setCount(long value) {
            this.count = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the payedAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPayedAmount() {
            return payedAmount;
        }

        /**
         * Sets the value of the payedAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPayedAmount(BigDecimal value) {
            this.payedAmount = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "user"
    })
    public static class UserList {

        protected List<GetReportResponse.UserList.User> user;

        /**
         * Gets the value of the user property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUser().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.UserList.User }
         * 
         * 
         */
        public List<GetReportResponse.UserList.User> getUser() {
            if (user == null) {
                user = new ArrayList<GetReportResponse.UserList.User>();
            }
            return this.user;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "internalUserID",
            "count",
            "amount"
        })
        public static class User {

            protected String internalUserID;
            protected long count;
            @XmlElement(required = true)
            protected BigDecimal amount;

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
             * Gets the value of the count property.
             * 
             */
            public long getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCount(long value) {
                this.count = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }

    }

}
