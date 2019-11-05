package by.bsuir.manager.controller.provider;

import by.bsuir.manager.controller.command.Command;
import by.bsuir.manager.controller.command.CommandName;
import by.bsuir.manager.controller.command.impl.SignIn;
import by.bsuir.manager.controller.command.impl.SignUp;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.SIGN_UP, new SignUp());
    }

    public Command getCommand(String name) {
        Command command = null;

        try {
            command = repository.get(CommandName.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException e) {
            //write log
        }

        return command;
    }
}
