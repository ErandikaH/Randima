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
public class Cheque {
    
    private String paymentId;
    private String chequeNo;
    private String bankName;
    private Date chequeDate;
    private boolean status;
    private double chequeAmount;

    public Cheque() {
    }

    public Cheque(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Cheque(String paymentId, String chequeNo, Date chequeDate) {
        this.paymentId = paymentId;
        this.chequeNo = chequeNo;
        this.chequeDate = chequeDate;
    }

    public Cheque(String chequeNo,String paymentId, String bankName, Date chequeDate, boolean status) {
        this.paymentId = paymentId;
        this.chequeNo = chequeNo;
        this.bankName = bankName;
        this.chequeDate = chequeDate;
        this.status = status;
    }

    public Cheque(String chequeNo,String paymentId, String bankName, Date chequeDate, boolean status, double chequeAmount) {
        this.paymentId = paymentId;
        this.chequeNo = chequeNo;
        this.bankName = bankName;
        this.chequeDate = chequeDate;
        this.status = status;
        this.chequeAmount = chequeAmount;
    }

    public void setChequeAmount(double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }


    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBankName() {
        return bankName;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public double getChequeAmount() {
        return chequeAmount;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public boolean isStatus() {
        return status;
    }
    
}
