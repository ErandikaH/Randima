/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBCon;
import utility.DBHandle;

/**
 *
 * @author dell
 */
public class AutoGenerateId {
    
    public static  String getNextId(String primaryKeyColumn,String table,String prefix){
        
        String id = prefix +"0000";
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

            String numPart= nf.format(lastNumber);
            if(numPart.contains(",")){
                id = prefixPart + numPart.replace(",","");
            }else{
                id = prefixPart + numPart;
            }
            
            //id = prefixPart + nf.format(lastNumber);
        

        } catch (SQLException ex) {
            Logger.getLogger(AutoGenerateId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
}
