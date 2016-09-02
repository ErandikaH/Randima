/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

/**
 *
 * @author PC
 */
public class CategoryValidation {
    
    public static boolean isValidCategoryId(String id) {

        if (id.isEmpty()) {
            return false;
        }

        if (id.length() < 5 || id.length() > 6) {
            return false;
        }

        if (!id.startsWith("CP")) {
            return false;
        }

        String prefix = id.substring(2);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean isValidName(String description) {

        if (description.isEmpty()) {
            return false;
        }

        if (description.length() > 30) {
            return false;
        }

        char ch = description.charAt(0);
        if (!Character.isUpperCase(ch)) {
            return false;
        }

        if (description.contains(",") || description.contains(";") || description.contains("?") || description.contains("!") || description.contains("#") || description.contains("(") || description.contains(")") || description.contains("*") || description.contains("+") || description.contains("&") || description.contains("$") || description.contains("/") || description.contains("@") || description.contains(":") || description.contains(">") || description.contains("[") || description.contains("]")) {
            return false;
        }

        return true;
    }


    
}
