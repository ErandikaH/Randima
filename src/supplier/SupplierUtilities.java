/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

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
public class SupplierUtilities {

    public static int addSupplier(Supplier supplier) throws SQLException {

        String sql = "INSERT INTO Supplier (supId,supName,supCity,supEMail,supCompanyName,supAddress,supTelephone) VALUES ('" + supplier.getSupId() + "','" + supplier.getSupName() + "','" + supplier.getCity() + "','" + supplier.geteMail() + "','" + supplier.getComName() + "','" + supplier.getAddress() + "','" + supplier.getTelephone() + "')";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int updateSupplier(Supplier supplier) throws SQLException {

        String sql = "Update Supplier SET supName = '" + supplier.getSupName() + "',supCity = '" + supplier.getCity() + "',supEMail = '" + supplier.geteMail() + "',supCompanyName = '" + supplier.getComName() + "',supAddress = '" + supplier.getAddress() + "',supTelephone = '" + supplier.getTelephone() + "' where supId = '" + supplier.getSupId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int deleteSupplier(Supplier supplier) throws SQLException {

        String sql = "Delete from Supplier where supId ='" + supplier.getSupId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static Supplier searchSupplier(String id) throws SQLException {

        String sql = "Select * from Supplier where supId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {

            String name = rst.getString("supName");
            String city = rst.getString("supCity");
            String eMail = rst.getString("supEMail");
            String companyName = rst.getString("supCompanyName");
            String address = rst.getString("supAddress");
            String telephone = rst.getString("supTelephone");

            Supplier supplier = new Supplier(id, name, city, eMail, companyName, address, telephone);

            return supplier;
        } else {
            return null;
        }
    }

    public static Supplier addsearchSupplier(String id) throws SQLException {

        String sql = "Select * from Supplier where supId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Supplier supplier = new Supplier(id);
            return supplier;
        } else {
            return null;
        }
    }

    public static Supplier searchSupplierName(String name) throws SQLException {

        String sql = "Select * From Supplier Where supName='" + name + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);
        if (rst.next()) {
            String id = rst.getString("supId");
            String city = rst.getString("supCity");
            String eMail = rst.getString("supEMail");
            String companyName = rst.getString("supCompanyName");
            String address = rst.getString("supAddress");
            String telephone = rst.getString("supTelephone");

            Supplier supplier = new Supplier(id, name, city, eMail, companyName, address, telephone);
            return supplier;
        } else {
            return null;
        }
    }

    public static void viewSupplier(JTable table, String sql) {
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
            Logger.getLogger(SupplierUtilities.class.getName()).log(Level.SEVERE, null, ex);
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
