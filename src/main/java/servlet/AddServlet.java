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

@WebServlet(name = "AddServlet", urlPatterns = "/insert_user")
public class AddServlet extends HttpServlet {
    private static final String INSERT = "/addUser.jsp";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher(INSERT);
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = "user";
        RequestDispatcher requestDispatcher;
        User user = userService.getByLogin(login);
        if (user != null) {
            requestDispatcher = req.getRequestDispatcher("/antiHello.jsp");
            requestDispatcher.forward(req, resp);
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            user = new User(name, login, password, role);
            userService.addNewUser(user);
            resp.sendRedirect("/authorization");
        }
    }
}

