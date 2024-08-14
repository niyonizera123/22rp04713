package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Static username and password for validation
    private static final String VALID_USERNAME = "Admin";
    private static final String VALID_PASSWORD = "123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // Redirect to the welcome page if credentials are valid
            response.sendRedirect("welcome.html");
        } else {
            // Display an error message if credentials are invalid
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Login Failed</h1>");
            response.getWriter().println("<p class='error-message'>Invalid username or password. Please <a href='/your-app/login.html'>try again</a>.</p>");
            response.getWriter().println("</body></html>");
        }
    }
}
