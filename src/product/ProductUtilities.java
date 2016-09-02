/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import buyer.BuyerUtilities;
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
public class ProductUtilities {

    public static int addProduct(Product product) throws SQLException {

        String sql = "INSERT INTO Product (productCode,productDescription,productUnitPrice,productQtyOnHand,productReorderLevel,categoryId,grade,unitWeight) VALUES ('" + product.getProductCode() + "','" + product.getProductDescription() + "'," + product.getProductUnitPrice() + "," + product.getProductUnitPrice() + "," + product.getProductReorderLevel() + ",'" + product.getCategoryId() + "','" + product.getGrade() + "'," + product.getUnitWeight() + ")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int updateProduct(Product product) throws SQLException {

        String sql = "Update Product SET productDescription = '" + product.getProductDescription() + "',productUnitPrice = " + product.getProductUnitPrice() + ",productQtyOnHand = " + product.getProductQtyOnHand() + ",productReorderLevel = " + product.getProductReorderLevel() + ",categoryId = '" + product.getCategoryId() + "',grade = '" + product.getGrade() + "',unitWeight = " + product.getUnitWeight() + " where productCode = '" + product.getProductCode() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }
    
    public static int updateOrderProduct(Product product) throws SQLException {

        String sql = "Update Product SET productQtyOnHand = " + product.getProductQtyOnHand() + " where productCode = '" + product.getProductCode() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int deleteProduct(Product product) throws SQLException {

        String sql = "Delete from Product where productCode ='" + product.getProductCode() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static Product searchProduct(String id) throws SQLException {

        String sql = "Select * from Product where productCode = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            String description = rst.getString("productDescription");
            double unitPrice = rst.getDouble("productUnitPrice");
            int qty = rst.getInt("productQtyOnHand");
            int reorderLevel = rst.getInt("productReorderLevel");
            String categoryId = rst.getString("categoryId");
            String grade = rst.getString("grade");
            double unitWeight = rst.getDouble("unitWeight");

            Product product = new Product(id, description, grade, unitWeight, unitPrice, qty, reorderLevel, categoryId);

            return product;
        } else {
            return null;
        }
    }

    public static Product addsearchProduct(String code) throws SQLException {

        String sql = "Select * from Product where productCode = '" + code + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Product product = new Product(code);
            return product;
        } else {
            return null;
        }
    }

    public static Product searchDescription(String description) throws SQLException {

        String sql = "Select * From Product Where productDescription='" + description + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        if (rst.next()) {
            String code = rst.getString("productCode");
            double unitPrice = rst.getDouble("productUnitPrice");
            int qty = rst.getInt("productQtyOnHand");
            int reorderLevel = rst.getInt("productReorderLevel");
            String categoryId = rst.getString("categoryId");
            String grade = rst.getString("grade");
            double unitWeight = rst.getDouble("unitWeight");

            Product product = new Product(code, description, grade, unitWeight, unitPrice, qty, reorderLevel, categoryId);
            return product;
        } else {
            return null;
        }
    }

    public static void viewProduct(JTable table, String sql) {
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
}
