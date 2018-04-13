package servlet;

import database.DatabaseSource;
import tables.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/ServletClients")
public class ServletClients extends HttpServlet {
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private DatabaseSource databaseSource;

    public ServletClients() {
        databaseSource = new DatabaseSource();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward;
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            String login = req.getParameter("login");
            try {
                databaseSource.deleteUser(login);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = LIST_USER;
            try {
                req.setAttribute("users", databaseSource.getAllUsers());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String login = req.getParameter("login");
            User user = null;
            try {
                user = databaseSource.getUserByLog(login);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            try {
                req.setAttribute("users", databaseSource.getAllUsers());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }
}
