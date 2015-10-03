
package sk.gov.ekolky.estamp.fo10.aponet;

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
 *         &lt;element name="reservedUndo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "reservedUndo"
})
@XmlRootElement(name = "refundReserveUndoResponse")
public class RefundReserveUndoResponse
    extends Response
{

    protected boolean reservedUndo;

    /**
     * Gets the value of the reservedUndo property.
     * 
     */
    public boolean isReservedUndo() {
        return reservedUndo;
    }

    /**
     * Sets the value of the reservedUndo property.
     * 
     */
    public void setReservedUndo(boolean value) {
        this.reservedUndo = value;
    }

}
