/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyerPayment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ValidationPayment {
    
    public static boolean isValidPaymentId(String id) {

        if (id.isEmpty()) {
            return false;
        }

        if (id.length() < 10 || id.length() > 20) {
            return false;
        }

        if (!id.startsWith("RE-CP-")) {
            return false;
        }

        String prefix = id.substring(6);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                //id = id.substring(0, id.length() - 1);
                return false;
            }
        }

        return true;
    }

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
    
    public static boolean isValidChequeNo(String chequeNo) {

        if (chequeNo.isEmpty()) {
            return false;
        }

        if (chequeNo.length() > 20) {
            return false;
        }

        String prefix = chequeNo.substring(0, chequeNo.length());
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {

            if (!Character.isDigit(ch)) {
                if (!Character.isWhitespace(ch)) {
                    return false;
                }
            }

        }


        return true;
    }

    public static boolean isValidAmount(String amount) {

        if (amount.isEmpty()) {
            return false;
        }

        if (amount.length() > 12) {
            return false;
        }

        char last = amount.charAt(amount.length() - 1);
        String previous = amount.substring(0, amount.length() - 1);

        if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
            return false;
        }

        return true;
    }

    public static boolean isValidStatus(String status) {

        if (status.isEmpty()) {
            return false;
        }

        String st = status.substring(0, status.length());

        if (!("true".equals(st) || "false".equals(st))) {
            return false;

        }
        return true;
    }

    public static boolean isValidDate(String date) {

        if (!date.isEmpty()) {

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
        }

        return true;

    }

    public static boolean isValidBankName(String bankName) {

        if (!bankName.isEmpty()) {

            if (bankName.length() > 50) {
                return false;
            }

            char ch1 = bankName.charAt(0);
            if (!Character.isUpperCase(ch1)) {
                return false;
            }

            String prefix = bankName.substring(0, bankName.length());
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
    
}
