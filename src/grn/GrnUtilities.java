/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grn;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
public class GrnUtilities {
    
    public static int addGrn(Grn grn) throws SQLException {

        String sql = "INSERT INTO GRN (grnId,supId,grnDate,fullAmount) VALUES ('" + grn.getGrnId() + "','" + grn.getSupId() + "','" + grn.getGrnDate() + "'," + grn.getFullAmount() + ")";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int updateGrn(Grn grn) throws SQLException {

        String sql = "Update GRN SET supId = '" + grn.getSupId() + "',grnDate = '" + grn.getGrnDate() + "',fullAmount = " + grn.getFullAmount() + " where grnId = '" + grn.getGrnId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static int deleteGrn(Grn grn) throws SQLException {

        String sql = "Delete from GRN where grnId ='" + grn.getGrnId() + "'";
        int res = DBHandle.setData(DBCon.getConnection(), sql);
        return res;
    }

    public static Grn searchGrn(String id) throws SQLException {

        String sql = "Select * from GRN where grnId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            String supId = rst.getString("supId");
            Date date = rst.getDate("grnDate");
            int amount = rst.getInt("fullAmount");
            
            Grn grn = new Grn(id, supId, date, amount);

            return grn;
        } else {
            return null;
        }
    }

    public static Grn addsearchGrn(String id) throws SQLException {

        String sql = "Select * from GRN where grnId = '" + id + "'";
        ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

        if (rst.next()) {
            Grn grn = new Grn(id);
            return grn;
        } else {
            return null;
        }
    }

    public static void viewGrn(JTable table, String sql) {
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
            Logger.getLogger(GrnUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
