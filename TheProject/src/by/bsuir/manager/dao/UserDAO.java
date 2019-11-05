package by.bsuir.manager.dao;

import by.bsuir.manager.bean.User;

public interface UserDAO {
    public void signIn(String login, String password);
    public void signUp(User user);
}
