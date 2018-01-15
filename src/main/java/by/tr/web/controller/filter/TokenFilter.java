package by.tr.web.controller.filter;

import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.exception.EmptyCookieException;
import by.tr.web.exception.IncorrectTokenException;
import by.tr.web.util.TokenHelper;
import by.tr.web.entity.Role;
import by.tr.web.entity.Token;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.autorization.TokenService;
import by.tr.web.service.exception.TokenServiceException;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 22.12.2017.
 */
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            checkTokens(request, response);
        } catch (EmptyCookieException | IncorrectTokenException | TokenServiceException e) {
            //бросать на вход
            e.printStackTrace();
            System.out.println("DO LOGGING!");
        }


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void checkTokens(HttpServletRequest request, HttpServletResponse response) throws TokenServiceException, EmptyCookieException, IncorrectTokenException {
        HttpSession session = request.getSession();
        Object roleValue = session.getAttribute(AttributeConstant.ROLE);
        Cookie[] cookies = request.getCookies();

        if (roleValue == null) {
            session.setAttribute(AttributeConstant.ROLE, Role.GUEST);
            return;
        }
        if (roleValue.equals(Role.GUEST)) {
            return;
        }
        Token token = TokenHelper.createTokenFromCookieData(cookies);

        ServiceFactory instance = ServiceFactory.getInstance();
        TokenService tokenService = instance.getTokenService();

        if (tokenService.accessTokenIsRight(token.getAccessToken())) {
            System.out.println("ACCESS+");
            return;
        }
        if (tokenService.refreshTokenIsRight(token.getRefreshToken())) {
            System.out.println("REFRESH+");
            Token newToken = tokenService.renovateToken(token);
            if (newToken != null) {
                response.addCookie(new Cookie(AttributeConstant.ACCESS_TOKEN, newToken.getAccessToken()));
                response.addCookie(new Cookie(AttributeConstant.REFRESH_TOKEN, newToken.getRefreshToken()));

                session.setAttribute(AttributeConstant.ID, TokenHelper.parseId(newToken));
                session.setAttribute(AttributeConstant.ROLE, TokenHelper.parseRole(newToken));
            }
            return;
        }
        System.out.println("EXIT TO LOGIN");
        session.removeAttribute(AttributeConstant.ID);
        session.setAttribute(AttributeConstant.ROLE, Role.GUEST);
        TokenHelper.removeTokenFromCookie(cookies, response);
    }
}
