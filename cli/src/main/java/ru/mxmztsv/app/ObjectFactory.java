
package ru.mxmztsv.app;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ru.mxmztsv.app.model.ClientResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mxmztsv.app package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClientResponse_QNAME = new QName("http://app.mxmztsv.ru/", "ClientResponse");
    private final static QName _ClientSearchResponse_QNAME = new QName("http://app.mxmztsv.ru/", "ClientSearchResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mxmztsv.app
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientSearchResponseType }
     * 
     */
    public ClientSearchResponseType createClientSearchResponseType() {
        return new ClientSearchResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "ClientResponse")
    public JAXBElement<ClientResponse> createClientResponse(ClientResponse value) {
        return new JAXBElement<ClientResponse>(_ClientResponse_QNAME, ClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientSearchResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientSearchResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "ClientSearchResponse")
    public JAXBElement<ClientSearchResponseType> createClientSearchResponse(ClientSearchResponseType value) {
        return new JAXBElement<ClientSearchResponseType>(_ClientSearchResponse_QNAME, ClientSearchResponseType.class, null, value);
    }

}
