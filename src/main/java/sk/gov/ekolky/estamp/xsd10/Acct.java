
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Acct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Acct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.ekolky.gov.sk/estamp/xsd10}IDIban"/>
 *         &lt;element name="Tp">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Prtry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Ccy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ownr" type="{http://www.ekolky.gov.sk/estamp/xsd10}Ownr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Acct", propOrder = {
    "id",
    "tp",
    "ccy",
    "nm",
    "ownr"
})
public class Acct {

    @XmlElement(name = "Id", required = true)
    protected IDIban id;
    @XmlElement(name = "Tp", required = true)
    protected Acct.Tp tp;
    @XmlElement(name = "Ccy", required = true)
    protected String ccy;
    @XmlElement(name = "Nm", required = true)
    protected String nm;
    @XmlElement(name = "Ownr", required = true)
    protected Ownr ownr;

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

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link Acct.Tp }
     *     
     */
    public Acct.Tp getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Acct.Tp }
     *     
     */
    public void setTp(Acct.Tp value) {
        this.tp = value;
    }

    /**
     * Gets the value of the ccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * Sets the value of the ccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

    /**
     * Gets the value of the nm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * Sets the value of the nm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Gets the value of the ownr property.
     * 
     * @return
     *     possible object is
     *     {@link Ownr }
     *     
     */
    public Ownr getOwnr() {
        return ownr;
    }

    /**
     * Sets the value of the ownr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ownr }
     *     
     */
    public void setOwnr(Ownr value) {
        this.ownr = value;
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
     *         &lt;element name="Prtry" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "prtry"
    })
    public static class Tp {

        @XmlElement(name = "Prtry", required = true)
        protected String prtry;

        /**
         * Gets the value of the prtry property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrtry() {
            return prtry;
        }

        /**
         * Sets the value of the prtry property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrtry(String value) {
            this.prtry = value;
        }

    }

}
