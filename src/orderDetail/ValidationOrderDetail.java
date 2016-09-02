/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

/**
 *
 * @author PC
 */
public class ValidationOrderDetail {

    public static boolean isValidOrderId(String id) {

        if (id.isEmpty()) {
            return false;
        }

        if (id.length() < 19 || id.length() > 20) {
            return false;
        }

        if (!id.startsWith("SLRE-CBQC-T001-D")) {
            return false;
        }

        String prefix = id.substring(16);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                return false;
            }
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

    public static boolean isValidContainerNo(String containerNo) {

        if (!containerNo.isEmpty()) {

            if (containerNo.length() > 20) {
                return false;
            }

            String st = containerNo.substring(0, containerNo.length());
            char[] digit = st.toCharArray();
            for (char ch : digit) {
                if (!Character.isDigit(ch) && !Character.isUpperCase(ch)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidDiscount(String discount) {

        if (!discount.isEmpty()) {

            if (discount.length() > 4) {
                return false;
            }

            char last = discount.charAt(discount.length() - 1);
            String previous = discount.substring(0, discount.length() - 1);

            if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
                return false;
            }
        }

        return true;
    }
}
