package ru.mxmztsv.command;

import ru.mxmztsv.app.soap.ClientService;
import ru.mxmztsv.client.WebClientImpl;
import ru.mxmztsv.command.impl.ExitCommandImpl;
import ru.mxmztsv.command.impl.HelpCommandImpl;
import ru.mxmztsv.command.impl.SetProtocol;
import ru.mxmztsv.command.impl.rest.SearchCommandRestImpl;
import ru.mxmztsv.command.impl.soap.CreateCommandImpl;
import ru.mxmztsv.command.impl.soap.DeleteCommandImpl;
import ru.mxmztsv.command.impl.soap.SearchCommandImpl;
import ru.mxmztsv.command.impl.soap.UpdateCommandImpl;

import java.util.*;

public class CommandAnalyzer {

    private static Protocol protocol = Protocol.REST;

    private static WebClientImpl client = new WebClientImpl();

    private final Map<Command, List<CommandHandler>> commandHandlers = new HashMap<>();

    public CommandAnalyzer() {
        ClientService service = new ClientService();
        SearchCommandImpl searchCommand = new SearchCommandImpl(service.getClientServicePort());
        DeleteCommandImpl deleteCommand = new DeleteCommandImpl(service.getClientServicePort());
        CreateCommandImpl createCommand = new CreateCommandImpl(service.getClientServicePort());
        UpdateCommandImpl updateCommand = new UpdateCommandImpl(service.getClientServicePort());
        SearchCommandRestImpl searchRestCommand = new SearchCommandRestImpl(client);
        HelpCommandImpl helpCommand = new HelpCommandImpl();
        ExitCommandImpl exitCommand = new ExitCommandImpl();
        SetProtocol setProtocol = new SetProtocol(this);
        commandHandlers.put(searchCommand.getName(), List.of(searchCommand, searchRestCommand));
        commandHandlers.put(deleteCommand.getName(), List.of(deleteCommand));
        commandHandlers.put(createCommand.getName(), List.of(createCommand));
        commandHandlers.put(updateCommand.getName(), List.of(updateCommand));
        commandHandlers.put(helpCommand.getName(), List.of(helpCommand));
        commandHandlers.put(exitCommand.getName(), List.of(exitCommand));
        commandHandlers.put(setProtocol.getName(), List.of(setProtocol));
    }

    public Optional<CommandHandler> handler(String command) {
        Optional<Command> commandExecute = Arrays.stream(Command.values())
                .filter(it -> it.getCommandName().equals(command)).findFirst();
        return commandExecute.flatMap(this::findCommandHandler);
    }

    public void setProtocol(Protocol protocol) {
        CommandAnalyzer.protocol = protocol;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    private Optional<CommandHandler> findCommandHandler(Command command) {
        return commandHandlers.get(command).stream()
                .filter(it -> it.getProtocol().equals(protocol) || it.getProtocol().equals(Protocol.NO))
                .findFirst();
    }
}
