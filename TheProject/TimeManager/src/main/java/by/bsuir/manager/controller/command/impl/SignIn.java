package by.bsuir.manager.controller.command.impl;

import by.bsuir.manager.controller.command.Command;
import by.bsuir.manager.entity.User;
import by.bsuir.manager.service.ClientService;
import by.bsuir.manager.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String[] list = RegExParser.parseCommand(request);
        String response;
        String login = list[1];
        String password = list[2];

        ClientService client = ServiceFactory.getInstance().getClientService();

        response = client.signIn(login, password);

        return response;
    }
}
