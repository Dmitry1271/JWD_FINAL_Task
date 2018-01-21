package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;
import by.tr.web.dao.exception.UserDAOException;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.exception.valid.InvalidUserInfoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 21.01.2018.
 */
public class ChangeProfile implements Command {
    private static final Logger logger = LogManager.getLogger(ChangeProfile.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        UserService userService = instance.getUserService();
        HttpSession session = request.getSession();
        try {
            userService.updateUser((Integer) session.getAttribute(AttributeConstant.ID), getUserInfo(request));
            response.sendRedirect(RedirectQueryConstant.PROFILE_PAGE_QUERY);
        } catch (InvalidUserInfoException e) {
            logger.error(e);
            //error page
        } catch (UserDAOException e) {
            logger.error(e);
            //error page
        }
    }

    private List getUserInfo(HttpServletRequest request) {
        List userInfo = new ArrayList();
        userInfo.add(request.getParameter(ParameterConstant.EMAIL));
        userInfo.add(request.getParameter(ParameterConstant.PHONE_NUMBER));
        userInfo.add(request.getParameter(ParameterConstant.ADDRESS));
        return userInfo;
    }
}
