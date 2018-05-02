package servlet;

import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet (name = "AdminEditorServlet", urlPatterns = "/admin/users_all" )
public class AdminEditorServlet extends HttpServlet {
    private UserService userService = new UserService();
    private static final String LIST_USER = "/listUser.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers());
        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
            view.forward(req, resp);
    }
}
