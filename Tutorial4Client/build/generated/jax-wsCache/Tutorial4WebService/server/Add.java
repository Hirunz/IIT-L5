
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for add complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="add">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="num1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="num2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "num1",
    "num2"
})
public class Add {

    protected Double num1;
    protected Double num2;

    /**
     * Gets the value of the num1 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNum1() {
        return num1;
    }

    /**
     * Sets the value of the num1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNum1(Double value) {
        this.num1 = value;
    }

    /**
     * Gets the value of the num2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNum2() {
        return num2;
    }

    /**
     * Sets the value of the num2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNum2(Double value) {
        this.num2 = value;
    }

}
