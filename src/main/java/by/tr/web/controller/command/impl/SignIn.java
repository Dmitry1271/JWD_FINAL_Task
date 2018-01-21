package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;
import by.tr.web.exception.IncorrectTokenException;
import by.tr.web.util.TokenHelper;
import by.tr.web.entity.Token;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 16.11.2017.
 */
public class SignIn implements Command {
    private static final Logger logger = LogManager.getLogger(SignIn.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ServiceFactory instance = ServiceFactory.getInstance();
        UserService userService = instance.getUserService();

        Token token;
        try {
            token = userService.logination(request.getParameter(ParameterConstant.LOGIN),
                    request.getParameter(ParameterConstant.PASSWORD));

            if (token != null) {

                HttpSession session = request.getSession();
                session.setAttribute(AttributeConstant.ID, TokenHelper.parseId(token));
                session.setAttribute(AttributeConstant.ROLE, TokenHelper.parseRole(token));

                response.addCookie(new Cookie(AttributeConstant.ACCESS_TOKEN, token.getAccessToken()));
                response.addCookie(new Cookie(AttributeConstant.REFRESH_TOKEN, token.getRefreshToken()));

                response.sendRedirect(RedirectQueryConstant.HOME_PAGE_QUERY);

            } else {
                //some code here
                System.out.println("BAD login or password");
            }
        } catch (ServiceException | IOException | IncorrectTokenException e) {
            logger.error("Error in sign in: " + e);
        }
    }
}
