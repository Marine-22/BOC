
package sk.gov.ekolky.estamp.xsd10;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operConsume complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operConsume">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="multiple" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="use" type="{http://www.ekolky.gov.sk/estamp/xsd10}serviceUse"/>
 *         &lt;element name="processNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operConsume", propOrder = {
    "amount",
    "multiple",
    "discount",
    "use",
    "processNumber"
})
public class OperConsume {

    protected float amount;
    @XmlElement(required = true)
    protected BigInteger multiple;
    @XmlElement(required = true)
    protected BigInteger discount;
    @XmlElement(required = true)
    protected ServiceUse use;
    protected String processNumber;

    /**
     * Gets the value of the amount property.
     * 
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(float value) {
        this.amount = value;
    }

    /**
     * Gets the value of the multiple property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMultiple() {
        return multiple;
    }

    /**
     * Sets the value of the multiple property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMultiple(BigInteger value) {
        this.multiple = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscount(BigInteger value) {
        this.discount = value;
    }

    /**
     * Gets the value of the use property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceUse }
     *     
     */
    public ServiceUse getUse() {
        return use;
    }

    /**
     * Sets the value of the use property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceUse }
     *     
     */
    public void setUse(ServiceUse value) {
        this.use = value;
    }

    /**
     * Gets the value of the processNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessNumber() {
        return processNumber;
    }

    /**
     * Sets the value of the processNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessNumber(String value) {
        this.processNumber = value;
    }

}
