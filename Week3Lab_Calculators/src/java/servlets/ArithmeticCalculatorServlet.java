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
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstValue = request.getParameter("firstNumber");
        String secondValue = request.getParameter("secondValue");
        String operator = request.getParameter("operationType");
        double calculationResult;
        boolean value1IsNumber = false;
        boolean value2IsNumber = false;
        
        value1IsNumber = verifyNumber(firstValue);
        value2IsNumber = verifyNumber(firstValue);
        
       
        
//        if (operator.equals("+") && ){
//            calculationResult = Double.parseDouble(firstValue) + DoublesecondValue;
//        }
        
        
        
    
    }
    protected boolean verifyNumber(String value){
        boolean isNumber = false;
        try{
           Integer.parseInt(value);
           isNumber = true;
       }
       catch(NumberFormatException e){
           return isNumber;
       }
        
        return isNumber;
    }

}
