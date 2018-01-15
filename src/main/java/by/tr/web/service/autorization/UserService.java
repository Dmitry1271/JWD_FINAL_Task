package by.tr.web.service.autorization;

import by.tr.web.entity.Token;
import by.tr.web.entity.User;
import by.tr.web.service.exception.ServiceException;
import by.tr.web.service.exception.UserServiceException;

import java.util.List;

/**
 * Created by cplus on 16.11.2017.
 */
public interface UserService {
    Token logination(String login, String password) throws UserServiceException;

    boolean successRegistration(List registerInfo) throws UserServiceException;
}
