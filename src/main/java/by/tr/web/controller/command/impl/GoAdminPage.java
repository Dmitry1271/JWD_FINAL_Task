package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.ServiceException;
import by.tr.web.service.exception.TypeServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by cplus on 11.01.2018.
 */
public class GoAdminPage implements Command {
    private static final Logger logger = LogManager.getLogger(GoAdminPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PageConstant.ADMIN_PAGE).forward(request, response);
    }
}
