package by.tr.web.controller.command.impl.gotopage;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.PageConstant;
import by.tr.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cplus on 10.01.2018.
 */
public class GoSignUpPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException {
        request.getRequestDispatcher(PageConstant.SIGN_UP_PAGE).forward(request,response);
    }
}
