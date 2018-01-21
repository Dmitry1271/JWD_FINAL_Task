package by.tr.web.controller.command.impl.gotopage;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.entity.Role;
import by.tr.web.entity.User;
import by.tr.web.entity.appliance.Appliance;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.ApplianceServiceException;
import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.exception.UserServiceException;
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
    private static final String APPLIANCES_ATTRIBUTE = "appliances";
    private static final String USER_ATTRIBUTE = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        try {
            String language = (String) session.getAttribute(AttributeConstant.LANGUAGE);
            List<String> types = instance.getTypeService().getAllTypes(language);
            List<Appliance> appliances = instance.getApplianceService().getTopAppliances(language);
            request.setAttribute(TYPES_ATTRIBUTE, types);
            request.setAttribute(APPLIANCES_ATTRIBUTE, appliances);

            Object role = session.getAttribute(AttributeConstant.ROLE);
            if (role.equals(Role.ADMIN) || role.equals(Role.CLIENT)) {
                User user = instance.getUserService().getUser((Integer) session.getAttribute(AttributeConstant.ID));
                request.setAttribute(USER_ATTRIBUTE, user);
            }
            request.getRequestDispatcher(PageConstant.HOME_PAGE).forward(request, response);
        } catch (TypeServiceException e) {
            //страница с ошибкой запроса

            logger.error(e);
        } catch (InvalidTypeException e) {
            //другая страница с ошибкой запроса
            logger.error(e);
        } catch (ApplianceServiceException e) {
            //другая страница с ошибкой запроса
            logger.error(e);
        } catch (UserServiceException e) {
            logger.error(e);
        }
    }
}