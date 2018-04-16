package servlets;

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

@WebServlet(name = "ServletClients", urlPatterns = "/ServletClients")
public class ServletClients extends HttpServlet {
    private static final String LIST_USER = "/listUser.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseSource dataSource = new DatabaseSource();
        try {
            req.setAttribute("users", dataSource.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseSource databaseSource = new DatabaseSource();

        String id = req.getParameter("userId");
        User test = null;
        try {
             test =  databaseSource.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(id, name, login, password);

        if (test == null ) {
            try {
                databaseSource.addNewUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {

            try {
                databaseSource.updateUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            req.setAttribute("users", databaseSource.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
        view.forward(req, resp);
    }
}

