package ru.mxmztsv.command.impl.rest;

import ru.mxmztsv.client.WebClientImpl;
import ru.mxmztsv.client.model.Category;
import ru.mxmztsv.client.model.Status;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.Protocol;
import ru.mxmztsv.command.mapper.ClientMapper;
import ru.mxmztsv.model.Client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchCommandRestImpl implements CommandHandler {
    private final WebClientImpl webClient;

    public SearchCommandRestImpl(WebClientImpl webClient) {
        this.webClient = webClient;
    }

    @Override
    public void execute(Map<Key, String> params) throws ParseException, URISyntaxException, IOException, InterruptedException {
        Client client = ClientMapper.mapKeysToClient(params);
        String clients = Optional.ofNullable(
                        webClient.search(client.getFirstName(), client.getLastName(),
                                client.getStatus() != null
                                        ? Status.valueOf(client.getStatus().name())
                                        : null,
                                client.getCategory() != null
                                        ? Category.valueOf(client.getCategory().name())
                                        : null,
                                client.getCreatedAt()
                        ).getResponseModelList()
                ).stream()
                .flatMap(Collection::stream)
                .map(ClientMapper::mapToString)
                .collect(Collectors.joining("\n"));
        if (clients.isEmpty()) {
            System.out.println("Нет клиентов, соответствующих заданным параметрам.");
        } else {
            System.out.println(clients);
        }

    }

    @Override
    public Command getName() {
        return Command.SEARCH;
    }

    @Override
    public Protocol getProtocol() {
        return Protocol.REST;
    }
}
