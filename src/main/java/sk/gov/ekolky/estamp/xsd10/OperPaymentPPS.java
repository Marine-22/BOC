
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operPaymentPPS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operPaymentPPS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="variableSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="constSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operPaymentPPS", propOrder = {
    "clientAccountNumber",
    "variableSymbol",
    "constSymbol",
    "specificSymbol"
})
public class OperPaymentPPS {

    @XmlElement(required = true)
    protected String clientAccountNumber;
    protected String variableSymbol;
    protected String constSymbol;
    protected String specificSymbol;

    /**
     * Gets the value of the clientAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    /**
     * Sets the value of the clientAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientAccountNumber(String value) {
        this.clientAccountNumber = value;
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
     * Gets the value of the constSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstSymbol() {
        return constSymbol;
    }

    /**
     * Sets the value of the constSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstSymbol(String value) {
        this.constSymbol = value;
    }

    /**
     * Gets the value of the specificSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificSymbol() {
        return specificSymbol;
    }

    /**
     * Sets the value of the specificSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificSymbol(String value) {
        this.specificSymbol = value;
    }

}
