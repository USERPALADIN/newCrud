package servlet;

import service.UserService;
import table.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/authorization.jsp");
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        User user = userService.getByLogin(login);
        if (user == null || !password.equals(user.getPassword())) {
            requestDispatcher = req.getRequestDispatcher("/antiHello.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            if (user.getRole().equals("user")) {
                resp.sendRedirect("/user/hello");
            } else if (user.getRole().equals("admin")) {
                resp.sendRedirect("/admin/users_all");
            }
        }
    }
}
