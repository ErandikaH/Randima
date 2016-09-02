/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

/**
 *
 * @author PC
 */
public class SupplierValidation {
    
    public static boolean isValidSupId(String id) {

        if (id.isEmpty()) {
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
                // id = id.substring(0, id.length() - 1);
                return false;
            }
        }

        return true;
    }

    public static boolean isValidSupName(String name) {

        if (name.isEmpty()) {
            return false;
        }

        if (name.length() > 30) {
            return false;
        }

        char ch1 = name.charAt(0);
        if (!Character.isUpperCase(ch1)) {
            return false;
        }

        if (name.contains(",") || name.contains(";") || name.contains("?") || name.contains("!") || name.contains("#") || name.contains("(") || name.contains(")") || name.contains("*") || name.contains("-") || name.contains("+") || name.contains("&") || name.contains("$") || name.contains("/") || name.contains("@") || name.contains(":") || name.contains(">")) {
            return false;
        }
        String prefix = name.substring(0, name.length());
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (Character.isDigit(ch)) {
                return false;

            }
        }
        return true;
    }

    public static boolean isAValidCompanyName(String companyName) {

        if (!companyName.isEmpty()) {

            if (companyName.length() > 60) {
                return false;
            }

            char ch1 = companyName.charAt(0);
            if (!Character.isUpperCase(ch1)) {
                return false;
            }

            String prefix = companyName.substring(0, companyName.length());
            char[] digit = prefix.toCharArray();
            for (char ch : digit) {
                if (Character.isDigit(ch)) {
                    return false;

                }

                if (companyName.contains(",") || companyName.contains(";") || companyName.contains("?") || companyName.contains("!") || companyName.contains("#") || companyName.contains("*") || companyName.contains("-") || companyName.contains("+") || companyName.contains("$") || companyName.contains("/") || companyName.contains("@") || companyName.contains(":") || companyName.contains(">") || companyName.contains("<")) {
                    return false;

                }
            }
        }
        return true;
    }

    public static boolean isValidCity(String city) {

        if (!city.isEmpty()) {

            if (city.length() > 20) {
                return false;
            }

            char ch1 = city.charAt(0);
            if (!Character.isUpperCase(ch1)) {
                return false;
            }

            String prefix = city.substring(0, city.length());
            char[] digit = prefix.toCharArray();
            for (char ch : digit) {

                if (!Character.isLetter(ch)) {
                    if (!Character.isWhitespace(ch)) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    public static boolean isValidTelephone(String tel) {

        if (!tel.isEmpty()) {

            if (tel.length() > 15) {
                return false;
            }

            if (tel.contains(",") || tel.contains(".") || tel.contains(";") || tel.contains("?") || tel.contains("!") || tel.contains("#") || tel.contains("*") || tel.contains("$") || tel.contains("&") || tel.contains("/") || tel.contains("@") || tel.contains(":") || tel.contains(">") || tel.contains("<")) {
                return false;
            }

            String prefix = tel.substring(0, tel.length());
            char[] digit = prefix.toCharArray();
            for (char ch : digit) {
                if (Character.isLetter(ch)) {
                    return false;

                }

            }
        }
        return true;
    }

    public static boolean isAValidMail(String email) {

        if (!email.isEmpty()) {

            if (email.length() > 40) {
                return false;
            }

            if (email.trim().contains(" ")) {
                return false;
            }

            if (!(email.contains("@") && email.contains("."))) {
                return false;
            } else {
                int indexOfAt = email.indexOf("@");
                int indexOfDot = email.lastIndexOf(".");

                int lastIndexOfAt = email.lastIndexOf("@");

                if (!(indexOfAt == lastIndexOfAt)) {
                    return false;
                }

                if (indexOfDot < indexOfAt) {
                    return false;
                }

                String beforeAt = email.substring(0, indexOfAt);
                String middle = email.substring(indexOfAt, indexOfDot);
                String afterDot = email.substring(indexOfDot);


                if (beforeAt.isEmpty()) {
                    return false;
                }

                if (middle.trim().equals("@")) {
                    return false;
                }

                if (afterDot.trim().equals(".")) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isValidAddress(String companyAddress) {

        if (!companyAddress.isEmpty()) {
            if (companyAddress.length() > 50) {
                return false;
            }
            if (companyAddress.contains(";") || companyAddress.contains("?") || companyAddress.contains("!") || companyAddress.contains("*") || companyAddress.contains("+") || companyAddress.contains("$") || companyAddress.contains("@") || companyAddress.contains(":") || companyAddress.contains(">") || companyAddress.contains("<")) {
                return false;
            }
        }
        return true;
    }
    
}
