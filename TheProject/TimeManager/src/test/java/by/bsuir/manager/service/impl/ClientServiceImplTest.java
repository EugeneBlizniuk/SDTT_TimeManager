package by.bsuir.manager.service.impl;

import by.bsuir.manager.entity.User;
import by.bsuir.manager.service.ClientService;
import by.bsuir.manager.service.factory.ServiceFactory;
import org.junit.jupiter.api.Test;

import static by.bsuir.manager.constants.Constants.CORRECT_PASSWORD;
import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {
    private ClientService client = ServiceFactory.getInstance().getClientService();

    @Test
    void signIn() {
        String login = "anotherOne";
        String password = "321";

        assertEquals(CORRECT_PASSWORD, client.signIn(login, password));
    }

    @Test
    void signUp() {
        assertFalse(client.signUp(new User("anotherOne", "321")));
    }
}