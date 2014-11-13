
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BkTxCd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BkTxCd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prtry">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Issr" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "BkTxCd", propOrder = {
    "prtry"
})
public class BkTxCd {

    @XmlElement(name = "Prtry", required = true)
    protected BkTxCd.Prtry prtry;

    /**
     * Gets the value of the prtry property.
     * 
     * @return
     *     possible object is
     *     {@link BkTxCd.Prtry }
     *     
     */
    public BkTxCd.Prtry getPrtry() {
        return prtry;
    }

    /**
     * Sets the value of the prtry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BkTxCd.Prtry }
     *     
     */
    public void setPrtry(BkTxCd.Prtry value) {
        this.prtry = value;
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
     *         &lt;element name="Cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Issr" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "cd",
        "issr"
    })
    public static class Prtry {

        @XmlElement(name = "Cd", required = true)
        protected String cd;
        @XmlElement(name = "Issr", required = true)
        protected String issr;

        /**
         * Gets the value of the cd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCd() {
            return cd;
        }

        /**
         * Sets the value of the cd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCd(String value) {
            this.cd = value;
        }

        /**
         * Gets the value of the issr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIssr() {
            return issr;
        }

        /**
         * Sets the value of the issr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIssr(String value) {
            this.issr = value;
        }

    }

}
