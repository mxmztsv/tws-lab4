package ru.mxmztsv.command.impl;

import ru.mxmztsv.app.soap.ClientServiceException_Exception;
import ru.mxmztsv.command.*;

import java.text.ParseException;
import java.util.Map;

public class SetProtocol implements CommandHandler {

    private final CommandAnalyzer analyzer;

    public SetProtocol(CommandAnalyzer analyzer) {
        this.analyzer = analyzer;
    }


    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException {
        analyzer.setProtocol(Protocol.valueOf(params.get(Key.PROTOCOL).toUpperCase()));
        System.out.println("Protocol update: " + analyzer.getProtocol());
    }

    @Override
    public Command getName() {
        return Command.PROTOCOL;
    }

    @Override
    public Protocol getProtocol() {
        return Protocol.NO;
    }
}
