import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name= "QuoteServlet", urlPatterns = "/quotes")
public class QuotesServlet extends HttpServlet {
    private QuotesManager quotesManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("quotes", quotesManager);
        request.getRequestDispatcher("/quotes.jsp").forward(request, response);
        }

    @Override
    public void init(){
        quotesManager = new ListQuotes();
    }




    }
