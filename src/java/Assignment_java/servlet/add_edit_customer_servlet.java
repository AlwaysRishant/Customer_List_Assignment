/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.servlet;

import Assignment_java.dao.getCustomerDetail;
import Assignment_java.dao.insert_edit_customerDetails;
import Assignment_java.pojo.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "add_edit_customer_servlet", urlPatterns = {"/add_edit_customer_servlet"})
public class add_edit_customer_servlet extends HttpServlet {

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
      Customer customer=new Customer();
      //This is the add or edit customer servlet
      customer.setFirstname(request.getParameter("firstname"));
      customer.setLastname(request.getParameter("lastname"));
      customer.setCity(request.getParameter("city"));
      customer.setStreet(request.getParameter("street"));
      customer.setPhone(request.getParameter("phone"));
      customer.setEmail(request.getParameter("email"));
      customer.setAddress(request.getParameter("address"));
      customer.setState(request.getParameter("state"));
      if(insert_edit_customerDetails.addEditCustomer(customer))
      {
        List<Customer>list=getCustomerDetail.getCustomerdetails();
        RequestDispatcher rd=null;
        rd=request.getRequestDispatcher("customer_list.jsp");
        request.setAttribute("list", list);
        rd.forward(request, response);
      }
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
