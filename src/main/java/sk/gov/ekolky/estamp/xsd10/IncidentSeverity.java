
package sk.gov.ekolky.estamp.xsd10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for incidentSeverity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="incidentSeverity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="debug"/>
 *     &lt;enumeration value="info"/>
 *     &lt;enumeration value="warning"/>
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="critical"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "incidentSeverity")
@XmlEnum
public enum IncidentSeverity {

    @XmlEnumValue("debug")
    DEBUG("debug"),
    @XmlEnumValue("info")
    INFO("info"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("error")
    ERROR("error"),
    @XmlEnumValue("critical")
    CRITICAL("critical");
    private final String value;

    IncidentSeverity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncidentSeverity fromValue(String v) {
        for (IncidentSeverity c: IncidentSeverity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
