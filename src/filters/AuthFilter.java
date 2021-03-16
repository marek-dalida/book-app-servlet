package filters;

import com.sun.net.httpserver.HttpContext;
import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "/*")
public class AuthFilter implements Filter {

    private ServletContext context;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();

        ServletContext context = request.getServletContext();

        //will return current session if current session exists. If not, it will not create a new session.
        HttpSession session = request.getSession(false);

        this.context.log("Requested Resource::"+uri);

        User user = (User) context.getAttribute("user");

        if( context.getAttribute("user") == null && !(uri.endsWith("/zpt_1_war_exploded/")) && !(uri.endsWith("/LoginServlet"))){
            this.context.log("Unauthorized access request");
            response.sendRedirect("login.html");
        } else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("filters.AuthFilter initialized");
    }

}