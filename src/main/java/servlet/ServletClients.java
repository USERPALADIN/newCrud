package servlet;

import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletClients", urlPatterns = "/ServletClients")
public class ServletClients extends HttpServlet {
    private static final String LIST_USER = "/listUser.jsp";
 //   private UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        req.setAttribute("users", userService.getAllUsers());


        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
        view.forward(req, resp);
    }


}

