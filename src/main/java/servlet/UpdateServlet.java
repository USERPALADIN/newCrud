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

@WebServlet(name = "UpdateServlet", urlPatterns = "/updateUser"  )
public class UpdateServlet extends HttpServlet{
    private static final String INSERT_OR_EDIT = "/user.jsp";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        User user = userService.getUserById(id);
        req.setAttribute("user", user);
        RequestDispatcher view = req.getRequestDispatcher(INSERT_OR_EDIT);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name, login, password);
        user.setId(id);
        userService.updateUser(user);
        resp.sendRedirect("/users_all");
    }

}
