/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HimelSaha
 */
public class DbConnection {
    private static final String URL = "jdbc:sqlite:C:/Users/Public/sql.db"; 
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(URL);
            System.out.println("::Connected::");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void main(String[] args) {
        getConnection();
    }
}
