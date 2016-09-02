/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import utility.DBCon;
import utility.DBHandle;

/**
 *
 * @author PC
 */
public class Utility {
    
    public static  String getNextId(String primaryKeyColumn,String table,String prefix){
        
        String id = prefix +"000";
        String query = "SELECT "+primaryKeyColumn+" from "+table+" ORDER BY 1 DESC LIMIT 1";
        try {

            ResultSet res = DBHandle.getData(DBCon.getConnection(), query);

            if(res != null && res.next()){
                id = res.getString(1);
            }
            //Iabcb256

            //I000
            int length = id.length();
            int index = 0;
            for(int i = length - 1; i >= 0; i--){

                if(!Character.isDigit(id.charAt(i))){
                    index = i + 1;
                    break;
                }
            }

            String numericPart = id.substring(index);
            int lastNumber = Integer.parseInt(numericPart);
            lastNumber++;

            String prefixPart = id.substring(0, index);

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);

            id = prefixPart + nf.format(lastNumber);
        

        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
        
    public void descriptionComboBId(JComboBox comboBox , String sql){
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

            if(rst!=null){
                while (rst.next()) {
                    String item = rst.getString(1);
                    comboBox.addItem(item);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    public void descriptionComboName(JComboBox comboBox , String sql){
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

            if(rst!=null){
                while (rst.next()) {
                    String item = rst.getString(1);
                    comboBox.addItem(item);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    public void descriptionComboItem(JComboBox comboBox , String sql){
        try {
            ResultSet rst = DBHandle.getData(DBCon.getConnection(), sql);

            if(rst!=null){
                while (rst.next()) {
                    String item = rst.getString(1);
                    comboBox.addItem(item);
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static  StringBuilder getNextPaymentId(String primaryKeyColumn,String table,String prefix){
        
        String id = prefix +"0000";
        StringBuilder sb = null;
        String query = "SELECT "+primaryKeyColumn+" from "+table+" ORDER BY 1 DESC LIMIT 1";
        try {

            ResultSet res = DBHandle.getData(DBCon.getConnection(), query);

            if(res != null && res.next()){
                id = res.getString(1);
            }
            //Iabcb256

            //I000
            int length = id.length();
            int index = 0;
            for(int i = length - 1; i >= 0; i--){

                if(!Character.isDigit(id.charAt(i))){
                    index = i + 1;
                    break;
                }
            }

            String numericPart = id.substring(index);
            int lastNumber = Integer.parseInt(numericPart);
            lastNumber++;

            String prefixPart = id.substring(0, index);

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(4);

            id = prefixPart + nf.format(lastNumber);
            
            int i = id.indexOf(",");
            sb = new StringBuilder(id);
            sb.deleteCharAt(i);
        

        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb;
    }
    
    public static  StringBuilder getNextBuyerId(String primaryKeyColumn,String table,String prefix){
        
        String id = prefix +"0000";
        StringBuilder sb = null;
        String query = "SELECT "+primaryKeyColumn+" from "+table+" ORDER BY 1 DESC LIMIT 1";
        try {

            ResultSet res = DBHandle.getData(DBCon.getConnection(), query);

            if(res != null && res.next()){
                id = res.getString(1);
            }
            //Iabcb256

            //I000
            int length = id.length();
            int index = 0;
            for(int i = length - 1; i >= 0; i--){

                if(!Character.isDigit(id.charAt(i))){
                    index = i + 1;
                    break;
                }
            }

            String numericPart = id.substring(index);
            int lastNumber = Integer.parseInt(numericPart);
            lastNumber++;

            String prefixPart = id.substring(0, index);

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(4);

            id = prefixPart + nf.format(lastNumber);
            
            int i = id.indexOf(",");
            sb = new StringBuilder(id);
            sb.deleteCharAt(i);
        

        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb;
    }
    
    public static  String getNextProductCode(String primaryKeyColumn,String table,String prefix){
        
        String id = prefix +"000";
        String query = "SELECT "+primaryKeyColumn+" from "+table+" ORDER BY 1 DESC LIMIT 1";
        try {

            ResultSet res = DBHandle.getData(DBCon.getConnection(), query);

            if(res != null && res.next()){
                id = res.getString(1);
            }
            //Iabcb256

            //I000
            int length = id.length();
            int index = 0;
            for(int i = length - 1; i >= 0; i--){

                if(!Character.isDigit(id.charAt(i))){
                    index = i + 1;
                    break;
                }
            }

            String numericPart = id.substring(index);
            int lastNumber = Integer.parseInt(numericPart);
            lastNumber++;

            String prefixPart = id.substring(0, index);

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);

            id = prefixPart + nf.format(lastNumber);
        

        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
       
}
