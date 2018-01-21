package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.controller.constant.ParameterConstant;
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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory instance = ServiceFactory.getInstance();
        UserService userService = instance.getUserService();


        try {
            if (userService.successRegistration(getRegisterInfoFromParam(request))) {
                request.getRequestDispatcher(PageConstant.SIGN_IN_PAGE).forward(request, response);
                System.out.println("SUCCESS");
            } else {
                System.out.println("SOMEBAD");
            }
        } catch (ServiceException | ServletException | IOException e) {
            logger.error("Error in successRegistration: " + e);
        }

    }
    private List getRegisterInfoFromParam(HttpServletRequest request){
        List registerParams = new ArrayList();
        registerParams.add(request.getParameter(ParameterConstant.LOGIN));
        registerParams.add(request.getParameter(ParameterConstant.EMAIL));
        registerParams.add(request.getParameter(ParameterConstant.PASSWORD));
        registerParams.add(request.getParameter(ParameterConstant.PASSWORD_CONFIRMATION));
        registerParams.add(request.getParameter(ParameterConstant.PHONE_NUMBER));
        registerParams.add(request.getParameter(ParameterConstant.ADDRESS));
        return registerParams;
    }
}
