import models.Book;

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
import java.util.ArrayList;

@WebServlet(name = "DashboardServlet", urlPatterns = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();

        String search = request.getParameter("search");

        System.out.println(search);

        context.setAttribute("userSearch", search);

        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        ArrayList<Book> books = (ArrayList<Book>) context.getAttribute("books");
        System.out.println(books.toString());
        HttpSession session = request.getSession();


        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
        requestDispatcher.forward(request, response);
    }
}
