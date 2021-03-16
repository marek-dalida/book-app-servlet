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
import java.util.HashMap;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {

    static HashMap<String, String> users = new HashMap<String, String>() {{
        put("user1", "user1");
        put("user2", "user2");
        put("user3", "user3");
        put("user4", "user4");
        put("user5", "user5");
    }};

    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user;

        if(users.containsKey(username)){
            if(users.get(username).equals(password)){
                user = new User(username, password, Role.USER);
                context.setAttribute("user", user);
                response.sendRedirect("DashboardServlet");
                //requestDispatcher = request.getRequestDispatcher("DashboardServlet");
                //requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect("loginFailure.html");
            }
        } else {
           response.sendRedirect("loginFailure.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
