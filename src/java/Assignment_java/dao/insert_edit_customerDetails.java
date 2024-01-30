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

/**
 *
 * @author HP
 */
public class insert_edit_customerDetails {
    public static boolean ConfirmCustomer(Customer obj)
    {
         try{
//             checking user already present or not in the database
            Connection conn=DbConnection.getConnection();  
            PreparedStatement ps=conn.prepareStatement("select first_name from customer_detail where first_name=?");
            ps.setString(1, obj.getFirstname());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(obj.getFirstname()))
                {
                    return true;
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error in confirm first name into the database "+ex.getMessage());
        }
        return false;
    }
     public static boolean addEditCustomer(Customer obj)
    {
        boolean res=false;
        try{
            Connection conn=DbConnection.getConnection();
            PreparedStatement ps=null;
            if(!insert_edit_customerDetails.ConfirmCustomer(obj))
            {
                //if not present then add in the database
                ps=conn.prepareStatement("insert into customer_detail values(?,?,?,?,?,?,?,?)");
                ps.setString(1, obj.getFirstname());
                ps.setString(2, obj.getLastname());
                ps.setString(3,obj.getStreet());
                ps.setString(4, obj.getAddress());
                ps.setString(5, obj.getCity());
                ps.setString(6,obj.getState());
                ps.setString(7,obj.getEmail());
                ps.setString(8,obj.getPhone());
            }
            else{
                //if already add then update his details
                ps=conn.prepareStatement("update customer_detail set last_name=?,street=?,address=?,city=?,state=?,email=?,phone=? where first_name=?");
                ps.setString(8, obj.getFirstname());
                ps.setString(1, obj.getLastname());
                ps.setString(2,obj.getStreet());
                ps.setString(3, obj.getAddress());
                ps.setString(4, obj.getCity());
                ps.setString(5,obj.getState());
                ps.setString(6,obj.getEmail());
                ps.setString(7,obj.getPhone());
            }
            res=(1==ps.executeUpdate());
        }
        catch(SQLException ex)
        {
            System.out.println("Error in adding customer details into the database "+ex.getMessage());
        }
        return res;
    }
}
