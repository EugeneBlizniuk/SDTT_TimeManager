package by.bsuir.manager.service;

import by.bsuir.manager.bean.User;

public interface ClientService {
    public void signIn(String login, String password);
    public void signOut(String login);
    public void signUp(User user);
}
