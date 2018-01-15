package by.tr.web.service.autorization;

import by.tr.web.entity.Token;
import by.tr.web.service.exception.TokenServiceException;

/**
 * Created by cplus on 01.01.2018.
 */
public interface TokenService {
    boolean accessTokenIsRight(String accessToken) throws TokenServiceException;
    boolean refreshTokenIsRight(String refreshToken) throws TokenServiceException;
    Token renovateToken(Token token) throws TokenServiceException;
}
