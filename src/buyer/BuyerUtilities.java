/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utility.DBCon;
import utility.DBHandle;

/**
 *
 * @author PC
 */
public class BuyerUtilities {

    public static int addBuyer(Buyer buyer) throws SQLException {

        String sql = "INSERT INTO Buyer (buyerId,buyerTitle,buyerName,companyAddress,city,country,eMailAddress,webSite,companyName,telephone,fax,postalCode) VALUES ('" + buyer.getBuyerId() + "','" + buyer.getBuyerTitle() + "','" + buyer.getBuyerName() + "','" + buyer.getAddress() + "','" + buyer.getCity() + "','" + buyer.getCountry() + "','" + buyer.getEMailAddress() + "','" + buyer.getWebSite() + "','" + buyer.getCompanyName() + "','" + buyer.getTelephone() + "','" + buyer.getFax() + "','" + buyer.getPostalCode() + "')";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int updateBuyer(Buyer buyer) throws SQLException {

        String sql = "Update Buyer SET buyerTitle = '" + buyer.getBuyerTitle() + "',buyerName = '" + buyer.getBuyerName() + "',companyAddress = '" + buyer.getAddress() + "',city = '" + buyer.getCity() + "',country = '" + buyer.getCountry() + "',eMailAddress = '" + buyer.getEMailAddress() + "',webSite = '" + buyer.getWebSite() + "',companyName = '" + buyer.getCompanyName() + "',telephone = '" + buyer.getTelephone() + "',fax = '" + buyer.getFax() + "',postalCode = '" + buyer.getPostalCode() + "' where buyerId = '" + buyer.getBuyerId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int deleteBuyer(Buyer buyer) throws SQLException {

        String sql = "Delete from Buyer where buyerId ='" + buyer.getBuyerId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static Buyer searchBuyer(String id) throws SQLException {

        String sql = "Select * from Buyer where buyerId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            String title = rst.getString("buyerTitle");
            String name = rst.getString("buyerName");
            String companyName = rst.getString("companyName");
            String address = rst.getString("companyAddress");
            String city = rst.getString("city");
            String country = rst.getString("country");
            String eMailAddress = rst.getString("eMailAddress");
            String webSite = rst.getString("webSite");
            String telephone = rst.getString("telephone");
            String fax = rst.getString("Fax");
            String postalCode = rst.getString("postalCode");

            Buyer buyer = new Buyer(id, title, name, companyName, address, city, country, eMailAddress, webSite, telephone, fax, postalCode);

            return buyer;
        } else {
            return null;
        }
    }

    public static Buyer addsearchBuyer(String id) throws SQLException {

        String sql = "Select * from Buyer where buyerId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Buyer buyer = new Buyer(id);
            return buyer;
        } else {
            return null;
        }
    }

    public static Buyer searchCustomerName(String name) throws SQLException {

        String sql = "Select * From Buyer Where buyerName='" + name + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        if (rst.next()) {
            String id = rst.getString("buyerId");
            String title = rst.getString("buyerTitle");          
            String companyName = rst.getString("companyName");
            String address = rst.getString("companyAddress");
            String city = rst.getString("city");
            String country = rst.getString("country");
            String eMailAddress = rst.getString("eMailAddress");
            String webSite = rst.getString("webSite");
            String telephone = rst.getString("telephone");
            String fax = rst.getString("Fax");
            String postalCode = rst.getString("postalCode");

            Buyer buyer = new Buyer(id, title, name, companyName, address, city, country, eMailAddress, webSite, telephone, fax, postalCode);
            return buyer;
        } else {
            return null;
        }
    }

//    public static Buyer searchBuyer1(boolean isSelectedRow,String id) throws SQLException{
//        
//        String sql = "Select * from Buyer where buyerId = '"+id+"'";
//        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
//        
//        if(rst.next()){
//            String title = rst.getString("buyerTitle");
//            String name = rst.getString("buyerName");
//            String companyName = rst.getString("companyName");
//            String address = rst.getString("companyAddress");
//            String city = rst.getString("city");
//            String country = rst.getString("country");
//            String eMailAddress = rst.getString("eMailAddress");
//            String webSite = rst.getString("webSite");
//            String telephone = rst.getString("telephone");
//            String fax = rst.getString("Fax");
//            String postalCode = rst.getString("postalCode");
//            
//            Buyer buyer = new Buyer(id,title,name,companyName,address, city, country, eMailAddress, webSite, telephone, fax, postalCode);
//            
//            return buyer;
//        }else{
//            return null;
//        }
//    }
    public static void viewBuyer(JTable table, String sql) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

            if (rst == null) {
                return;
            }

            ResultSetMetaData rsmd = rst.getMetaData();
            int columns = rsmd.getColumnCount();

            while (rst.next()) {
                Object data[] = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    data[i] = rst.getObject(i + 1);
                }
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuyerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static ArrayList<String> allNames = new ArrayList<String>();

    public static void nameCombo(JComboBox combobox, String sql) {
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

            if (rst != null) {
                while (rst.next()) {

                    String name = rst.getString(1);
                    combobox.addItem(name);

                }
            }
        } catch (SQLException ex) {
            System.out.println("Wrogn sql");
        }
    }
    
    public static void descriptionCombo(JComboBox comboBox , String sql){
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
//            if(rst == null){
//                System.out.println("no result");
//            }
            if(rst!=null){
                while (rst.next()) {
                    String item = rst.getString(1);
                    comboBox.addItem(item);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuyerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   

    public static void setSearchableCombo(final JComboBox comboBox,boolean shouldSort,final String noItemText){

        int itemCount= comboBox.getItemCount();
        for(int i=0;i<itemCount;i++){
            allNames.add(comboBox.getItemAt(i)+" ");
        }

        final JTextField textField=(JTextField) comboBox.getEditor().getEditorComponent();
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode=e.getKeyCode();
                if(keyCode != KeyEvent.VK_ENTER && keyCode != KeyEvent.VK_UP && keyCode != KeyEvent.VK_DOWN && keyCode != KeyEvent.VK_ESCAPE ){
                    //String text=null;
                    //if(comboBox.getSelectedItem()==null){
                        //System.out.println("comobox null");
                    //}
                   // if(comboBox.getSelectedItem()!=null){
                    String text=textField.getText();
                    comboBox.hidePopup();
                    //}
                    comboBox.removeAllItems();
                    

                    for(String itemName:allNames){
                        if(itemName.startsWith(text)){
                            comboBox.addItem(itemName);
                        }
                    }
                    if(comboBox.getItemCount() == 0){
                        comboBox.addItem(noItemText);
                    }
                    textField.setText(text);
                    comboBox.showPopup();
                }
                
            }

        });
    }
}
