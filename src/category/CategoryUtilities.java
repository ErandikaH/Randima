/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

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
public class CategoryUtilities {
    
    public static int addCategory(Category category) throws SQLException {

        String sql = "INSERT INTO Category (categoryId,categoryName) VALUES ('" + category.categoryId + "','" + category.categoryName + "')";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int updateCategory(Category category) throws SQLException {

        String sql = "Update Category SET categoryName = '" + category.categoryName + "' where categoryId = '" + category.categoryId + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
//    public static int updateOrderProduct(Product product) throws SQLException {
//
//        String sql = "Update Product SET productQtyOnHand = " + product.getProductQtyOnHand() + " where productCode = '" + product.getProductCode() + "'";
//        int res = DBHandle.setData(DBCon.getConnection(), sql);
//        return res;
//    }

    public static int deleteCategory(Category category) throws SQLException {

        String sql = "Delete from Category where categoryId ='" + category.categoryId + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static Category searchCategory(String id) throws SQLException {

        String sql = "Select * from Category where categoryId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            String name = rst.getString("categoryName");
            
            Category category =  new Category(id, name);

            return category;
        } else {
            return null;
        }
    }

    public static Category addsearchCategory(String code) throws SQLException {

        String sql = "Select * from Category where categoryId = '" + code + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Category category = new Category(code);
            return category;
        } else {
            return null;
        }
    }

//    public static Product searchDescription(String description) throws SQLException {
//
//        String sql = "Select * From Product Where productDescription='" + description + "'";
//        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
//        if (rst.next()) {
//            String code = rst.getString("productCode");
//            double unitPrice = rst.getDouble("productUnitPrice");
//            int qty = rst.getInt("productQtyOnHand");
//            int reorderLevel = rst.getInt("productReorderLevel");
//            String categoryId = rst.getString("categoryId");
//            String grade = rst.getString("grade");
//            double unitWeight = rst.getDouble("unitWeight");
//
//            Product product = new Product(code, description, grade, unitWeight, unitPrice, qty, reorderLevel, categoryId);
//            return product;
//        } else {
//            return null;
//        }
//    }

    public static void viewCategory(JTable table, String sql) {
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
            Logger.getLogger(CategoryUtilities.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
