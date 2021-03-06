
package sk.gov.ekolky.estamp.xsd10;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operFraud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operFraud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="fraudType" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ticketKey" type="{http://www.ekolky.gov.sk/estamp/xsd10}eTicketKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operFraud", propOrder = {
    "amount",
    "fraudType",
    "ticketKey"
})
public class OperFraud {

    protected float amount;
    protected BigInteger fraudType;
    protected ETicketKey ticketKey;

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
     * Gets the value of the fraudType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFraudType() {
        return fraudType;
    }

    /**
     * Sets the value of the fraudType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFraudType(BigInteger value) {
        this.fraudType = value;
    }

    /**
     * Gets the value of the ticketKey property.
     * 
     * @return
     *     possible object is
     *     {@link ETicketKey }
     *     
     */
    public ETicketKey getTicketKey() {
        return ticketKey;
    }

    /**
     * Sets the value of the ticketKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ETicketKey }
     *     
     */
    public void setTicketKey(ETicketKey value) {
        this.ticketKey = value;
    }

}
