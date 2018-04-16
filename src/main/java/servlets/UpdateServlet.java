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

@WebServlet(name = "UpdateServlet", urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
private  static  final  String INSERT_OR_EDIT = "/user.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseSource databaseSource = new DatabaseSource();
        String id = req.getParameter("userId");
        User user = null;
        try {
             user = databaseSource.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        RequestDispatcher view = req.getRequestDispatcher(INSERT_OR_EDIT);
        view.forward(req,resp);
    }
}
