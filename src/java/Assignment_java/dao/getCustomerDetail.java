/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.dao;

import Assignment_java.dbutil.DbConnection;
import Assignment_java.pojo.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class getCustomerDetail {
    public static List<Customer>getCustomerdetails()
     {
        List<Customer> allcustomer=new ArrayList<>();
         try{
//             getting details of customer from the database
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select first_name,last_name,city,email,phone,address,state from customer_detail");
         while(rs.next()){
             Customer obj=new Customer();
             obj.setFirstname(rs.getString(1));
             obj.setLastname(rs.getString(2));
             obj.setCity(rs.getString(3));
             obj.setState(rs.getString(7));
             obj.setAddress(rs.getString(6));
             obj.setEmail(rs.getString(4));
             obj.setPhone(rs.getString(5));
             allcustomer.add(obj);
         }
         }
         catch(SQLException ex)
         {
             System.out.println("Error in getting detail from database "+ex.getMessage());
         }
         return allcustomer;
     }
     public static List<Customer>getSearchCustomer(String searchbar,String data)
     {
        List<Customer> allcustomer=new ArrayList<>();
         try{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps;
//         getting details from the customer by their search filter
         switch (data.toLowerCase()) {
            case "phone":
               ps=conn.prepareStatement("select first_name,last_name,city,email,phone,address,state from customer_detail where phone=?");
               break;
            case "first name":
                ps=conn.prepareStatement("select first_name,last_name,city,email,phone,address,state from customer_detail where first_name=?");
                break;
            case "email":
                ps=conn.prepareStatement("select first_name,last_name,city,email,phone,address,state from customer_detail where email=?");
                break;
            case "city":
                ps=conn.prepareStatement("select first_name,last_name,city,email,phone,address,state from customer_detail where city=?");
                break;
            default:
                return allcustomer;        
         }
         ps.setString(1, searchbar.toLowerCase());
        ResultSet rs=ps.executeQuery();
         while(rs.next()){
             Customer obj=new Customer();
             obj.setFirstname(rs.getString(1));
             obj.setLastname(rs.getString(2));
             obj.setCity(rs.getString(3));
             obj.setState(rs.getString(7));
             obj.setAddress(rs.getString(6));
             obj.setEmail(rs.getString(4));
             obj.setPhone(rs.getString(5));
             allcustomer.add(obj);
         }
         }
         catch(SQLException ex)
         {
             System.out.println("Error in getting detail of search customer from database "+ex.getMessage());
         }
         return allcustomer;
     }
}
