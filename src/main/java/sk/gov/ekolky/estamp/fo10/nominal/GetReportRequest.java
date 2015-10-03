
package sk.gov.ekolky.estamp.fo10.nominal;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import sk.gov.ekolky.estamp.xsd10.RequestMSP;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ekolky.gov.sk/estamp/xsd10}requestMSP">
 *       &lt;sequence>
 *         &lt;element name="conditions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dateCond">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="weekCond">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="week" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                       &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="monthCond">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                       &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
 *                   &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="range" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="order" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="nominalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="consumeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "conditions",
    "range",
    "order"
})
@XmlRootElement(name = "getReportRequest")
public class GetReportRequest
    extends RequestMSP
{

    @XmlElement(required = true)
    protected GetReportRequest.Conditions conditions;
    protected GetReportRequest.Range range;
    protected GetReportRequest.Order order;

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportRequest.Conditions }
     *     
     */
    public GetReportRequest.Conditions getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportRequest.Conditions }
     *     
     */
    public void setConditions(GetReportRequest.Conditions value) {
        this.conditions = value;
    }

    /**
     * Gets the value of the range property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportRequest.Range }
     *     
     */
    public GetReportRequest.Range getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportRequest.Range }
     *     
     */
    public void setRange(GetReportRequest.Range value) {
        this.range = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link GetReportRequest.Order }
     *     
     */
    public GetReportRequest.Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReportRequest.Order }
     *     
     */
    public void setOrder(GetReportRequest.Order value) {
        this.order = value;
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
     *         &lt;element name="dateCond">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="weekCond">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="week" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                             &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="monthCond">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                             &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
     *         &lt;element name="internalUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "dateCond",
        "internalUserID"
    })
    public static class Conditions {

        @XmlElement(required = true)
        protected GetReportRequest.Conditions.DateCond dateCond;
        protected String internalUserID;

        /**
         * Gets the value of the dateCond property.
         * 
         * @return
         *     possible object is
         *     {@link GetReportRequest.Conditions.DateCond }
         *     
         */
        public GetReportRequest.Conditions.DateCond getDateCond() {
            return dateCond;
        }

        /**
         * Sets the value of the dateCond property.
         * 
         * @param value
         *     allowed object is
         *     {@link GetReportRequest.Conditions.DateCond }
         *     
         */
        public void setDateCond(GetReportRequest.Conditions.DateCond value) {
            this.dateCond = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="weekCond">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="week" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *                   &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="monthCond">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *                   &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
            "day",
            "weekCond",
            "monthCond"
        })
        public static class DateCond {

            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar day;
            protected GetReportRequest.Conditions.DateCond.WeekCond weekCond;
            protected GetReportRequest.Conditions.DateCond.MonthCond monthCond;

            /**
             * Gets the value of the day property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDay() {
                return day;
            }

            /**
             * Sets the value of the day property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDay(XMLGregorianCalendar value) {
                this.day = value;
            }

            /**
             * Gets the value of the weekCond property.
             * 
             * @return
             *     possible object is
             *     {@link GetReportRequest.Conditions.DateCond.WeekCond }
             *     
             */
            public GetReportRequest.Conditions.DateCond.WeekCond getWeekCond() {
                return weekCond;
            }

            /**
             * Sets the value of the weekCond property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetReportRequest.Conditions.DateCond.WeekCond }
             *     
             */
            public void setWeekCond(GetReportRequest.Conditions.DateCond.WeekCond value) {
                this.weekCond = value;
            }

            /**
             * Gets the value of the monthCond property.
             * 
             * @return
             *     possible object is
             *     {@link GetReportRequest.Conditions.DateCond.MonthCond }
             *     
             */
            public GetReportRequest.Conditions.DateCond.MonthCond getMonthCond() {
                return monthCond;
            }

            /**
             * Sets the value of the monthCond property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetReportRequest.Conditions.DateCond.MonthCond }
             *     
             */
            public void setMonthCond(GetReportRequest.Conditions.DateCond.MonthCond value) {
                this.monthCond = value;
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
             *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}integer"/>
             *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
                "month",
                "year"
            })
            public static class MonthCond {

                @XmlElement(required = true)
                protected BigInteger month;
                @XmlElement(required = true)
                protected BigInteger year;

                /**
                 * Gets the value of the month property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMonth() {
                    return month;
                }

                /**
                 * Sets the value of the month property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMonth(BigInteger value) {
                    this.month = value;
                }

                /**
                 * Gets the value of the year property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getYear() {
                    return year;
                }

                /**
                 * Sets the value of the year property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setYear(BigInteger value) {
                    this.year = value;
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
             *         &lt;element name="week" type="{http://www.w3.org/2001/XMLSchema}integer"/>
             *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
                "week",
                "year"
            })
            public static class WeekCond {

                @XmlElement(required = true)
                protected BigInteger week;
                @XmlElement(required = true)
                protected BigInteger year;

                /**
                 * Gets the value of the week property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getWeek() {
                    return week;
                }

                /**
                 * Sets the value of the week property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setWeek(BigInteger value) {
                    this.week = value;
                }

                /**
                 * Gets the value of the year property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getYear() {
                    return year;
                }

                /**
                 * Sets the value of the year property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setYear(BigInteger value) {
                    this.year = value;
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
     *       &lt;choice>
     *         &lt;element name="nominalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="consumeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "nominalID",
        "consumeDate",
        "amount"
    })
    public static class Order {

        protected String nominalID;
        protected String consumeDate;
        protected String amount;

        /**
         * Gets the value of the nominalID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNominalID() {
            return nominalID;
        }

        /**
         * Sets the value of the nominalID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNominalID(String value) {
            this.nominalID = value;
        }

        /**
         * Gets the value of the consumeDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConsumeDate() {
            return consumeDate;
        }

        /**
         * Sets the value of the consumeDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConsumeDate(String value) {
            this.consumeDate = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmount(String value) {
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
     *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "from"
    })
    public static class Range {

        protected BigInteger count;
        protected BigInteger from;

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCount(BigInteger value) {
            this.count = value;
        }

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setFrom(BigInteger value) {
            this.from = value;
        }

    }

}
