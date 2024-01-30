/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.dao;

import Assignment_java.dbutil.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class deleteCustomerInfo {
     public static boolean DeleteCustomer(String fname){
         boolean res=false;
     try{//delete customer from the database
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from customer_detail where first_name=?");
        ps.setString(1,fname);
        res=(ps.executeUpdate()==1);
     }
     catch(SQLException ex)
     {
         System.out.println("Error in delete customer");
     }
    return res; 

 }
}
