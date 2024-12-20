package ru.mxmztsv.command.impl.soap;

import ru.mxmztsv.app.soap.ClientServiceException_Exception;
import ru.mxmztsv.app.soap.ClientServiceImpl;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.Protocol;
import ru.mxmztsv.command.mapper.ClientMapper;
import ru.mxmztsv.model.Client;

import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchCommandImpl implements CommandHandler {
    private final ClientServiceImpl clientService;

    public SearchCommandImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException {
        Client client = ClientMapper.mapKeysToClient(params);
        String clients = Optional.ofNullable(
                        clientService.searchClients(client.getFirstName(), client.getLastName(),
                                client.getStatus(), client.getCategory(), client.getCreatedAt()
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
        return Protocol.SOAP;
    }
}
