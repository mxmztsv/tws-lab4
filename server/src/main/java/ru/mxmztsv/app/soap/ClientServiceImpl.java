package ru.mxmztsv.app.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lombok.extern.slf4j.Slf4j;
import ru.mxmztsv.app.domain.DatabaseExecutor;
import ru.mxmztsv.app.domain.Client;
import ru.mxmztsv.app.soap.exception.ClientServiceException;
import ru.mxmztsv.model.Category;
import ru.mxmztsv.model.Status;
import ru.mxmztsv.model.soap.ClientRequest;
import ru.mxmztsv.model.soap.ClientResponse;
import ru.mxmztsv.model.soap.ClientSearchResponse;
import ru.mxmztsv.model.soap.SearchClientsResponseModel;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@WebService(serviceName = "ClientService", portName = "ClientServicePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ClientServiceImpl {

    private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final DatabaseExecutor databaseExecutor;

    public ClientServiceImpl(DataSource dataSource) {
        this.databaseExecutor = new DatabaseExecutor(dataSource);
    }

    @WebMethod
    @WebResult(name = "ClientSearchResponse", targetNamespace = "http://app.mxmztsv.ru/")
    public ClientSearchResponse searchClients(
            @WebParam(name = "firstName")
            String firstName,
            @WebParam(name = "lastName")
            String lastName,
            @WebParam(name = "status")
            Status status,
            @WebParam(name = "category")
            Category category,
            @WebParam(name = "data")
            String data
    ) throws ClientServiceException {
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM Clients WHERE 1=1");
            List<Object> params = new ArrayList<>();
            addStringParam(firstName, "first_name", query, params);
            addStringParam(lastName, "last_name", query, params);
            if (data != null && !data.isEmpty()) {
                addStringParamDate(DATA_FORMAT.format(DATA_FORMAT.parse(data)), "created_at", query, params);
            }
            addEnumParam(status, "status", query, params);
            addEnumParam(category, "category", query, params);
            return ClientSearchResponse.builder()
                    .responseModelList(databaseExecutor.executeSelect(query.toString(), params).stream()
//                            .map(ClientServiceImpl::mapToSearchResponse).toList())
                            .map(ClientServiceImpl::mapToSearchResponse).collect(Collectors.toList()))
                    .build();
        } catch (ParseException e) {
            throw new ClientServiceException("Error parse field date", 400);
        }
    }

    @WebMethod
    @WebResult(name = "ClientResponse", targetNamespace = "http://app.mxmztsv.ru/")
    public ClientResponse create(@WebParam(name = "request") ClientRequest request) throws ClientServiceException {
        if (request == null) {
            throw new ClientServiceException("request is null");
        }
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new ClientServiceException("FirstName is null or empty", 400);
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new ClientServiceException("LastName is null or empty", 400);
        }
        if (request.getStatus() == null) {
            throw new ClientServiceException("Status is null or empty", 400);
        }
        if (request.getCategory() == null) {
            throw new ClientServiceException("Category is null or empty", 400);
        }
        if (request.getCreatedAt() == null || request.getCreatedAt().isEmpty()) {
            throw new ClientServiceException("CreatedAt is null or empty", 400);
        }
        StringBuilder query = new StringBuilder(
                "INSERT INTO Clients (first_name, last_name, status, category, created_at) values ("
        );
        query.append("'").append(request.getFirstName()).append("'");
        query.append(", '").append(request.getLastName()).append("'");
        query.append(", '").append(request.getStatus()).append("'");
        query.append(", '").append(request.getCategory()).append("'");
        query.append(", '").append(request.getCreatedAt()).append("'");
        query.append(")");
        Client client = databaseExecutor.executeQuery(query.toString());
        log.info("Client created: {}", client.getId());
        return client != null ? mapToClientResponse(client) : null;
    }

    @WebMethod
    @WebResult(name = "ClientResponse", targetNamespace = "http://app.mxmztsv.ru/")
    public ClientResponse update(
            @WebParam(name = "id") Long id,
            @WebParam(name = "request") ClientRequest request
    ) throws ClientServiceException {
        if (id == null) {
            throw new ClientServiceException("Id was not be null", 400);
        }
        String queryUpdateParams = request.toQueryStringUpdate();
        if(queryUpdateParams.isEmpty()){
            throw new ClientServiceException("Empty update", 400);
        }
        StringBuilder query = new StringBuilder("UPDATE Clients SET ").append(queryUpdateParams)
                .append(" WHERE ID = ").append(id);
        Client client = databaseExecutor.executeQuery(query.toString());
        return client != null ? mapToClientResponse(client) : null;
    }

    @WebMethod
    public void delete(
            @WebParam(name = "id") Long id
    ) throws ClientServiceException {
        if (id == null) {
            throw new ClientServiceException("Id was not be null", 400);
        }
        databaseExecutor.executeQueryEmpty("DELETE FROM Clients WHERE ID = " + id);
    }

    private void addStringParam(String value, String name, StringBuilder query, List<Object> params) {
        if (value != null && !value.isEmpty()) {
            query.append(" AND ").append(name).append(" = ?");
            params.add(value);
        }
    }

    private void addStringParamDate(String value, String name, StringBuilder query, List<Object> params) {
        if (value != null && !value.isEmpty()) {
            query.append(" AND ").append(name).append(" = CAST(? AS DATE)");
            params.add(value);
        }
    }

    private void addEnumParam(Object value, String name, StringBuilder query, List<Object> params) {
        if (value != null) {
            query.append(" AND ").append(name).append(" = ?");
            params.add(value);
        }
    }

    private static SearchClientsResponseModel mapToSearchResponse(Client client) {
        return SearchClientsResponseModel.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .status(Status.valueOf(client.getStatus()))
                .category(Category.valueOf(client.getCategory()))
                .createdAt(DATA_FORMAT.format(client.getCreatedAt()))
                .build();
    }

    private static ClientResponse mapToClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .status(Status.valueOf(client.getStatus()))
                .category(Category.valueOf(client.getCategory()))
                .createdAt(DATA_FORMAT.format(client.getCreatedAt()))
                .build();
    }
}


