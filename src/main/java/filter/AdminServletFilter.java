package filter;

import service.UserService;
import table.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminServletFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        User user = (User) httpRequest.getSession().getAttribute("user");

        if (user.getRole().equals("admin")) {
            chain.doFilter(req, resp);
        } else {
            httpResponse.getWriter().println("Don't have  access");
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }
//
//    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //   req.setAttribute("users", userService.getAllUsers());
//        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
//        view.forward(req, resp);
////    }
}

