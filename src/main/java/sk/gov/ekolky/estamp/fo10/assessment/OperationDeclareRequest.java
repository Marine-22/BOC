
package sk.gov.ekolky.estamp.fo10.assessment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.OperDeclare;
import sk.gov.ekolky.estamp.xsd10.Operation;
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
 *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="operDeclare" type="{http://www.ekolky.gov.sk/estamp/xsd10}operDeclare" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="undo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="operations" type="{http://www.ekolky.gov.sk/estamp/xsd10}operation" maxOccurs="unbounded" minOccurs="0"/>
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
    "key",
    "operDeclare",
    "undo",
    "operations"
})
@XmlRootElement(name = "operationDeclareRequest")
public class OperationDeclareRequest
    extends RequestMSP
{

    @XmlElement(required = true)
    protected Key key;
    protected List<OperDeclare> operDeclare;
    protected Boolean undo;
    protected List<Operation> operations;

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
     * Gets the value of the operDeclare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operDeclare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperDeclare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperDeclare }
     * 
     * 
     */
    public List<OperDeclare> getOperDeclare() {
        if (operDeclare == null) {
            operDeclare = new ArrayList<OperDeclare>();
        }
        return this.operDeclare;
    }

    /**
     * Gets the value of the undo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUndo() {
        return undo;
    }

    /**
     * Sets the value of the undo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUndo(Boolean value) {
        this.undo = value;
    }

    /**
     * Gets the value of the operations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Operation }
     * 
     * 
     */
    public List<Operation> getOperations() {
        if (operations == null) {
            operations = new ArrayList<Operation>();
        }
        return this.operations;
    }

}
