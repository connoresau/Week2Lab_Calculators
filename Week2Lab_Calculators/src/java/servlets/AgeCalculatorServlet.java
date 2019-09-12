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
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enteredAgeStr = request.getParameter("enteredAge");  //retrieve entered Age
        request.setAttribute("ageEnteredInTextBox", enteredAgeStr);
        int enteredAge;

        if (enteredAgeStr == null || enteredAgeStr.equals("")) {  //if user did not enter anything into textbox
            request.setAttribute("output", "You must give your current age.<br>");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
            return;
        }

        try {
            enteredAge = Integer.parseInt(enteredAgeStr);   //attempt to parse entered value to an int
        } catch (NumberFormatException e) {
            request.setAttribute("output", "You must enter a number.<br>"); //if parse did not succeed
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
            return;
        }

        request.setAttribute("output", "Your age next birthday will be " + (enteredAge + 1) + ".<br>");

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
}
