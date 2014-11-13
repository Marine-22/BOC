
package sk.gov.ekolky.estamp.fo10.infra;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.DeviceType;
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
 *         &lt;element name="offices" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="devices" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="deviceType" type="{http://www.ekolky.gov.sk/estamp/xsd10}deviceType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="agendas" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="agendaID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="officeVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "offices",
    "officeVersion"
})
@XmlRootElement(name = "listOfficeResponse")
public class ListOfficeResponse
    extends Response
{

    @XmlElement(required = true)
    protected List<ListOfficeResponse.Offices> offices;
    @XmlElement(required = true)
    protected String officeVersion;

    /**
     * Gets the value of the offices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListOfficeResponse.Offices }
     * 
     * 
     */
    public List<ListOfficeResponse.Offices> getOffices() {
        if (offices == null) {
            offices = new ArrayList<ListOfficeResponse.Offices>();
        }
        return this.offices;
    }

    /**
     * Gets the value of the officeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeVersion() {
        return officeVersion;
    }

    /**
     * Sets the value of the officeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeVersion(String value) {
        this.officeVersion = value;
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
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="devices" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="deviceType" type="{http://www.ekolky.gov.sk/estamp/xsd10}deviceType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="agendas" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="agendaID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "code",
        "name",
        "uri",
        "devices",
        "agendas"
    })
    public static class Offices {

        @XmlElement(required = true)
        protected String code;
        @XmlElement(required = true)
        protected String name;
        protected String uri;
        protected List<ListOfficeResponse.Offices.Devices> devices;
        protected List<ListOfficeResponse.Offices.Agendas> agendas;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

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
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUri() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUri(String value) {
            this.uri = value;
        }

        /**
         * Gets the value of the devices property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the devices property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDevices().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ListOfficeResponse.Offices.Devices }
         * 
         * 
         */
        public List<ListOfficeResponse.Offices.Devices> getDevices() {
            if (devices == null) {
                devices = new ArrayList<ListOfficeResponse.Offices.Devices>();
            }
            return this.devices;
        }

        /**
         * Gets the value of the agendas property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the agendas property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAgendas().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ListOfficeResponse.Offices.Agendas }
         * 
         * 
         */
        public List<ListOfficeResponse.Offices.Agendas> getAgendas() {
            if (agendas == null) {
                agendas = new ArrayList<ListOfficeResponse.Offices.Agendas>();
            }
            return this.agendas;
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
         *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="agendaID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "code",
            "agendaID"
        })
        public static class Agendas {

            @XmlElement(required = true)
            protected String code;
            @XmlElement(required = true)
            protected String agendaID;

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the agendaID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAgendaID() {
                return agendaID;
            }

            /**
             * Sets the value of the agendaID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAgendaID(String value) {
                this.agendaID = value;
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
         *         &lt;element name="feDeviceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="deviceType" type="{http://www.ekolky.gov.sk/estamp/xsd10}deviceType"/>
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
            "feDeviceID",
            "deviceType"
        })
        public static class Devices {

            @XmlElement(required = true)
            protected String feDeviceID;
            @XmlElement(required = true)
            protected DeviceType deviceType;

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
             * Gets the value of the deviceType property.
             * 
             * @return
             *     possible object is
             *     {@link DeviceType }
             *     
             */
            public DeviceType getDeviceType() {
                return deviceType;
            }

            /**
             * Sets the value of the deviceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link DeviceType }
             *     
             */
            public void setDeviceType(DeviceType value) {
                this.deviceType = value;
            }

        }

    }

}
