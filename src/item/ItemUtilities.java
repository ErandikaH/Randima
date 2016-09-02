/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utility.DBCon;
import utility.DBHandle;

/**
 *
 * @author PC
 */
public class ItemUtilities {
    
    public static int addItem(Item item) throws SQLException{
        
        String sql = "INSERT INTO Item (ItemCode,description,unitPrice,qtyOnHand,reorderLevel) VALUES ('"+item.getItemcode()+"','"+item.getDescription()+"',"+item.getUnitPrice()+","+item.getQty()+","+item.getReorderLevel()+")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateItem(Item item) throws SQLException{
        
        String sql = "Update Item SET description = '"+item.getDescription()+"',unitPrice = "+item.getUnitPrice()+",qtyOnHand = "+item.getQty()+",reorderLevel = "+item.getReorderLevel()+" where ItemCode = '"+item.getItemcode()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateItem(String description,int qty)throws SQLException{

            String sql="Update Item SET qtyOnHand='"+qty+"' where description='"+description+"'";
            int rows=DBHandle.setData(DBCon.getConnection(), sql);
            return rows;

    }
    
    public static int deleteItem(Item item) throws SQLException{
        
        String sql = "Delete from Item where ItemCode ='"+item.getItemcode()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static Item searchItem(String id) throws SQLException{
        
        String sql = "Select * from Item where ItemCode = '"+id+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        
        if(rst.next()){
            String description = rst.getString("description");
            double unitPrice = rst.getDouble("unitPrice");
            int qty = rst.getInt("qtyOnHand");
            int reorderLevel = rst.getInt("reorderLevel");
            
            Item item = new Item(id, description, unitPrice, qty, reorderLevel);
            
            return item;
        }else{
            return null;
        }
    }
    
    public static Item addsearchItem(String code) throws SQLException {

        String sql = "Select * from Item where ItemCode = '" + code + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Item item = new Item(code);
            return item;
        } else {
            return null;
        }
    }
    
    public static Item searchDescription(String description) throws SQLException {

        String sql = "Select * From Item Where description='" + description + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        if (rst.next()) {
            String code = rst.getString("ItemCode");
            double unitPrice = rst.getDouble("unitPrice");
            int qty = rst.getInt("qtyOnHand");
            int reorderLevel = rst.getInt("reorderLevel");
            
            Item item = new Item(code, description, unitPrice, qty, reorderLevel);
            return item;
        } else {
            return null;
        }
    }
    
    public static void viewItem(JTable table, String sql){
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
            Logger.getLogger(ItemUtilities.class.getName()).log(Level.SEVERE, null, ex);
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
