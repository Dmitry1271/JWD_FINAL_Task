package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.ServiceException;
import by.tr.web.service.exception.UserServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 21.01.2018.
 */
public class ChangePassword implements Command {
    private static final Logger logger = LogManager.getLogger(ChangePassword.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        try {
            if (instance.getUserService().updatePassword((Integer) session.getAttribute(AttributeConstant.ID),
                    request.getParameter(ParameterConstant.OLD_PASSWORD), request.getParameter(ParameterConstant.PASSWORD),
                    request.getParameter(ParameterConstant.PASSWORD_CONFIRMATION))) {
                response.sendRedirect(RedirectQueryConstant.PROFILE_PAGE_QUERY);
            } else {
                //the same page with message
                System.out.println("BAD PASSWORD");
            }
        } catch (UserServiceException e) {
            logger.error(e);
            //error message
        }
    }
}
