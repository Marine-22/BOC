
package sk.gov.ekolky.estamp.fo10.assessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.RequestOEK;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestOEK">
 *       &lt;sequence>
 *         &lt;element name="reportType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="paymentConfirm">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="postalOrder">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *                             &lt;element name="payType" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;choice>
 *                                       &lt;element name="total" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="balance" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/choice>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
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
    "reportType"
})
@XmlRootElement(name = "print_DELETEDRequest")
public class PrintDELETEDRequest
    extends RequestOEK
{

    @XmlElement(required = true)
    protected PrintDELETEDRequest.ReportType reportType;

    /**
     * Gets the value of the reportType property.
     * 
     * @return
     *     possible object is
     *     {@link PrintDELETEDRequest.ReportType }
     *     
     */
    public PrintDELETEDRequest.ReportType getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintDELETEDRequest.ReportType }
     *     
     */
    public void setReportType(PrintDELETEDRequest.ReportType value) {
        this.reportType = value;
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
     *       &lt;choice>
     *         &lt;element name="paymentConfirm">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="postalOrder">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
     *                   &lt;element name="payType" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;choice>
     *                             &lt;element name="total" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="balance" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/choice>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paymentConfirm",
        "postalOrder"
    })
    public static class ReportType {

        protected PrintDELETEDRequest.ReportType.PaymentConfirm paymentConfirm;
        protected PrintDELETEDRequest.ReportType.PostalOrder postalOrder;

        /**
         * Gets the value of the paymentConfirm property.
         * 
         * @return
         *     possible object is
         *     {@link PrintDELETEDRequest.ReportType.PaymentConfirm }
         *     
         */
        public PrintDELETEDRequest.ReportType.PaymentConfirm getPaymentConfirm() {
            return paymentConfirm;
        }

        /**
         * Sets the value of the paymentConfirm property.
         * 
         * @param value
         *     allowed object is
         *     {@link PrintDELETEDRequest.ReportType.PaymentConfirm }
         *     
         */
        public void setPaymentConfirm(PrintDELETEDRequest.ReportType.PaymentConfirm value) {
            this.paymentConfirm = value;
        }

        /**
         * Gets the value of the postalOrder property.
         * 
         * @return
         *     possible object is
         *     {@link PrintDELETEDRequest.ReportType.PostalOrder }
         *     
         */
        public PrintDELETEDRequest.ReportType.PostalOrder getPostalOrder() {
            return postalOrder;
        }

        /**
         * Sets the value of the postalOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link PrintDELETEDRequest.ReportType.PostalOrder }
         *     
         */
        public void setPostalOrder(PrintDELETEDRequest.ReportType.PostalOrder value) {
            this.postalOrder = value;
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
         *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
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
            "key"
        })
        public static class PaymentConfirm {

            @XmlElement(required = true)
            protected Key key;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link Key }
             *     
             */
            public Key getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link Key }
             *     
             */
            public void setKey(Key value) {
                this.key = value;
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
         *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
         *         &lt;element name="payType" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice>
         *                   &lt;element name="total" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="balance" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/choice>
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
            "key",
            "payType"
        })
        public static class PostalOrder {

            @XmlElement(required = true)
            protected Key key;
            protected PrintDELETEDRequest.ReportType.PostalOrder.PayType payType;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link Key }
             *     
             */
            public Key getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link Key }
             *     
             */
            public void setKey(Key value) {
                this.key = value;
            }

            /**
             * Gets the value of the payType property.
             * 
             * @return
             *     possible object is
             *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType }
             *     
             */
            public PrintDELETEDRequest.ReportType.PostalOrder.PayType getPayType() {
                return payType;
            }

            /**
             * Sets the value of the payType property.
             * 
             * @param value
             *     allowed object is
             *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType }
             *     
             */
            public void setPayType(PrintDELETEDRequest.ReportType.PostalOrder.PayType value) {
                this.payType = value;
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
             *       &lt;choice>
             *         &lt;element name="total" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="balance" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/choice>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "total",
                "balance"
            })
            public static class PayType {

                protected PrintDELETEDRequest.ReportType.PostalOrder.PayType.Total total;
                protected PrintDELETEDRequest.ReportType.PostalOrder.PayType.Balance balance;

                /**
                 * Gets the value of the total property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType.Total }
                 *     
                 */
                public PrintDELETEDRequest.ReportType.PostalOrder.PayType.Total getTotal() {
                    return total;
                }

                /**
                 * Sets the value of the total property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType.Total }
                 *     
                 */
                public void setTotal(PrintDELETEDRequest.ReportType.PostalOrder.PayType.Total value) {
                    this.total = value;
                }

                /**
                 * Gets the value of the balance property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType.Balance }
                 *     
                 */
                public PrintDELETEDRequest.ReportType.PostalOrder.PayType.Balance getBalance() {
                    return balance;
                }

                /**
                 * Sets the value of the balance property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PrintDELETEDRequest.ReportType.PostalOrder.PayType.Balance }
                 *     
                 */
                public void setBalance(PrintDELETEDRequest.ReportType.PostalOrder.PayType.Balance value) {
                    this.balance = value;
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
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Balance {


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
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Total {


                }

            }

        }

    }

}
