/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyerPayment;

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
public class ChequeUtilities {
    
    public static int addCheque(Cheque cheque) throws SQLException{
        
        String sql = "INSERT INTO ChequePayment (chequeNo,paymentId,bankName,chequeDate,status,chequeAmount) VALUES ('"+cheque.getChequeNo()+"','"+cheque.getPaymentId()+"','"+cheque.getBankName()+"','"+cheque.getChequeDate()+"',"+cheque.isStatus()+","+cheque.getChequeAmount()+")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateCheque(Cheque cheque) throws SQLException{
        
        String sql = "Update ChequePayment SET paymentId='"+cheque.getPaymentId()+"', chequeDate = '"+cheque.getChequeDate()+"',bankName = '"+cheque.getBankName()+"',status ="+cheque.isStatus()+",chequeAmount = "+cheque.getChequeAmount()+" where chequeNo = '"+cheque.getChequeNo()+"'"; 
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int deleteCheque(Cheque cheque) throws SQLException{
        
        String sql = "Delete from ChequePayment where chequeNo ='"+cheque.getChequeNo()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static Cheque searchCheque(String no) throws SQLException{
        
        String sql = "Select * from ChequePayment where chequeNo = '"+no+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        
        if(rst.next()){
            String paymentId = rst.getString("paymentId");
            String bankName = rst.getString("bankName");
            Date chequeDate = rst.getDate("chequeDate");
            Boolean status = rst.getBoolean("status");
            Double chequeAmount = rst.getDouble("chequeAmount");
            
            Cheque cheque = new Cheque(no, paymentId, bankName, chequeDate, status, chequeAmount);
            
            return cheque;
        }else{
            return null;
        }
    }
    
    public static Cash addsearchCheque(String no) throws SQLException {

        String sql = "Select * from ChequePayment where  chequeNo= '" + no + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Cash cash = new Cash(no);
            return cash;
        } else {
            return null;
        }
    }
    
    public static void viewCheque(JTable table, String sql){
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
