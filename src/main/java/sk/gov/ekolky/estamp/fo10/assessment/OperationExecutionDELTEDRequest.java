
package sk.gov.ekolky.estamp.fo10.assessment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Key;
import sk.gov.ekolky.estamp.xsd10.OperExecution;
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
 *         &lt;element name="key" type="{http://www.ekolky.gov.sk/estamp/xsd10}key"/>
 *         &lt;element name="operExecution" type="{http://www.ekolky.gov.sk/estamp/xsd10}operExecution" maxOccurs="unbounded"/>
 *         &lt;element name="undo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "operExecution",
    "undo"
})
@XmlRootElement(name = "operationExecution_DELTEDRequest")
public class OperationExecutionDELTEDRequest
    extends RequestOEK
{

    @XmlElement(required = true)
    protected Key key;
    @XmlElement(required = true)
    protected List<OperExecution> operExecution;
    protected Boolean undo;

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
     * Gets the value of the operExecution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operExecution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperExecution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperExecution }
     * 
     * 
     */
    public List<OperExecution> getOperExecution() {
        if (operExecution == null) {
            operExecution = new ArrayList<OperExecution>();
        }
        return this.operExecution;
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

}
