package Header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/headers")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html");

        // Get headers from the request
        String userAgent = request.getHeader("User-Agent");
        String host = request.getHeader("Host");
        String acceptLanguage = request.getHeader("Accept-Language");

        // Prepare the HTML response
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Request Headers</h1>");
        response.getWriter().println("<table border='1'>");
        response.getWriter().println("<tr><th>Header</th><th>Value</th></tr>");
        response.getWriter().println("<tr><td>User-Agent</td><td>" + (userAgent != null ? userAgent : "Not provided") + "</td></tr>");
        response.getWriter().println("<tr><td>Host</td><td>" + (host != null ? host : "Not provided") + "</td></tr>");
        response.getWriter().println("<tr><td>Accept-Language</td><td>" + (acceptLanguage != null ? acceptLanguage : "Not provided") + "</td></tr>");
        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }
}
