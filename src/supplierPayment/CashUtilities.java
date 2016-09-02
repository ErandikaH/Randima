/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierPayment;

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
public class CashUtilities {
    
    public static int addCash(Cash cash) throws SQLException{
        
        String sql = "INSERT INTO SupplierPayment (paymentId,grnId,payDate,amount) VALUES ('"+cash.getPaymentId()+"','"+cash.getGrnId()+"','"+cash.getPayDate()+"',"+cash.getAmount()+")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateCash(Cash cash) throws SQLException{
        
        String sql = "Update SupplierPayment SET grnId='"+cash.getGrnId()+"', payDate = '"+cash.getPayDate()+"',amount ="+cash.getAmount()+" where paymentId = '"+cash.getPaymentId()+"'"; 
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int deleteCash(Cash cash) throws SQLException{
        
        String sql = "Delete from SupplierPayment where paymentId ='"+cash.getPaymentId()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static Cash searchCash(String id) throws SQLException{
        
        String sql = "Select * from SupplierPayment where paymentId = '"+id+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        
        if(rst.next()){
            String grnId = rst.getString("grnId");
            Date payDate = rst.getDate("payDate");
            double amount = rst.getDouble("amount");
            
            Cash cash = new Cash(id, grnId, payDate, amount);
            
            return cash;
        }else{
            return null;
        }
    }
    
    public static Cash addsearchcash(String id) throws SQLException {

        String sql = "Select * from SupplierPayment where  paymentId= '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Cash cash = new Cash(id);
            return cash;
        } else {
            return null;
        }
    }
    
    public static void viewCash(JTable table, String sql){
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
