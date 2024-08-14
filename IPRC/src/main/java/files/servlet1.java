package files;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user input from the form
        String userInput = request.getParameter("userInput");

        // Create or update the cookie with the user input
        if (userInput != null && !userInput.trim().isEmpty()) {
            Cookie userCookie = new Cookie("userInput", userInput);
            userCookie.setMaxAge(60 * 60 * 24 * 7); // Cookie lasts for 7 days
            response.addCookie(userCookie);
        }

        // Redirect to GET method to display the form with the cookie value
        response.sendRedirect("servlet1");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the cookie value if present
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userInput".equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }

        // Generate HTML response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>Login Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>Enter your username or email</h1>");
        out.println("    <form action=\"servlet1\" method=\"post\">");
        out.println("        <label for=\"userInput\">Username or Email:</label>");
        out.println("        <input type=\"text\" id=\"userInput\" name=\"userInput\" value=\"" + (cookieValue != null ? cookieValue : "") + "\" required>");
        out.println("        <button type=\"submit\">Submit</button>");
        out.println("    </form>");
        out.println("</body>");
        out.println("</html>");
    }
}
