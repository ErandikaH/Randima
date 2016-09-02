/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author PC
 */
public class ValidationItem {
    
    public static boolean isValidPrice(String price){
        
        if(price.isEmpty()){
            return false;
        }
        
        if(price.length()>8){
            return false;
        }
        
        char last = price.charAt(price.length()-1);
        String previous = price.substring(0, price.length()-1);
        
        if(!Character.isDigit(last) && !(last == '.' && !previous.contains("."))){
            return false;
        }

        return true;
    }
    
        public static boolean isValidItemCode(String code) {
        
        if(code.isEmpty()){
            return false;
        }

        if (code.length() < 6 || code.length() > 10) {
            return false;
        }

        if (!code.startsWith("ICC") && !code.startsWith("ICH") && !code.startsWith("IQC") && !code.startsWith("ISC")) {
            return false;
        }

        String prefix = code.substring(3);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
        
    public static boolean isValidQty(String qty){
        
        if(qty.isEmpty()){
            return false;
        }
        
        if(qty.length()>15){
            return false;
        }
        
        String st = qty.substring(0, qty.length());
        char[] digit = st.toCharArray();
        for(char ch : digit){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isValidROL(String rol){
        
        if(rol.isEmpty()){
            return false;
        }
        
        if(rol.length()>10){
            return false;
        }
        
        String st = rol.substring(0, rol.length());
        char[] digit = st.toCharArray();
        for(char ch : digit){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isValidDescription(String description) {
        
        if(description.isEmpty()){
            return false;
        }
        
        if(description.length()>50){
            return false;
        }

        char ch = description.charAt(0);
        if (!Character.isUpperCase(ch)) {
            return false;
        }

        if (description.contains(",") || description.contains(";") || description.contains("?") || description.contains("!") || description.contains("#") || description.contains("(") || description.contains(")") || description.contains("*") || description.contains("-") || description.contains("+") || description.contains("&") || description.contains("$") || description.contains("/") || description.contains("@") || description.contains(":") || description.contains(">") || description.contains("[") || description.contains("]")) {
            return false;
        }
        
        return true;
    }

    
}
