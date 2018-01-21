package by.tr.web.service.autorization.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.authorization.UserDAO;
import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.entity.Token;
import by.tr.web.entity.User;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.exception.UserServiceException;
import by.tr.web.service.exception.valid.InvalidUserInfoException;
import by.tr.web.service.valid.ValidatorDirector;
import by.tr.web.service.valid.ValidatorName;
import by.tr.web.service.valid.util.RegisterInfoValidator;
import by.tr.web.service.valid.util.UserInfoValidator;

import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public class UserServiceImpl implements UserService {
    private static final int LOGIN = 0;

    @Override
    public Token logination(String login, String password) throws UserServiceException {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        if (validatorDirector.takeValidator(ValidatorName.LOGIN).isValidData(login) &&
                validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData(password)) {

            DAOFactory instance = DAOFactory.getInstance();
            UserDAO userDAO = instance.getUserDAO();

            try {
                return userDAO.logination(login, password);
            } catch (UserDAOException e) {
                throw new UserServiceException(e);
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean successRegistration(List registerInfo) throws UserServiceException {
        if (RegisterInfoValidator.isValidData(registerInfo)) {

            DAOFactory instance = DAOFactory.getInstance();
            UserDAO userDAO = instance.getUserDAO();

            try {
                return !userDAO.existsLogin((String) registerInfo.get(LOGIN)) && userDAO.successRegistration(registerInfo);
            } catch (UserDAOException e) {
                throw new UserServiceException(e);
            }
        }
        return false;
    }

    @Override
    public User getUser(Integer userId) throws UserServiceException {
        DAOFactory instance = DAOFactory.getInstance();
        try {
            return instance.getUserDAO().getUser(userId);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }

    @Override
    public void updateUser(Integer userId, List userInfo) throws InvalidUserInfoException, UserDAOException {
        if (UserInfoValidator.isValidData(userInfo)) {
            DAOFactory instance = DAOFactory.getInstance();
            instance.getUserDAO().updateUser(userId, userInfo);
        } else {
            throw new InvalidUserInfoException("Invalid user info");
        }
    }

    @Override
    public boolean updatePassword(Integer userId, String oldPassword, String newPassword, String confirmPassword) throws UserServiceException {
        ValidatorDirector validatorDirector = new ValidatorDirector();
        DAOFactory instance = DAOFactory.getInstance();
        try {
            if (oldPassword != null && validatorDirector.takeValidator(ValidatorName.PASSWORD).isValidData(newPassword) &&
                    newPassword.equals(confirmPassword) && instance.getUserDAO().matchPassword(userId, oldPassword)) {

                instance.getUserDAO().updatePassword(userId, newPassword);
                return true;

            } else {
                return false;
            }
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }
}
