/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyerPayment;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Cash {
    
    private String paymentId;
    private String orderId;
    private Date payDate;
    private double amount;

    public Cash() {
    }

    public Cash(String paymentId) {
        this.paymentId = paymentId;
    }

    public Cash(String paymentId, String orderId, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Cash(String paymentId, String orderId, Date payDate, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.payDate = payDate;
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getOrderId() {
        return orderId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public String getPaymentId() {
        return paymentId;
    }
    
}

