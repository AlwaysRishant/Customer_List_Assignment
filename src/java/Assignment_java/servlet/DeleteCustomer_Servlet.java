/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.servlet;

import Assignment_java.dao.deleteCustomerInfo;
import static Assignment_java.dao.deleteCustomerInfo.DeleteCustomer;
import Assignment_java.dao.getCustomerDetail;
import Assignment_java.pojo.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
@WebServlet(name = "DeleteCustomer_Servlet", urlPatterns = {"/DeleteCustomer_Servlet"})
public class DeleteCustomer_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       //This is the delete customer servlet
    PrintWriter out = response.getWriter();
    String fname = request.getReader().lines().collect(Collectors.joining());
    String confirmationMessage = "";

    if (deleteCustomerInfo.DeleteCustomer(fname)) {
        confirmationMessage = "Customer " + fname + " deleted successfully";
    } else {
        confirmationMessage = "Customer " + fname + " is not deleted successfully";
    }

    response.getWriter().println("{ \"message\": \"" + confirmationMessage + "\" }"); //send aknowledgement to the caller 
    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    rd.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
