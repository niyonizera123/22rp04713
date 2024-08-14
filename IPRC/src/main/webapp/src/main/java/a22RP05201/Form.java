package a22RP05201;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Form
 */
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	    	String unme = request.getParameter("username");
	        String pass = request.getParameter("password");

	        if (unme.equals("rp") &&pass.equals("huye")) {
	           RequestDispatcher rd=request.getRequestDispatcher("servlet3");
	           
	           rd.forward(request, response);
	        } else {
	            out.print("errorMessage");
	           out.print("<a href='loginform.html'>GO</a>");
	        }
	    }
	}