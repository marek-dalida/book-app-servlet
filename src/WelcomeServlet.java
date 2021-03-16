import models.Role;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        ServletContext context = getServletContext();


        //Sprawdzenie czy użytkownik istnieje
        if(request.getParameter("user") == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            User user = (User) session.getAttribute("user");
            RequestDispatcher requestDispatcher;
            if(user.getRole() == Role.ADMIN) {
                requestDispatcher = request.getRequestDispatcher("AdminServlet");
            } else {
                requestDispatcher = request.getRequestDispatcher("DashboardServlet");
            }
            requestDispatcher.forward(request, response);
        }
    }
}
