/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class ValidationUtil {
    
    public static boolean isAValidMail(String email){

        if(email.trim().contains(" ")){
            return false;
        }

        if(!(email.contains("@") && email.contains("."))){
            return false;
        }else{
            int indexOfAt = email.indexOf("@");
            int indexOfDot = email.lastIndexOf(".");

            int lastIndexOfAt = email.lastIndexOf("@");

            if(!(indexOfAt==lastIndexOfAt)){
                return false;
            }

            if(indexOfDot < indexOfAt){
                return false;
            }

            String beforeAt = email.substring(0, indexOfAt);
            String middle = email.substring(indexOfAt, indexOfDot);
            String afterDot = email.substring(indexOfDot);


            if(beforeAt.isEmpty()){
                return false;
            }

            if(middle.trim().equals("@")){
                return false;
            }

            if(afterDot.trim().equals(".")){
                return false;
            }

        }
        return true;

    }
    
    public static boolean isAValidBuyerID(String email){
//        String previous = email.substring(0, 7);
//        if(previous.contains(null)){
//            return false;
//        }
        if(email.trim().contains(" ")){
            return false;
        }else{

        
            if("RE-MB-B".equals(email.substring(0, 7))){
                return true;
            }

            String prefix = email.substring(7);
            char[] digit = prefix.toCharArray();
            for(char ch:digit){
                if(Character.isDigit(ch)){
                    return true;
                }
            }
        
        }
        
        
        
//        String text = priceText.getText();
//
//        if(text.isEmpty()){
//            return;
//        }
//
//        char last = text.charAt(text.length() - 1);
//        String previous = text.substring(0, text.length()-1);
//
//
//        if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
//            text = text.substring(0, text.length() - 1);
//
//        }
//
//        priceText.setText(text);

        
//        if(!(email.contains("@") && email.contains("."))){
//            return false;
//        }else{
//            int indexOfAt = email.indexOf("@");
//            int indexOfDot = email.lastIndexOf(".");
//
//            int lastIndexOfAt = email.lastIndexOf("@");
//
//            if(!(indexOfAt==lastIndexOfAt)){
//                return false;
//            }
//
//            if(indexOfDot < indexOfAt){
//                return false;
//            }
//
//            String beforeAt = email.substring(0, indexOfAt);
//            String middle = email.substring(indexOfAt, indexOfDot);
//            String afterDot = email.substring(indexOfDot);
//
//
//            if(beforeAt.isEmpty()){
//                return false;
//            }
//
//            if(middle.trim().equals("@")){
//                return false;
//            }
//
//            if(afterDot.trim().equals(".")){
//                return false;
//            }
//
//        }
        return true;

    }
    
//    public static String getValidCurrency(double value,boolean grouped){
//        NumberFormat nf = NumberFormat.getInstance();
//
//        nf.setMinimumIntegerDigits(1);
//        nf.setMaximumFractionDigits(2);
//        nf.setMinimumFractionDigits(2);
//
//       // nf.setGroupingUsed(false);
//
//        String priceLabelText=nf.format(value);
//        return priceLabelText;
//
//    }
//
//    //public static boolean isAValidName(String name){
//        Pattern namePattern = Pattern.compile("[A-Z.a-z]*");
//    //}
    
}
