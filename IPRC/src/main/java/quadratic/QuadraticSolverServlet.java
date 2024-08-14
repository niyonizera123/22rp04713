package quadratic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuadraticSolverServlet")
public class QuadraticSolverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve parameters from request
        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");
        String cStr = request.getParameter("c");

        // Parse parameters to double
        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double c = Double.parseDouble(cStr);

        // Calculate discriminant
        double discriminant = b * b - 4 * a * c;

        out.println("<html>");
        out.println("<head><title>Quadratic Equation Roots</title></head>");
        out.println("<body>");
        out.println("<h2>Roots of the Quadratic Equation</h2>");

        if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            out.println("<p>Root 1: " + root1 + "</p>");
            out.println("<p>Root 2: " + root2 + "</p>");
        } else if (discriminant == 0) {
            // One real root
            double root = -b / (2 * a);
            out.println("<p>Root: " + root + "</p>");
        } else {
            // Complex roots
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            out.println("<p>Root 1: " + realPart + " + " + imaginaryPart + "i</p>");
            out.println("<p>Root 2: " + realPart + " - " + imaginaryPart + "i</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
