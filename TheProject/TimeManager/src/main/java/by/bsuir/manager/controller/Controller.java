package by.bsuir.manager.controller;

import by.bsuir.manager.controller.command.Command;
import by.bsuir.manager.controller.provider.CommandProvider;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimiter = '-';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);
        System.out.println(request);
        System.out.println(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
