import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="adsIndexServlet", urlPatterns = "/ads")
public class adsIndexServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setAttribute("ads", DaoFactory.getAdsDao().all());
        req.getRequestDispatcher("/ads/index.jsp").forward(req, res);
    }
}
