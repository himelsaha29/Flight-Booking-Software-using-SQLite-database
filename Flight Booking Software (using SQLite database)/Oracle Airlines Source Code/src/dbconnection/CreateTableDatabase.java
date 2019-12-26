/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HimelSaha
 */
public class CreateTableDatabase {
    
    Connection conn = DbConnection.getConnection();

    
    public void createTable() {
        String sql = "create table travels (serial INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "passenger varchar(50), dep varchar(15), arr varchar(15), date varchar(15), class varchar(15),"
                + " seat varchar(3), flight_no varchar(5), email varchar(50), gender varchar(6), passport varchar(15),"
                + " phone varchar(15))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table created succesfully");
        } catch (SQLException ex) {
            System.out.println("::Table Already Created::");
        }
    }
    
    public static void main(String[] args) {
        CreateTableDatabase ct = new CreateTableDatabase();
        ct.createTable();
        
    }
    
}
