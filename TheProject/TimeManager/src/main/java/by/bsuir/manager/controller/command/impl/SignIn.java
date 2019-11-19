package by.bsuir.manager.controller.command.impl;

import by.bsuir.manager.controller.command.Command;
import by.bsuir.manager.service.ClientService;
import by.bsuir.manager.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;

        //get parameters from request and initialize the variables login and password

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        clientService.signIn(login, password);
        response = "(SignIn)Welcome!";

        return response;
    }
}
