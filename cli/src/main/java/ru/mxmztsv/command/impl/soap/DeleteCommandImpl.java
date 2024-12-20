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
import java.util.Map;


public class DeleteCommandImpl implements CommandHandler {

    private final ClientServiceImpl clientService;

    public DeleteCommandImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException {
        Client client = ClientMapper.mapKeysToClient(params);
        if (client.getId() != null) {
            clientService.delete(client.getId());
        } else {
            throw new RuntimeException("Id is null");
        }
    }

    @Override
    public Command getName() {
        return Command.DELETE;
    }

    @Override
    public Protocol getProtocol() {
        return Protocol.SOAP;
    }
}
