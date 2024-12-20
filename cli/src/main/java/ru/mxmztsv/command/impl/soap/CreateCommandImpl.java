package ru.mxmztsv.command.impl.soap;

import ru.mxmztsv.app.model.ClientResponse;
import ru.mxmztsv.app.soap.ClientServiceException_Exception;
import ru.mxmztsv.app.soap.ClientServiceImpl;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.Protocol;
import ru.mxmztsv.command.mapper.ClientMapper;

import java.text.ParseException;
import java.util.Map;

public class CreateCommandImpl implements CommandHandler {

    private final ClientServiceImpl clientService;

    public CreateCommandImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException {
        ClientResponse clientResponse =
                clientService.create(ClientMapper.mapToRequestCreate(ClientMapper.mapKeysToClient(params)));
        System.out.println(ClientMapper.mapToString(clientResponse));
    }

    @Override
    public Command getName() {
        return Command.CREATE;
    }

    @Override
    public Protocol getProtocol() {
        return Protocol.SOAP;
    }
}
