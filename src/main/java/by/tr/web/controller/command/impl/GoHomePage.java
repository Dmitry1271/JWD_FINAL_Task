package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.exception.valid.InvalidTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by cplus on 03.01.2018.
 */
public class GoHomePage implements Command {
    private static final Logger logger = LogManager.getLogger(GoHomePage.class);
    private static final String TYPES_ATTRIBUTE = "appliance_types";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        try {
            List<String> types = instance.getTypeService().getAllTypes(String.valueOf(session.getAttribute(AttributeConstant.LANGUAGE)));
            request.setAttribute(TYPES_ATTRIBUTE, types);
        } catch (TypeServiceException e) {
            //страница с ошибкой запроса

            logger.error(e);
        } catch (InvalidTypeException e) {
            //другая страница с ошибкой запроса
            logger.error(e);
        }
        request.getRequestDispatcher(PageConstant.HOME_PAGE).forward(request, response);
    }
}
