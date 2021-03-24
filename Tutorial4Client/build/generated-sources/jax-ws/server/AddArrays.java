
package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addArrays complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addArrays">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://server/}doubleArray" minOccurs="0"/>
 *         &lt;element name="b" type="{http://server/}doubleArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addArrays", propOrder = {
    "a",
    "b"
})
public class AddArrays {

    protected DoubleArray a;
    protected DoubleArray b;

    /**
     * Gets the value of the a property.
     * 
     * @return
     *     possible object is
     *     {@link DoubleArray }
     *     
     */
    public DoubleArray getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoubleArray }
     *     
     */
    public void setA(DoubleArray value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     * @return
     *     possible object is
     *     {@link DoubleArray }
     *     
     */
    public DoubleArray getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoubleArray }
     *     
     */
    public void setB(DoubleArray value) {
        this.b = value;
    }

}
