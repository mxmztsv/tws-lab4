package ru.mxmztsv.app.rest;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import ru.mxmztsv.app.domain.DatabaseExecutor;
import ru.mxmztsv.app.domain.Client;
import ru.mxmztsv.app.rest.model.ClientResponseDto;
import ru.mxmztsv.app.rest.model.ClientSearchResponseDto;
import ru.mxmztsv.app.soap.exception.ClientServiceException;
import ru.mxmztsv.model.Category;
import ru.mxmztsv.model.Status;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientRestService {

    private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final DatabaseExecutor databaseExecutor;

    @Inject
    public ClientRestService(ServletContext context) {
        this.databaseExecutor = new DatabaseExecutor((DataSource) context.getAttribute("dataSource"));
    }

    @GET
    @Path("/search")
    public Response searchClients(
            @QueryParam("firstName") @DefaultValue("") String firstName,
            @QueryParam("lastName") @DefaultValue("") String lastName,
            @QueryParam("status") Status status,
            @QueryParam("category") Category category,
            @QueryParam("createdAt") @DefaultValue("") String createdAt
    ) throws ClientServiceException {
        log.info("searchClients with : {} {} {} {} {}", firstName, lastName, status, category, createdAt);
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM Clients WHERE 1=1");
            List<Object> params = new ArrayList<>();
            addStringParam(firstName, "first_name", query, params);
            addStringParam(lastName, "last_name", query, params);
            if (createdAt != null && !createdAt.isEmpty()) {
                addStringParamDate(DATA_FORMAT.format(DATA_FORMAT.parse(createdAt)), "created_at", query, params);
            }
            addEnumParam(status, "status", query, params);
            addEnumParam(category, "category", query, params);
            List<Client> clients = databaseExecutor.executeSelect(query.toString(), params);
            return Response.ok(
                    ClientSearchResponseDto.builder()
                            .responseModelList(clients.stream().map(this::mapToClientResponse).collect(Collectors.toList()))
                            .build()
            ).build();
        } catch (ParseException e) {
            throw new ClientServiceException("Error parsing createdAt", 400);
        }
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

    private ClientResponseDto mapToClientResponse(Client client) {
        return ClientResponseDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .status(Status.valueOf(client.getStatus()))
                .category(Category.valueOf(client.getCategory()))
                .createdAt(DATA_FORMAT.format(client.getCreatedAt()))
                .build();
    }

}
