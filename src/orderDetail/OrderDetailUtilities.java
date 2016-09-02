/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;


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
public class OrderDetailUtilities {
    
    public static int addOrderDetail(OrderDetail orderDetail) throws SQLException{
        
        String sql = "INSERT INTO OrderDetail (orderId,productCode,unitPrice,orderQty,containerNo,discount) VALUES ('"+orderDetail.getOrderId()+"','"+orderDetail.getProductCode()+"',"+orderDetail.getUnitPrice()+","+orderDetail.getQty()+",'"+orderDetail.getContainerNo()+"',"+orderDetail.getDiscount()+")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateOrderDetail(OrderDetail orderDetail) throws SQLException{
        
        String sql = "Update OrderDetail SET unitPrice = "+orderDetail.getUnitPrice()+",orderQty = "+orderDetail.getQty()+",containerNo = '"+orderDetail.getContainerNo()+"',discount = "+orderDetail.getDiscount()+" where orderId = '"+orderDetail.getOrderId()+"' and productCode = '"+orderDetail.getProductCode()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int deleteOrderDetail(OrderDetail orderDetail) throws SQLException{
        
        String sql = "Delete from OrderDetail where orderId = '"+orderDetail.getOrderId()+"' and productCode = '"+orderDetail.getProductCode()+"'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static OrderDetail searchOrderDetail(String id,String code) throws SQLException{
        
        String sql = "Select * from OrderDetail where orderId = '"+id+"' and productCode = '"+code+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        
        if(rst.next()){
            String containerNo = rst.getString("containerNo");
            double unitPrice = rst.getDouble("unitPrice");
            int qty = rst.getInt("orderQty");
            double discount = rst.getDouble("discount");
            
            OrderDetail orderDetail = new OrderDetail(id, code, qty, discount, containerNo, unitPrice);
                        
            return orderDetail;
        }else{
            return null;
        }
    }
    
    public static OrderDetail addsearchOrderDetail(String id, String code) throws SQLException {

        String sql = "Select * from OrderDetail where orderId = '"+id+"' and productCode = '"+code+"'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            OrderDetail orderDetail = new OrderDetail(id, code);
            return orderDetail;
        } else {
            return null;
        }
    }
        
    public static void viewOrderDetail(JTable table, String sql){
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
            Logger.getLogger(OrderDetailUtilities.class.getName()).log(Level.SEVERE, null, ex);
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
