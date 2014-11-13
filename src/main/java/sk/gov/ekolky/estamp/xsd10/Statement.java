
package sk.gov.ekolky.estamp.xsd10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for statement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ElctrncSeqNb" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="LglSeqNb" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="CreDtTm" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FrToDt" type="{http://www.ekolky.gov.sk/estamp/xsd10}FrToDt"/>
 *         &lt;element name="Acct" type="{http://www.ekolky.gov.sk/estamp/xsd10}Acct"/>
 *         &lt;element name="Bal" type="{http://www.ekolky.gov.sk/estamp/xsd10}Bal" maxOccurs="unbounded"/>
 *         &lt;element name="TxsSummry" type="{http://www.ekolky.gov.sk/estamp/xsd10}TxsSummry"/>
 *         &lt;element name="Ntry" type="{http://www.ekolky.gov.sk/estamp/xsd10}Ntry" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statement", propOrder = {
    "id",
    "elctrncSeqNb",
    "lglSeqNb",
    "creDtTm",
    "frToDt",
    "acct",
    "bal",
    "txsSummry",
    "ntry"
})
public class Statement {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "ElctrncSeqNb", required = true)
    protected BigInteger elctrncSeqNb;
    @XmlElement(name = "LglSeqNb", required = true)
    protected BigInteger lglSeqNb;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "FrToDt", required = true)
    protected FrToDt frToDt;
    @XmlElement(name = "Acct", required = true)
    protected Acct acct;
    @XmlElement(name = "Bal", required = true)
    protected List<Bal> bal;
    @XmlElement(name = "TxsSummry", required = true)
    protected TxsSummry txsSummry;
    @XmlElement(name = "Ntry", required = true)
    protected List<Ntry> ntry;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the elctrncSeqNb property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElctrncSeqNb() {
        return elctrncSeqNb;
    }

    /**
     * Sets the value of the elctrncSeqNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElctrncSeqNb(BigInteger value) {
        this.elctrncSeqNb = value;
    }

    /**
     * Gets the value of the lglSeqNb property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLglSeqNb() {
        return lglSeqNb;
    }

    /**
     * Sets the value of the lglSeqNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLglSeqNb(BigInteger value) {
        this.lglSeqNb = value;
    }

    /**
     * Gets the value of the creDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * Sets the value of the creDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * Gets the value of the frToDt property.
     * 
     * @return
     *     possible object is
     *     {@link FrToDt }
     *     
     */
    public FrToDt getFrToDt() {
        return frToDt;
    }

    /**
     * Sets the value of the frToDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrToDt }
     *     
     */
    public void setFrToDt(FrToDt value) {
        this.frToDt = value;
    }

    /**
     * Gets the value of the acct property.
     * 
     * @return
     *     possible object is
     *     {@link Acct }
     *     
     */
    public Acct getAcct() {
        return acct;
    }

    /**
     * Sets the value of the acct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Acct }
     *     
     */
    public void setAcct(Acct value) {
        this.acct = value;
    }

    /**
     * Gets the value of the bal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bal }
     * 
     * 
     */
    public List<Bal> getBal() {
        if (bal == null) {
            bal = new ArrayList<Bal>();
        }
        return this.bal;
    }

    /**
     * Gets the value of the txsSummry property.
     * 
     * @return
     *     possible object is
     *     {@link TxsSummry }
     *     
     */
    public TxsSummry getTxsSummry() {
        return txsSummry;
    }

    /**
     * Sets the value of the txsSummry property.
     * 
     * @param value
     *     allowed object is
     *     {@link TxsSummry }
     *     
     */
    public void setTxsSummry(TxsSummry value) {
        this.txsSummry = value;
    }

    /**
     * Gets the value of the ntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ntry }
     * 
     * 
     */
    public List<Ntry> getNtry() {
        if (ntry == null) {
            ntry = new ArrayList<Ntry>();
        }
        return this.ntry;
    }

}
