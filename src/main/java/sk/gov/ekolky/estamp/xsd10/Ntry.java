
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Ntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CdtDbtInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RvslInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookgDt" type="{http://www.ekolky.gov.sk/estamp/xsd10}date" minOccurs="0"/>
 *         &lt;element name="ValDt" type="{http://www.ekolky.gov.sk/estamp/xsd10}date" minOccurs="0"/>
 *         &lt;element name="BkTxCd" type="{http://www.ekolky.gov.sk/estamp/xsd10}BkTxCd" minOccurs="0"/>
 *         &lt;element name="NtryDtls" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TxDtls" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Refs" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="AcctSvcrRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="EndToEndId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AmtDtls" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PrtryAmt" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                             &lt;element name="BkTxCd" type="{http://www.ekolky.gov.sk/estamp/xsd10}BkTxCd" minOccurs="0"/>
 *                             &lt;element name="RltdPties" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Dbtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
 *                                       &lt;element name="DbtrAcct" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Cdtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RltdAgts" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DbtrAgt" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="FinInstnId" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
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
 *                             &lt;element name="RmtInf" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Ustrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RltdDts" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="AccptncDtTm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlType(name = "Ntry", propOrder = {
    "amt",
    "cdtDbtInd",
    "rvslInd",
    "sts",
    "bookgDt",
    "valDt",
    "bkTxCd",
    "ntryDtls"
})
public class Ntry {

    @XmlElement(name = "Amt", required = true)
    protected String amt;
    @XmlElement(name = "CdtDbtInd", required = true)
    protected String cdtDbtInd;
    @XmlElement(name = "RvslInd")
    protected String rvslInd;
    @XmlElement(name = "Sts")
    protected String sts;
    @XmlElement(name = "BookgDt")
    protected Date bookgDt;
    @XmlElement(name = "ValDt")
    protected Date valDt;
    @XmlElement(name = "BkTxCd")
    protected BkTxCd bkTxCd;
    @XmlElement(name = "NtryDtls")
    protected Ntry.NtryDtls ntryDtls;

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmt(String value) {
        this.amt = value;
    }

    /**
     * Gets the value of the cdtDbtInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * Sets the value of the cdtDbtInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtDbtInd(String value) {
        this.cdtDbtInd = value;
    }

    /**
     * Gets the value of the rvslInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRvslInd() {
        return rvslInd;
    }

    /**
     * Sets the value of the rvslInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRvslInd(String value) {
        this.rvslInd = value;
    }

    /**
     * Gets the value of the sts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSts() {
        return sts;
    }

    /**
     * Sets the value of the sts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSts(String value) {
        this.sts = value;
    }

    /**
     * Gets the value of the bookgDt property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getBookgDt() {
        return bookgDt;
    }

    /**
     * Sets the value of the bookgDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setBookgDt(Date value) {
        this.bookgDt = value;
    }

    /**
     * Gets the value of the valDt property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getValDt() {
        return valDt;
    }

    /**
     * Sets the value of the valDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setValDt(Date value) {
        this.valDt = value;
    }

    /**
     * Gets the value of the bkTxCd property.
     * 
     * @return
     *     possible object is
     *     {@link BkTxCd }
     *     
     */
    public BkTxCd getBkTxCd() {
        return bkTxCd;
    }

    /**
     * Sets the value of the bkTxCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BkTxCd }
     *     
     */
    public void setBkTxCd(BkTxCd value) {
        this.bkTxCd = value;
    }

    /**
     * Gets the value of the ntryDtls property.
     * 
     * @return
     *     possible object is
     *     {@link Ntry.NtryDtls }
     *     
     */
    public Ntry.NtryDtls getNtryDtls() {
        return ntryDtls;
    }

    /**
     * Sets the value of the ntryDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ntry.NtryDtls }
     *     
     */
    public void setNtryDtls(Ntry.NtryDtls value) {
        this.ntryDtls = value;
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
     *         &lt;element name="TxDtls" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Refs" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="AcctSvcrRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="EndToEndId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AmtDtls" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="PrtryAmt" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                       &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *                   &lt;element name="BkTxCd" type="{http://www.ekolky.gov.sk/estamp/xsd10}BkTxCd" minOccurs="0"/>
     *                   &lt;element name="RltdPties" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Dbtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
     *                             &lt;element name="DbtrAcct" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Cdtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="RltdAgts" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="DbtrAgt" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="FinInstnId" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *                   &lt;element name="RmtInf" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Ustrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="RltdDts" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="AccptncDtTm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
        "txDtls"
    })
    public static class NtryDtls {

        @XmlElement(name = "TxDtls")
        protected Ntry.NtryDtls.TxDtls txDtls;

        /**
         * Gets the value of the txDtls property.
         * 
         * @return
         *     possible object is
         *     {@link Ntry.NtryDtls.TxDtls }
         *     
         */
        public Ntry.NtryDtls.TxDtls getTxDtls() {
            return txDtls;
        }

        /**
         * Sets the value of the txDtls property.
         * 
         * @param value
         *     allowed object is
         *     {@link Ntry.NtryDtls.TxDtls }
         *     
         */
        public void setTxDtls(Ntry.NtryDtls.TxDtls value) {
            this.txDtls = value;
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
         *         &lt;element name="Refs" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="AcctSvcrRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="EndToEndId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AmtDtls" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PrtryAmt" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                             &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
         *         &lt;element name="BkTxCd" type="{http://www.ekolky.gov.sk/estamp/xsd10}BkTxCd" minOccurs="0"/>
         *         &lt;element name="RltdPties" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Dbtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
         *                   &lt;element name="DbtrAcct" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Cdtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RltdAgts" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="DbtrAgt" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="FinInstnId" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
         *         &lt;element name="RmtInf" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Ustrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RltdDts" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="AccptncDtTm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
            "refs",
            "amtDtls",
            "bkTxCd",
            "rltdPties",
            "rltdAgts",
            "rmtInf",
            "rltdDts"
        })
        public static class TxDtls {

            @XmlElement(name = "Refs")
            protected Ntry.NtryDtls.TxDtls.Refs refs;
            @XmlElement(name = "AmtDtls")
            protected Ntry.NtryDtls.TxDtls.AmtDtls amtDtls;
            @XmlElement(name = "BkTxCd")
            protected BkTxCd bkTxCd;
            @XmlElement(name = "RltdPties")
            protected Ntry.NtryDtls.TxDtls.RltdPties rltdPties;
            @XmlElement(name = "RltdAgts")
            protected Ntry.NtryDtls.TxDtls.RltdAgts rltdAgts;
            @XmlElement(name = "RmtInf")
            protected Ntry.NtryDtls.TxDtls.RmtInf rmtInf;
            @XmlElement(name = "RltdDts")
            protected Ntry.NtryDtls.TxDtls.RltdDts rltdDts;

            /**
             * Gets the value of the refs property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.Refs }
             *     
             */
            public Ntry.NtryDtls.TxDtls.Refs getRefs() {
                return refs;
            }

            /**
             * Sets the value of the refs property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.Refs }
             *     
             */
            public void setRefs(Ntry.NtryDtls.TxDtls.Refs value) {
                this.refs = value;
            }

            /**
             * Gets the value of the amtDtls property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.AmtDtls }
             *     
             */
            public Ntry.NtryDtls.TxDtls.AmtDtls getAmtDtls() {
                return amtDtls;
            }

            /**
             * Sets the value of the amtDtls property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.AmtDtls }
             *     
             */
            public void setAmtDtls(Ntry.NtryDtls.TxDtls.AmtDtls value) {
                this.amtDtls = value;
            }

            /**
             * Gets the value of the bkTxCd property.
             * 
             * @return
             *     possible object is
             *     {@link BkTxCd }
             *     
             */
            public BkTxCd getBkTxCd() {
                return bkTxCd;
            }

            /**
             * Sets the value of the bkTxCd property.
             * 
             * @param value
             *     allowed object is
             *     {@link BkTxCd }
             *     
             */
            public void setBkTxCd(BkTxCd value) {
                this.bkTxCd = value;
            }

            /**
             * Gets the value of the rltdPties property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdPties }
             *     
             */
            public Ntry.NtryDtls.TxDtls.RltdPties getRltdPties() {
                return rltdPties;
            }

            /**
             * Sets the value of the rltdPties property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdPties }
             *     
             */
            public void setRltdPties(Ntry.NtryDtls.TxDtls.RltdPties value) {
                this.rltdPties = value;
            }

            /**
             * Gets the value of the rltdAgts property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdAgts }
             *     
             */
            public Ntry.NtryDtls.TxDtls.RltdAgts getRltdAgts() {
                return rltdAgts;
            }

            /**
             * Sets the value of the rltdAgts property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdAgts }
             *     
             */
            public void setRltdAgts(Ntry.NtryDtls.TxDtls.RltdAgts value) {
                this.rltdAgts = value;
            }

            /**
             * Gets the value of the rmtInf property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.RmtInf }
             *     
             */
            public Ntry.NtryDtls.TxDtls.RmtInf getRmtInf() {
                return rmtInf;
            }

            /**
             * Sets the value of the rmtInf property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.RmtInf }
             *     
             */
            public void setRmtInf(Ntry.NtryDtls.TxDtls.RmtInf value) {
                this.rmtInf = value;
            }

            /**
             * Gets the value of the rltdDts property.
             * 
             * @return
             *     possible object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdDts }
             *     
             */
            public Ntry.NtryDtls.TxDtls.RltdDts getRltdDts() {
                return rltdDts;
            }

            /**
             * Sets the value of the rltdDts property.
             * 
             * @param value
             *     allowed object is
             *     {@link Ntry.NtryDtls.TxDtls.RltdDts }
             *     
             */
            public void setRltdDts(Ntry.NtryDtls.TxDtls.RltdDts value) {
                this.rltdDts = value;
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
             *         &lt;element name="PrtryAmt" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                   &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "prtryAmt"
            })
            public static class AmtDtls {

                @XmlElement(name = "PrtryAmt")
                protected Ntry.NtryDtls.TxDtls.AmtDtls.PrtryAmt prtryAmt;

                /**
                 * Gets the value of the prtryAmt property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Ntry.NtryDtls.TxDtls.AmtDtls.PrtryAmt }
                 *     
                 */
                public Ntry.NtryDtls.TxDtls.AmtDtls.PrtryAmt getPrtryAmt() {
                    return prtryAmt;
                }

                /**
                 * Sets the value of the prtryAmt property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Ntry.NtryDtls.TxDtls.AmtDtls.PrtryAmt }
                 *     
                 */
                public void setPrtryAmt(Ntry.NtryDtls.TxDtls.AmtDtls.PrtryAmt value) {
                    this.prtryAmt = value;
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
                 *         &lt;element name="Tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                    "tp",
                    "amt"
                })
                public static class PrtryAmt {

                    @XmlElement(name = "Tp")
                    protected String tp;
                    @XmlElement(name = "Amt")
                    protected String amt;

                    /**
                     * Gets the value of the tp property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTp() {
                        return tp;
                    }

                    /**
                     * Sets the value of the tp property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTp(String value) {
                        this.tp = value;
                    }

                    /**
                     * Gets the value of the amt property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAmt() {
                        return amt;
                    }

                    /**
                     * Sets the value of the amt property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAmt(String value) {
                        this.amt = value;
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
             *         &lt;element name="AcctSvcrRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="EndToEndId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "acctSvcrRef",
                "endToEndId"
            })
            public static class Refs {

                @XmlElement(name = "AcctSvcrRef")
                protected String acctSvcrRef;
                @XmlElement(name = "EndToEndId")
                protected String endToEndId;

                /**
                 * Gets the value of the acctSvcrRef property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAcctSvcrRef() {
                    return acctSvcrRef;
                }

                /**
                 * Sets the value of the acctSvcrRef property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAcctSvcrRef(String value) {
                    this.acctSvcrRef = value;
                }

                /**
                 * Gets the value of the endToEndId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEndToEndId() {
                    return endToEndId;
                }

                /**
                 * Sets the value of the endToEndId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEndToEndId(String value) {
                    this.endToEndId = value;
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
             *         &lt;element name="DbtrAgt" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FinInstnId" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "dbtrAgt"
            })
            public static class RltdAgts {

                @XmlElement(name = "DbtrAgt")
                protected Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt dbtrAgt;

                /**
                 * Gets the value of the dbtrAgt property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt }
                 *     
                 */
                public Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt getDbtrAgt() {
                    return dbtrAgt;
                }

                /**
                 * Sets the value of the dbtrAgt property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt }
                 *     
                 */
                public void setDbtrAgt(Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt value) {
                    this.dbtrAgt = value;
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
                 *         &lt;element name="FinInstnId" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                    "finInstnId"
                })
                public static class DbtrAgt {

                    @XmlElement(name = "FinInstnId")
                    protected Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt.FinInstnId finInstnId;

                    /**
                     * Gets the value of the finInstnId property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt.FinInstnId }
                     *     
                     */
                    public Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt.FinInstnId getFinInstnId() {
                        return finInstnId;
                    }

                    /**
                     * Sets the value of the finInstnId property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt.FinInstnId }
                     *     
                     */
                    public void setFinInstnId(Ntry.NtryDtls.TxDtls.RltdAgts.DbtrAgt.FinInstnId value) {
                        this.finInstnId = value;
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
                     *         &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                        "bic"
                    })
                    public static class FinInstnId {

                        @XmlElement(name = "BIC")
                        protected String bic;

                        /**
                         * Gets the value of the bic property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getBIC() {
                            return bic;
                        }

                        /**
                         * Sets the value of the bic property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setBIC(String value) {
                            this.bic = value;
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
             *         &lt;element name="AccptncDtTm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
                "accptncDtTm"
            })
            public static class RltdDts {

                @XmlElement(name = "AccptncDtTm")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar accptncDtTm;

                /**
                 * Gets the value of the accptncDtTm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getAccptncDtTm() {
                    return accptncDtTm;
                }

                /**
                 * Sets the value of the accptncDtTm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setAccptncDtTm(XMLGregorianCalendar value) {
                    this.accptncDtTm = value;
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
             *         &lt;element name="Dbtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
             *         &lt;element name="DbtrAcct" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Cdtr" type="{http://www.ekolky.gov.sk/estamp/xsd10}tr" minOccurs="0"/>
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
                "dbtr",
                "dbtrAcct",
                "cdtr"
            })
            public static class RltdPties {

                @XmlElement(name = "Dbtr")
                protected Tr dbtr;
                @XmlElement(name = "DbtrAcct")
                protected Ntry.NtryDtls.TxDtls.RltdPties.DbtrAcct dbtrAcct;
                @XmlElement(name = "Cdtr")
                protected Tr cdtr;

                /**
                 * Gets the value of the dbtr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tr }
                 *     
                 */
                public Tr getDbtr() {
                    return dbtr;
                }

                /**
                 * Sets the value of the dbtr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tr }
                 *     
                 */
                public void setDbtr(Tr value) {
                    this.dbtr = value;
                }

                /**
                 * Gets the value of the dbtrAcct property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Ntry.NtryDtls.TxDtls.RltdPties.DbtrAcct }
                 *     
                 */
                public Ntry.NtryDtls.TxDtls.RltdPties.DbtrAcct getDbtrAcct() {
                    return dbtrAcct;
                }

                /**
                 * Sets the value of the dbtrAcct property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Ntry.NtryDtls.TxDtls.RltdPties.DbtrAcct }
                 *     
                 */
                public void setDbtrAcct(Ntry.NtryDtls.TxDtls.RltdPties.DbtrAcct value) {
                    this.dbtrAcct = value;
                }

                /**
                 * Gets the value of the cdtr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tr }
                 *     
                 */
                public Tr getCdtr() {
                    return cdtr;
                }

                /**
                 * Sets the value of the cdtr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tr }
                 *     
                 */
                public void setCdtr(Tr value) {
                    this.cdtr = value;
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
                 *         &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban" minOccurs="0"/>
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
                    "id"
                })
                public static class DbtrAcct {

                    @XmlElement(name = "Id")
                    protected IDIban id;

                    /**
                     * Gets the value of the id property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link IDIban }
                     *     
                     */
                    public IDIban getId() {
                        return id;
                    }

                    /**
                     * Sets the value of the id property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link IDIban }
                     *     
                     */
                    public void setId(IDIban value) {
                        this.id = value;
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
             *         &lt;element name="Ustrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "ustrd"
            })
            public static class RmtInf {

                @XmlElement(name = "Ustrd")
                protected String ustrd;

                /**
                 * Gets the value of the ustrd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUstrd() {
                    return ustrd;
                }

                /**
                 * Sets the value of the ustrd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUstrd(String value) {
                    this.ustrd = value;
                }

            }

        }

    }

}
