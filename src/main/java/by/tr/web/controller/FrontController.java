package by.tr.web.controller;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.command.CommandDirector;
import by.tr.web.controller.command.CommandName;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 16.11.2017.
 */
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = -3774002072132563049L;
    private static final Logger logger = LogManager.getLogger(FrontController.class);
    private static final String QUESTION_SYMBOL = "?";

    private final CommandDirector commandDirector = new CommandDirector();

    public FrontController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(ParameterConstant.COMMAND);

        if (commandName != null && CommandName.containsCommand(commandName)) {
            Command command = commandDirector.getCommand(commandName);
            try {
                if (!commandName.equals(CommandName.CHANGE_LANGUAGE.toString())) {
                    String requestString = request.getServletPath() + QUESTION_SYMBOL + request.getQueryString();
                    response.addCookie(new Cookie(AttributeConstant.LAST_REQUEST, requestString));
                }
                command.execute(request, response);
            } catch (ServiceException e) {
                logger.error(e);
            }
        } else {
            //message
            System.out.println("Invalid Command");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
