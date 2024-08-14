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
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String userInput = request.getParameter("userInput");

	        
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	