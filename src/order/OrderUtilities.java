/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utility.DBCon;
import utility.DBHandle;

/**
 *
 * @author PC
 */
public class OrderUtilities {
    
    public static int addOrder(Order order) throws SQLException{
        
        String sql = "INSERT INTO Orders (orderId,buyerId,orderDate,deliveryDate,Status) VALUES ('"+order.getOrderId()+"','"+order.getBuyerId()+"','"+order.getOrderDate()+"','"+order.getDeliveryDate()+"',"+order.getStatus()+")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateOrder(Order order) throws SQLException{
        
        String sql = "Update Orders SET buyerId='"+order.getBuyerId()+"', orderDate = '"+order.getOrderDate()+"',deliveryDate = '"+order.getDeliveryDate()+"',status ="+order.getStatus()+" where orderId = '"+order.getOrderId()+"'"; 
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int deleteOrder(Order order) throws SQLException{
        
        String sql = "Delete from Orders where orderId ='"+order.getOrderId()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static Order searchOrder(String id) throws SQLException{
        
        String sql = "Select * from Orders where orderId = '"+id+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        
        if(rst.next()){
            String buyerId = rst.getString("buyerId");
            Date orderDate = rst.getDate("orderDate");
            Boolean status = rst.getBoolean("status");
            Date deliveryDate = rst.getDate("deliveryDate");
            
            Order order = new Order(id,buyerId, status,orderDate, deliveryDate);
            
            return order;
        }else{
            return null;
        }
    }
    
    public static Order addsearchOrder(String id) throws SQLException {

        String sql = "Select * from Orders where orderId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Order order = new Order(id);
            return order;
        } else {
            return null;
        }
    }
    
    public static void viewOrder(JTable table, String sql){
        try {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
            
            if(rst == null){
                return;
            }
            
            ResultSetMetaData rsmd = rst.getMetaData();
            int columns = rsmd.getColumnCount();
            
            while(rst.next()){
                Object data[] = new Object[columns];
                
                for (int i = 0; i < columns; i++) {
                    data[i] = rst.getObject(i+1);
                }
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
           // Logger.getLogger(buyer.BuyerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static ArrayList<String> allNames = new ArrayList<String>();
    
    public static void nameCombo(JComboBox combobox, String sql){
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
            
            if(rst!= null){
                while (rst.next()) {
                    
                    String name = rst.getString(1);
                    combobox.addItem(name);
                    
                }
            }
        } catch (SQLException ex) {
            System.out.println("Wrogn sql");
        }
    }
    
}
