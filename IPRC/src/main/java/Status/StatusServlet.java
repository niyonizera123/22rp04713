package Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class StatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Retrieve the query parameter named "error"
        String errorParam = request.getParameter("error");

        // Generate HTML response based on the "error" parameter
        if ("404".equals(errorParam)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
        } else if ("500".equals(errorParam)) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        } else {
            // Display the HTML form with links if no valid error parameter is provided
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Select an Error to Trigger</h1>");
            response.getWriter().println("<ul>");
            response.getWriter().println("<li><a href=\"/your-app/error?error=404\">Trigger 404 Not Found</a></li>");
            response.getWriter().println("<li><a href=\"/your-app/error?error=500\">Trigger 500 Internal Server Error</a></li>");
            response.getWriter().println("</ul>");
            response.getWriter().println("</body></html>");
        }
    }
}
