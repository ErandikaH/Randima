/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ValidationOrder {

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

    public static boolean isValidBuyerId(String id) {

        if (id.isEmpty()) {
            return false;
        }

        if (id.length() < 10 || id.length() > 12) {
            return false;
        }

        if (!id.startsWith("RE-MB-B")) {
            return false;
        }

        String prefix = id.substring(7);
        char[] digit = prefix.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
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
}
