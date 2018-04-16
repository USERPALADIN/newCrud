package servlets;

import database.DatabaseSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private  static  final  String SERVLET = "/ServletClients";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseSource databaseSource = new DatabaseSource();
            String id = req.getParameter("userId");
        try {
            databaseSource.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            resp.sendRedirect(SERVLET);
    }
}
