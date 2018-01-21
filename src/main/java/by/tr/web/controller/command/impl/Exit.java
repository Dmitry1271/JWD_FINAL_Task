package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;
import by.tr.web.entity.Role;
import by.tr.web.exception.EmptyCookieException;
import by.tr.web.util.TokenHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 20.01.2018.
 */
public class Exit implements Command {
    private static final Logger logger = LogManager.getLogger(Exit.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(AttributeConstant.ROLE, Role.GUEST);
        session.setAttribute(AttributeConstant.ID, null);
        try {
            TokenHelper.removeTokenFromCookie(request.getCookies(), response);
            response.sendRedirect(RedirectQueryConstant.HOME_PAGE_QUERY);
        } catch (EmptyCookieException e) {
            logger.error(e);
            //error page
        }
    }
}
