import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertAdServlet", urlPatterns = {"/ads/create"})
public class InsertAdServlet extends HttpServlet {
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Ads ads = DaoFactory.getAdsDao();

        // User user  = (User) request.getSession().getAttribute("user");

        Ad ad = new Ad(
                1, // user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        ads.insert(ad);

        response.sendRedirect("/ads/show?id=" + ad.getId());
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request
                .getRequestDispatcher("/WEB-INF/ads/insert.jsp")
                .forward(request, response)
        ;
    }
}