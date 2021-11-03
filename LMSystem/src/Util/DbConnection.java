/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Jay
 */
public class DbConnection {
     public Connection con=null;
    public DbConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
