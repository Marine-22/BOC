
package sk.gov.ekolky.estamp.fo10.cashdesk;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="amountCash" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="amountCard" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="variableSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "amountCash",
    "amountCard",
    "accountNumber",
    "variableSymbol"
})
@XmlRootElement(name = "moneySendSPResponse")
public class MoneySendSPResponse
    extends Response
{

    protected BigDecimal amountCash;
    protected BigDecimal amountCard;
    protected String accountNumber;
    protected String variableSymbol;

    /**
     * Gets the value of the amountCash property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountCash() {
        return amountCash;
    }

    /**
     * Sets the value of the amountCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountCash(BigDecimal value) {
        this.amountCash = value;
    }

    /**
     * Gets the value of the amountCard property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountCard() {
        return amountCard;
    }

    /**
     * Sets the value of the amountCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountCard(BigDecimal value) {
        this.amountCard = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
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

}
