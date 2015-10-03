
package sk.gov.ekolky.estamp.fo10.estamp;

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
 *         &lt;element name="consumeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="consume" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="consumeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="summary">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "consumeList",
    "serviceList",
    "officeList",
    "userList",
    "summary"
})
@XmlRootElement(name = "getReportResponse")
public class GetReportResponse
    extends Response
{

    protected GetReportResponse.ConsumeList consumeList;
    protected GetReportResponse.ServiceList serviceList;
    protected GetReportResponse.OfficeList officeList;
    protected GetReportResponse.UserList userList;
    @XmlElement(required = true)
    protected GetReportResponse.Summary summary;

    /**
     * Gets the value of the consumeList property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportResponse.ConsumeList }
     *     
     */
    public GetReportResponse.ConsumeList getConsumeList() {
        return consumeList;
    }

    /**
     * Sets the value of the consumeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportResponse.ConsumeList }
     *     
     */
    public void setConsumeList(GetReportResponse.ConsumeList value) {
        this.consumeList = value;
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
     *         &lt;element name="consume" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="consumeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "consume"
    })
    public static class ConsumeList {

        protected List<GetReportResponse.ConsumeList.Consume> consume;

        /**
         * Gets the value of the consume property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the consume property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConsume().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReportResponse.ConsumeList.Consume }
         * 
         * 
         */
        public List<GetReportResponse.ConsumeList.Consume> getConsume() {
            if (consume == null) {
                consume = new ArrayList<GetReportResponse.ConsumeList.Consume>();
            }
            return this.consume;
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
         *         &lt;element name="consumeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="confirmID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="officeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "consumeDate",
            "confirmID",
            "amount",
            "feDeviceID",
            "officeID",
            "internalUserID",
            "service",
            "state"
        })
        public static class Consume {

            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar consumeDate;
            @XmlElement(required = true)
            protected String confirmID;
            @XmlElement(required = true)
            protected BigDecimal amount;
            @XmlElement(required = true)
            protected String feDeviceID;
            @XmlElement(required = true)
            protected String officeID;
            protected String internalUserID;
            @XmlElement(required = true)
            protected String service;
            @XmlElement(required = true)
            protected String state;

            /**
             * Gets the value of the consumeDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getConsumeDate() {
                return consumeDate;
            }

            /**
             * Sets the value of the consumeDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setConsumeDate(XMLGregorianCalendar value) {
                this.consumeDate = value;
            }

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
             * Gets the value of the service property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getService() {
                return service;
            }

            /**
             * Sets the value of the service property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setService(String value) {
                this.service = value;
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
     *         &lt;element name="service" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "name",
            "count",
            "amount"
        })
        public static class Service {

            @XmlElement(required = true)
            protected String name;
            protected long count;
            @XmlElement(required = true)
            protected BigDecimal amount;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
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
        "amount"
    })
    public static class Summary {

        protected long count;
        @XmlElement(required = true)
        protected BigDecimal amount;

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
