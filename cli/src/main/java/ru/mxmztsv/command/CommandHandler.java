package ru.mxmztsv.command;


import ru.mxmztsv.app.soap.ClientServiceException_Exception;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Map;

public interface CommandHandler {
    void execute(Map<Key, String> params) throws ClientServiceException_Exception, ParseException, URISyntaxException, IOException, InterruptedException, ru.mxmztsv.app.soap.ClientServiceException_Exception;

    Command getName();

    Protocol getProtocol();
}
