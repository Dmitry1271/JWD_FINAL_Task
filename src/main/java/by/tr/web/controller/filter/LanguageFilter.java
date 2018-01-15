package by.tr.web.controller.filter;

import by.tr.web.controller.constant.AttributeConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cplus on 11.01.2018.
 */
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        if (session.getAttribute(AttributeConstant.LANGUAGE) == null) {
            session.setAttribute(AttributeConstant.LANGUAGE, request.getLocale().getLanguage());
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
