
package sk.gov.ekolky.estamp.fo10.assessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import sk.gov.ekolky.estamp.xsd10.Assessment;
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
 *         &lt;element name="assessment" type="{http://www.ekolky.gov.sk/estamp/xsd10}assessment"/>
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
    "assessment"
})
@XmlRootElement(name = "getResponse")
public class GetResponse
    extends Response
{

    @XmlElement(required = true)
    protected Assessment assessment;

    /**
     * Gets the value of the assessment property.
     * 
     * @return
     *     possible object is
     *     {@link Assessment }
     *     
     */
    public Assessment getAssessment() {
        return assessment;
    }

    /**
     * Sets the value of the assessment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Assessment }
     *     
     */
    public void setAssessment(Assessment value) {
        this.assessment = value;
    }

}
