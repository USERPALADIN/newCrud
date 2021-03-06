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

@WebServlet(name = "UpdateServlet", urlPatterns = "/admin/update_user"  )
public class UpdateServlet extends HttpServlet{
    private static final String EDIT = "/user.jsp";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        User user = userService.getUserById(id);
        req.setAttribute("user", user);
        RequestDispatcher view = req.getRequestDispatcher(EDIT);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(name, login, password,role);
        user.setId(id);
        userService.updateUser(user);
        resp.sendRedirect("/admin/users_all");
    }

}
