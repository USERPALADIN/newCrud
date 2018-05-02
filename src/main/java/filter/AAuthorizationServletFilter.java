package filter;

import service.UserService;
import table.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

@WebFilter(urlPatterns = "/*")
public class AAuthorizationServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/") || uri.equals("/authorization") || uri.equals("/insert_user")) {
            chain.doFilter(req, resp);
        } else {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                httpServletResponse.sendRedirect("/authorization");
            }
        }
    }


    @Override
    public void destroy() {

    }
}
