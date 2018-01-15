package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.service.ServiceFactory;
import by.tr.web.service.autorization.UserService;
import by.tr.web.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 23.11.2017.
 */
public class SignUp implements Command {
    private static final Logger logger = LogManager.getLogger(SignUp.class);
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String ADDRESS = "address";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory instance = ServiceFactory.getInstance();
        UserService userService = instance.getUserService();

        List registerParams = new ArrayList();
        registerParams.add(request.getParameter(LOGIN));
        registerParams.add(request.getParameter(EMAIL));
        registerParams.add(request.getParameter(PASSWORD));
        registerParams.add(request.getParameter(CONFIRM_PASSWORD));
        registerParams.add(request.getParameter(PHONE_NUMBER));
        registerParams.add(request.getParameter(ADDRESS));
        try {
            if (userService.successRegistration(registerParams)) {
                request.getRequestDispatcher(PageConstant.SIGN_IN_PAGE).forward(request, response);
                System.out.println("SUCCESS");
            } else {
                System.out.println("SOMEBAD");
            }
        } catch (ServiceException | ServletException | IOException e) {
            logger.error("Error in successRegistration: " + e);
        }

    }
}
