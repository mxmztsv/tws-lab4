
package ru.mxmztsv.app.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ClientServiceException complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ClientServiceException"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="errorDto" type="{http://soap.app.mxmztsv.ru/}clientErrorDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientServiceException", propOrder = {
    "errorDto",
    "message"
})
public class ClientServiceException {

    protected ClientErrorDto errorDto;
    protected String message;

    /**
     * Gets the value of the errorDto property.
     * 
     * @return
     *     possible object is
     *     {@link ClientErrorDto }
     *     
     */
    public ClientErrorDto getErrorDto() {
        return errorDto;
    }

    /**
     * Sets the value of the errorDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientErrorDto }
     *     
     */
    public void setErrorDto(ClientErrorDto value) {
        this.errorDto = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
