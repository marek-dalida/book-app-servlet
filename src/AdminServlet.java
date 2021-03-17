import models.Book;
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
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();

        String index = req.getParameter("index");

        System.out.println(index);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();

        if(request.getParameter("index") != null){
            //delete
            String index = request.getParameter("index");
            int indexVal = Integer.parseInt(index);

            ArrayList<Book> books = (ArrayList<Book>) context.getAttribute("books");
            books.remove(indexVal);
            context.setAttribute("books", books);

        } else {
            //add
            Book newBook;

            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String year = request.getParameter("year");
            Integer yearVal = Integer.parseInt(year);

            System.out.println(title);
            System.out.println(author);
            System.out.println(year);

            newBook = new Book(title, author, yearVal);

            ArrayList<Book> books = (ArrayList<Book>) context.getAttribute("books");
            books.add(newBook);
            context.setAttribute("books", books);
        }

        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("admin.jsp");
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
        requestDispatcher = request.getRequestDispatcher("admin.jsp");
        requestDispatcher.forward(request, response);
    }
}
