package by.tr.web.controller.command;

import by.tr.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cplus on 16.11.2017.
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException;
}
