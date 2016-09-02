/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierPayment;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Cash {
    
    private String paymentId;
    private String grnId;
    private Date payDate;
    private double amount;

    public Cash() {
    }

    public Cash(String paymentId) {
        this.paymentId = paymentId;
    }

    public Cash(String paymentId, String grnId, double amount) {
        this.paymentId = paymentId;
        this.grnId = grnId;
        this.amount = amount;
    }

    public Cash(String paymentId, String grnId, Date payDate, double amount) {
        this.paymentId = paymentId;
        this.grnId = grnId;
        this.payDate = payDate;
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getGrnId() {
        return grnId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public String getPaymentId() {
        return paymentId;
    }
    
}
