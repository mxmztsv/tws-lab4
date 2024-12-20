
package ru.mxmztsv.app.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.mxmztsv.app.ClientSearchResponseType;


/**
 * &lt;p&gt;Java class for searchClientsResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="searchClientsResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://app.mxmztsv.ru/}ClientSearchResponse" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchClientsResponse", propOrder = {
    "clientSearchResponse"
})
public class SearchClientsResponse {

    @XmlElement(name = "ClientSearchResponse", namespace = "http://app.mxmztsv.ru/")
    protected ClientSearchResponseType clientSearchResponse;

    /**
     * Gets the value of the clientSearchResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ClientSearchResponseType }
     *     
     */
    public ClientSearchResponseType getClientSearchResponse() {
        return clientSearchResponse;
    }

    /**
     * Sets the value of the clientSearchResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientSearchResponseType }
     *     
     */
    public void setClientSearchResponse(ClientSearchResponseType value) {
        this.clientSearchResponse = value;
    }

}
