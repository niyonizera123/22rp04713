package Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Example credentials for demonstration
    private static final String VALID_USERNAME = "Admin";
    private static final String VALID_PASSWORD = "p123";

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
            response.sendRedirect("error.html");
         
        }
    }
}
