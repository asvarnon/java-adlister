import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().println("<h1>Hello, World!</h1>");
        String name = request.getParameter("name");
        request.setAttribute("name", name);

        if (name == null) {
            name = "World!";
        } else if (name.equals("bgates")) {
            response.sendRedirect("https://microsoft.com");
            return;
        } else if (name.equals("elonm")) {
            response.sendRedirect("https://tesla.com");
            return;
        } else if (name.equals("jbezos")) {
            response.sendRedirect("https://amazon.com");
            return;
        }

        request.getRequestDispatcher("/hello.jsp").forward(request, response);

    }
}
