package by.bsuir.manager.service.impl;

import by.bsuir.manager.dao.UserDAO;
import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.dao.factory.DAOFactory;
import by.bsuir.manager.entity.User;
import by.bsuir.manager.service.ClientService;

import static by.bsuir.manager.constants.Constants.CORRECT_PASSWORD;

public class ClientServiceImpl implements ClientService {
    @Override
    public String signIn(String login, String password) {
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        try {
            if(!userDAO.isExisting(login)) {
                return login;
            } else {
                if(!userDAO.signIn(login, password)) {
                    return password;
                }
            }
        } catch (DAOException e) {
            //log
            e.printStackTrace();
        }

        return CORRECT_PASSWORD;
    }

    @Override
    public boolean signOut(String login) {
        return false;
    }

    @Override
    public boolean signUp(User user) {
        boolean isAdded = false;
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        try {
            if(!userDAO.isExisting(user.getLogin())) {
                isAdded = userDAO.signUp(user);
            }
        } catch (DAOException e) {
            //log
            e.printStackTrace();
        }

        return isAdded;
    }
}
