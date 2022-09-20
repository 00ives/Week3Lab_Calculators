package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ivorl
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userValue = request.getParameter("age");
        String message = "";
        int age;
        request.setAttribute("userValue", userValue);

        if (userValue == null || userValue.equals("")) {
            message = "You must give your current age";
        } else {
            try {
                age = Integer.parseInt(userValue);
                message = "Your age next birthday will be " + (age + 1);
            } catch (NumberFormatException e) {
                message = "You must enter a number";
            }

        }

        request.setAttribute("message", message);

        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp")
                .forward(request, response);
    }

}
