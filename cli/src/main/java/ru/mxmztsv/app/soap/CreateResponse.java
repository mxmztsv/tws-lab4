
package ru.mxmztsv.app.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.mxmztsv.app.model.ClientResponse;


/**
 * &lt;p&gt;Java class for createResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="createResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://app.mxmztsv.ru/}ClientResponse" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createResponse", propOrder = {
    "clientResponse"
})
public class CreateResponse {

    @XmlElement(name = "ClientResponse", namespace = "http://app.mxmztsv.ru/")
    protected ClientResponse clientResponse;

    /**
     * Gets the value of the clientResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ClientResponse }
     *     
     */
    public ClientResponse getClientResponse() {
        return clientResponse;
    }

    /**
     * Sets the value of the clientResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientResponse }
     *     
     */
    public void setClientResponse(ClientResponse value) {
        this.clientResponse = value;
    }

}
