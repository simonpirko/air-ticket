package by.tms.finalProject.filter;

import by.tms.finalProject.constant.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        if (httpServletRequest.getSession().isNew()) {
            httpServletRequest.getSession().setAttribute("role", Role.GUEST);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
