
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assesmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="assesmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="spravny"/>
 *     &lt;enumeration value="sudny"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "assesmentType")
@XmlEnum
public enum AssesmentType {

    @XmlEnumValue("spravny")
    SPRAVNY("spravny"),
    @XmlEnumValue("sudny")
    SUDNY("sudny");
    private final String value;

    AssesmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssesmentType fromValue(String v) {
        for (AssesmentType c: AssesmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
