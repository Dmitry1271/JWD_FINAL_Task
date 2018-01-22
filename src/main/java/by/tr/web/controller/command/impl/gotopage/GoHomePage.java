package by.tr.web.controller.command.impl.gotopage;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.entity.Role;
import by.tr.web.entity.Type;
import by.tr.web.entity.User;
import by.tr.web.entity.appliance.Appliance;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.exception.ApplianceServiceException;
import by.tr.web.service.exception.TypeServiceException;
import by.tr.web.service.exception.UserServiceException;
import by.tr.web.service.exception.valid.InvalidApplianceException;
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
    private static final int FIRST_PAGE = 0;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        Object typeId = request.getParameter(ParameterConstant.TYPE_ID);
        try {
            List<Appliance> appliances;
            Object page = request.getParameter(ParameterConstant.PAGE);
            String language = (String) session.getAttribute(AttributeConstant.LANGUAGE);
            List<Type> types = instance.getTypeService().getAllTypes(language);

            if (typeId == null) {
                appliances = instance.getApplianceService().getTopAppliances(language, page);
            } else {
                appliances = instance.getApplianceService().getAppliancesByType(typeId, page, language);
                request.setAttribute(ParameterConstant.TYPE_ID, typeId);
            }

            request.setAttribute(TYPES_ATTRIBUTE, types);
            request.setAttribute(APPLIANCES_ATTRIBUTE, appliances);
            request.setAttribute(ParameterConstant.PAGE, request.getParameter(ParameterConstant.PAGE));

            Object role = session.getAttribute(AttributeConstant.ROLE);
            if (role.equals(Role.ADMIN) || role.equals(Role.CLIENT)) {
                User user = instance.getUserService().getUser((Integer) session.getAttribute(AttributeConstant.ID));
                request.setAttribute(USER_ATTRIBUTE, user);
            }
            request.getRequestDispatcher(PageConstant.HOME_PAGE).forward(request, response);
        } catch (TypeServiceException | InvalidApplianceException | UserServiceException | ApplianceServiceException |
                InvalidTypeException e) {
            //страница с ошибкой запроса
            logger.error(e);
        }
    }
}
