/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author pache
 */
@WebServlet(urlPatterns = {"/conversion"})
public class ConversionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
        double n = Double.parseDouble(request.getParameter("n"));
        double result = 0;
        String option = request.getParameter("option");
        
        if(option.equals("fahrenheit")){
            result = ((n * 9) / 5) + 32;
        }else if(option.equals("celsius")){
            result = ((n - 32) * 5) / 9;
        }
        
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Result: " + result + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
}
