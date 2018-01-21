package by.tr.web.controller.command.impl.gotopage;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.entity.User;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.UserServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 11.01.2018.
 */
public class GoAdminPage implements Command {
    private static final Logger logger = LogManager.getLogger(GoAdminPage.class);
    private static final String USER_ATTRIBUTE = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceFactory instance = ServiceFactory.getInstance();
        try {
            User user = instance.getUserService().getUser((Integer) session.getAttribute(AttributeConstant.ID));
            request.setAttribute(USER_ATTRIBUTE, user);
            request.getRequestDispatcher(PageConstant.ADMIN_PAGE).forward(request, response);
        } catch (UserServiceException e) {
            logger.error(e);
            //error page
        }
    }
}
