
package ru.mxmztsv.app.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ru.mxmztsv.app.model.ClientRequest;
import ru.mxmztsv.app.model.ClientResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mxmztsv.app.soap package. 
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

    private final static QName _ClientRequest_QNAME = new QName("http://soap.app.mxmztsv.ru/", "ClientRequest");
    private final static QName _ClientResponse_QNAME = new QName("http://soap.app.mxmztsv.ru/", "ClientResponse");
    private final static QName _ClientServiceException_QNAME = new QName("http://soap.app.mxmztsv.ru/", "ClientServiceException");
    private final static QName _Create_QNAME = new QName("http://soap.app.mxmztsv.ru/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://soap.app.mxmztsv.ru/", "createResponse");
    private final static QName _Delete_QNAME = new QName("http://soap.app.mxmztsv.ru/", "delete");
    private final static QName _DeleteResponse_QNAME = new QName("http://soap.app.mxmztsv.ru/", "deleteResponse");
    private final static QName _SearchClients_QNAME = new QName("http://soap.app.mxmztsv.ru/", "searchClients");
    private final static QName _SearchClientsResponse_QNAME = new QName("http://soap.app.mxmztsv.ru/", "searchClientsResponse");
    private final static QName _Update_QNAME = new QName("http://soap.app.mxmztsv.ru/", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://soap.app.mxmztsv.ru/", "updateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mxmztsv.app.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientServiceException }
     * 
     */
    public ClientServiceException createClientServiceException() {
        return new ClientServiceException();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link SearchClients }
     * 
     */
    public SearchClients createSearchClients() {
        return new SearchClients();
    }

    /**
     * Create an instance of {@link SearchClientsResponse }
     * 
     */
    public SearchClientsResponse createSearchClientsResponse() {
        return new SearchClientsResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link ClientErrorDto }
     * 
     */
    public ClientErrorDto createClientErrorDto() {
        return new ClientErrorDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "ClientRequest")
    public JAXBElement<ClientRequest> createClientRequest(ClientRequest value) {
        return new JAXBElement<ClientRequest>(_ClientRequest_QNAME, ClientRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "ClientResponse")
    public JAXBElement<ClientResponse> createClientResponse(ClientResponse value) {
        return new JAXBElement<ClientResponse>(_ClientResponse_QNAME, ClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientServiceException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientServiceException }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "ClientServiceException")
    public JAXBElement<ClientServiceException> createClientServiceException(ClientServiceException value) {
        return new JAXBElement<ClientServiceException>(_ClientServiceException_QNAME, ClientServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Create }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClients }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchClients }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "searchClients")
    public JAXBElement<SearchClients> createSearchClients(SearchClients value) {
        return new JAXBElement<SearchClients>(_SearchClients_QNAME, SearchClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClientsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchClientsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "searchClientsResponse")
    public JAXBElement<SearchClientsResponse> createSearchClientsResponse(SearchClientsResponse value) {
        return new JAXBElement<SearchClientsResponse>(_SearchClientsResponse_QNAME, SearchClientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.app.mxmztsv.ru/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

}
