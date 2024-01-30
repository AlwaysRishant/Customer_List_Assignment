/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.servlet;

import Assignment_java.dao.getCustomerDetail;
import Assignment_java.dao.loginpwdCheck;
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
@WebServlet(name = "validateuserServlet", urlPatterns = {"/validateuserServlet"})
public class validateuserServlet extends HttpServlet {

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
//        This servlet is validating the login credentials
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Customer>list=getCustomerDetail.getCustomerdetails();
        String loginid=request.getParameter("username");
        String password=request.getParameter("password");
        if(loginpwdCheck.validateUser(loginid,password))
        {
            RequestDispatcher rd=null;
            rd=request.getRequestDispatcher("customer_list.jsp");
            if(list.size()!=0)
                request.setAttribute("list", list);
            else
                request.setAttribute("list", null);
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd=null;
            rd=request.getRequestDispatcher("login.jsp");
            request.setAttribute("output", "Wrong Id Password Try Again!!");
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
