package by.bsuir.manager.service.impl;

import by.bsuir.manager.dao.UserDAO;
import by.bsuir.manager.dao.exception.DAOException;
import by.bsuir.manager.dao.factory.DAOFactory;
import by.bsuir.manager.entity.User;
import by.bsuir.manager.service.ClientService;

public class ClientServiceImpl implements ClientService {
    @Override
    public boolean signIn(String login, String password) {
        return false;
    }

    @Override
    public boolean signOut(String login) {
        return false;
    }

    @Override
    public boolean signUp(User user) {
        boolean isAdded = false;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
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
