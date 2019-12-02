package by.bsuir.manager.service;

import by.bsuir.manager.entity.User;

public interface ClientService {
    public String signIn(String login, String password);
    public boolean signOut(String login);
    public boolean signUp(User user);
}
