/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ValidationGRN {

    public static boolean isValidGrnId(String id) {
        
        if(id.isEmpty()){
            return false;
        }

        if (id.length() < 10 || id.length() > 12) {
            return false;
        }

        if (!id.startsWith("RECCS")) {
            return false;
        }
        
        String prefix = id.substring(5);        
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                //id = id.substring(0, id.length() - 1);
                return false;
            }
        }

        return true;
    }
    
    public static boolean isValidSupId(String id) {
        
        if(id.isEmpty()){
            return false;
        }

        if (id.length() < 11 || id.length() > 12) {
            return false;
        }

        if (!id.startsWith("RE-SP-S")) {
            return false;
        }
       
        String prefix = id.substring(7);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                //id = id.substring(0, id.length() - 1);
                return false;
            }
        }

        return true;
    }
    
    public static boolean isValidDate(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date testDate = null;

        try {
            testDate = sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }

        if (!sdf.format(testDate).equals(date)) {
            return false;
        }

        return true;

    }
    
    public static boolean isValidAmount(String amount){
        
        if(amount.isEmpty()){
            return false;
        }
        
        if(amount.length()>15){
            return false;
        }
        
        char last = amount.charAt(amount.length()-1);
        String previous = amount.substring(0, amount.length()-1);
        
        if(!Character.isDigit(last) && !(last == '.' && !previous.contains("."))){
            return false;
        }

        return true;
    }
}
