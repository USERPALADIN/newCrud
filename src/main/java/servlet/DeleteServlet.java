package servlet;

import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final String SERVLET = "/ServletClients";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        userService.deleteUser(id);

        resp.sendRedirect(SERVLET);

    }
}
