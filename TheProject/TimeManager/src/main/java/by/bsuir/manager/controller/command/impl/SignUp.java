package by.bsuir.manager.controller.command.impl;

import by.bsuir.manager.controller.command.Command;
import by.bsuir.manager.entity.User;
import by.bsuir.manager.service.ClientService;
import by.bsuir.manager.service.factory.ServiceFactory;

public class SignUp implements Command {
    @Override
    public String execute(String request) {
        if(!request.contains("-")) {
            //log
            throw new IllegalArgumentException("Request: " + request + " does not contain '-' ");
        }
        String[] list = request.split("[-]+");
        String response = null;
        String login = list[1];
        String password = list[2];

        User user = new User(login, password);

        ServiceFactory factory = ServiceFactory.getInstance();
        ClientService client = factory.getClientService();

        if(client.signUp(user)) {
            response = "Added!";
        } else {
            response = "Did not add: " + user.getLogin();
        }

        return response;
    }
}
