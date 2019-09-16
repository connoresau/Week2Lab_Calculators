/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Connor Esau
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");  //set result to ---
        reloadPage(request, response, null, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstNumStr = request.getParameter("firstNum");
        String secondNumStr = request.getParameter("secondNum");
        Double firstNum, secondNum, result = null;

        try {
            //attempt to parse first and second num to Double
            firstNum = Double.parseDouble(firstNumStr);
            secondNum = Double.parseDouble(secondNumStr);
        } catch (NumberFormatException e) {
            request.setAttribute("result", "invalid");
            reloadPage(request, response, firstNumStr, secondNumStr);
            return;
        }

        switch (request.getParameter("arithmetic")) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "%":
                if (secondNum == 0) {
                    request.setAttribute("result", "Can not divide by 0");
                    reloadPage(request, response, firstNum, secondNum);
                    return;
                }
                result = firstNum / secondNum;
                break;
            default:
                break;
        }
        //set result attribute
        request.setAttribute("result", result);
        
        reloadPage(request, response, firstNum, secondNum);
    }
    
    private void reloadPage(HttpServletRequest request, HttpServletResponse response, 
            Object firstNum, Object secondNum) throws ServletException, IOException {
        
        //set text fields to what was already entered
        request.setAttribute("firstNum", firstNum); 
        request.setAttribute("secondNum", secondNum);
        
        //reload Page
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }
}
