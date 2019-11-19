package by.bsuir.manager.service;

import by.bsuir.manager.entity.User;

public interface ClientService {
    public boolean signIn(String login, String password);
    public boolean signOut(String login);
    public boolean signUp(User user);
}
