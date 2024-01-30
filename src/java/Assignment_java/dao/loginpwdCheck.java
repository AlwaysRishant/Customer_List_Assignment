/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_java.dao;

import Assignment_java.dbutil.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class loginpwdCheck {
    public static boolean validateUser(String loginid,String password){
        try{
//            check login password from the database
            Connection conn=DbConnection.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select loginid,password from admin_detail");
            while(rs.next())
            {
                if(loginid.equals(rs.getString(1))&&password.equals(rs.getString(2)))
                {
                    return true;
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error in checking loginid,password from database "+ex.getMessage());
        }
        return false;
    }
}
