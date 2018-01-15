package by.tr.web.service.autorization.impl;

import by.tr.web.dao.DAOFactory;
import by.tr.web.dao.exception.TokenDAOException;
import by.tr.web.entity.Token;
import by.tr.web.service.autorization.TokenService;
import by.tr.web.service.exception.TokenServiceException;

/**
 * Created by cplus on 01.01.2018.
 */
public class TokenServiceImpl implements TokenService {

    @Override
    public boolean accessTokenIsRight(String accessToken) throws TokenServiceException {
        try {
            return DAOFactory.getInstance().getTokenDAO().accessTokenIsRight(accessToken);
        } catch (TokenDAOException e) {
            throw new TokenServiceException(e);
        }
    }

    @Override
    public boolean refreshTokenIsRight(String refreshToken) throws TokenServiceException {
        try {
            return DAOFactory.getInstance().getTokenDAO().refreshTokenIsRight(refreshToken);
        } catch (TokenDAOException e) {
            throw new TokenServiceException(e);
        }
    }

    @Override
    public Token renovateToken(Token token) throws TokenServiceException {
        try {
            return DAOFactory.getInstance().getTokenDAO().renovateToken(token);
        } catch (TokenDAOException e) {
            throw new TokenServiceException(e);
        }
    }

}
