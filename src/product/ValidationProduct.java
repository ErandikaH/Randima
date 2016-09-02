/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author PC
 */
public class ValidationProduct {

    public static boolean isValidPrice(String price) {

        if (price.isEmpty()) {
            return false;
        }

        if (price.length() > 5) {
            return false;
        }

        char last = price.charAt(price.length() - 1);
        String previous = price.substring(0, price.length() - 1);

        if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
            return false;
        }

        return true;
    }

    public static boolean isValidProductCode(String code) {

        if (code.isEmpty()) {
            return false;
        }

        if (code.length() < 6 || code.length() > 12) {
            return false;
        }

        if (!code.startsWith("PSC")) {
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

    public static boolean isValidQty(String qty) {

        if (qty.isEmpty()) {
            return false;
        }

        if (qty.length() > 6) {
            return false;
        }

        String st = qty.substring(0, qty.length());
        char[] digit = st.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidROL(String rol) {

        if (!rol.isEmpty()) {

            if (rol.length() > 4) {
                return false;
            }

            String st = rol.substring(0, rol.length());
            char[] digit = st.toCharArray();
            for (char ch : digit) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidDescription(String description) {

        if (description.isEmpty()) {
            return false;
        }

        if (description.length() > 50) {
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

    public static boolean isValidGrade(String grade) {

        if (!grade.isEmpty()) {

            if (grade.length() > 50) {
                return false;
            }

            char ch = grade.charAt(0);
            if (!Character.isUpperCase(ch)) {
                return false;
            }

            if (grade.contains(",") || grade.contains(";") || grade.contains("?") || grade.contains("!") || grade.contains("#") || grade.contains("(") || grade.contains(")") || grade.contains("*") || grade.contains("-") || grade.contains("+") || grade.contains("&") || grade.contains("$") || grade.contains("/") || grade.contains("@") || grade.contains(":") || grade.contains(">") || grade.contains("[") || grade.contains("]")) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidWeight(String weight) {

        if (weight.isEmpty()) {
            return false;
        }

        if (weight.length() > 6) {
            return false;
        }

        char last = weight.charAt(weight.length() - 1);
        String previous = weight.substring(0, weight.length() - 1);

        if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
            return false;
        }

        return true;
    }
}
