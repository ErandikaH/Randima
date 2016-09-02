/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DBCon {
    
    private String password = "1234";
    private String userName = "root";
    private String host = "localhost";
    
    private static Connection con;
    
    public static Connection getConnection(){
        
        if(con!= null){
            return con;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No Driver found..");
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/RandimaExporters", "root", "1234");
        } catch (SQLException ex) {
            
        }
        
        return con;
    }
}
