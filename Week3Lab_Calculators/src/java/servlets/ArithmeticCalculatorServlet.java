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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String calculationResult = "---";
        request.setAttribute("calculationResult", calculationResult);

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstValue = request.getParameter("firstNumber");
        String secondValue = request.getParameter("secondNumber");
        String operator = request.getParameter("operationType");

        boolean value1IsNumber = false;
        boolean value2IsNumber = false;
        int firstNumber = 0;
        int secondNumber = 0;
        String calculationResult = "";

        value1IsNumber = verifyNumber(firstValue);
        value2IsNumber = verifyNumber(secondValue);

        if (!value1IsNumber || !value2IsNumber) {
            calculationResult = "Invalid";
        } else {
            firstNumber = Integer.parseInt(firstValue);
            secondNumber = Integer.parseInt(secondValue);
            if (operator.equals("+")) {
                int result = firstNumber + secondNumber;
                calculationResult = result + "";
            } else if (operator.equals("-")) {
                int result = firstNumber - secondNumber;
                calculationResult = result + "";
            } else if (operator.equals("*")) {
                int result = firstNumber * secondNumber;
                calculationResult = result + "";
            } else if (operator.equals("%")) {
                int result = firstNumber % secondNumber;
                calculationResult = result + "";
            }
        }

        request.setAttribute("firstValue", firstValue);
        request.setAttribute("secondValue", secondValue);
        request.setAttribute("calculationResult", calculationResult);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
    }

    protected boolean verifyNumber(String value) {
        boolean isNumber = false;

        if (value == null || value.equals("")) {
            isNumber = false;
            return isNumber;
        } else {
            try {
                Double.parseDouble(value);
                isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
                return isNumber;
            }
        }
        return isNumber;
    }

}
