package by.tr.web.dao.authorization;

import by.tr.web.dao.exception.TokenDAOException;
import by.tr.web.entity.Token;

/**
 * Created by cplus on 25.12.2017.
 */
public interface TokenDAO {
    boolean refreshTokenIsRight(String refreshToken) throws TokenDAOException;

    boolean accessTokenIsRight(String accessToken)throws TokenDAOException;

    Token renovateToken(Token token) throws TokenDAOException;
}
