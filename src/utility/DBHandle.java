/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class DBHandle {
    
    public static int setData(Connection con, String sql) throws SQLException{
        
        int result = 0;
        Statement stmt = con.createStatement();
        result = stmt.executeUpdate(sql);
        
        return result;
    }
    
    public static ResultSet getData(Connection con, String sql) throws SQLException{
        
        ResultSet result = null;
        
        Statement stmt = con.createStatement();
        result = stmt.executeQuery(sql);
        
        return result;
    }
}
