package by.tr.web.controller.command.impl;

import by.tr.web.controller.command.Command;
import by.tr.web.controller.constant.AttributeConstant;
import by.tr.web.controller.constant.ParameterConstant;
import by.tr.web.controller.constant.RedirectQueryConstant;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cplus on 03.01.2018.
 */
public class ChangeLanguage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute(AttributeConstant.LANGUAGE, request.getParameter(ParameterConstant.LANGUAGE));

        Cookie[] cookies = request.getCookies();
        String lastRequest = RedirectQueryConstant.HOME_PAGE_QUERY;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(AttributeConstant.LAST_REQUEST)) {
                lastRequest = cookie.getValue();
            }
        }
        response.sendRedirect(lastRequest);
    }
}
