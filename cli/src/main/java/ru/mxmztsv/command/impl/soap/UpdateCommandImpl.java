package ru.mxmztsv.command.impl.soap;

import ru.mxmztsv.app.model.ClientResponse;
import ru.mxmztsv.app.soap.ClientServiceException_Exception;
import ru.mxmztsv.app.soap.ClientServiceImpl;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.Protocol;
import ru.mxmztsv.command.mapper.ClientMapper;
import ru.mxmztsv.model.Client;

import java.text.ParseException;
import java.util.Map;


public class UpdateCommandImpl implements CommandHandler {

    private final ClientServiceImpl clientService;

    public UpdateCommandImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException {
        Client client = ClientMapper.mapKeysToClient(params);
        ClientResponse response =
                clientService.update(client.getId(), ClientMapper.mapToRequestCreate(client));
        System.out.println(ClientMapper.mapToString(response));
    }

    @Override
    public Command getName() {
        return Command.UPDATE;
    }

    @Override
    public Protocol getProtocol() {
        return Protocol.SOAP;
    }
}
