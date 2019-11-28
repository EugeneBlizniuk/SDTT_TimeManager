package by.bsuir.manager.dao;

import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.entity.User;

import java.util.List;

public interface UserDAO extends DAOCloseable<String, User>{
    public boolean signIn(String login, String password) throws DAOException;
    public boolean signUp(User user);
    public List<User> findUserByLogin(String patternName) throws DAOException;
}
