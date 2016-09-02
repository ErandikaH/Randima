/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grn;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Grn {
    
    private String grnId;
    private String supId;
    private Date grnDate;
    private double fullAmount;

    public Grn() {
    }

    public Grn(String grnId) {
        this.grnId = grnId;
    }

    public Grn(String grnId, double fullAmount) {
        this.grnId = grnId;
        this.fullAmount = fullAmount;
    }

    public Grn(String grnId, String supId, Date grnDate, double fullAmount) {
        this.grnId = grnId;
        this.supId = supId;
        this.grnDate = grnDate;
        this.fullAmount = fullAmount;
    }

    public void setFullAmount(double fullAmount) {
        this.fullAmount = fullAmount;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public double getFullAmount() {
        return fullAmount;
    }

    public Date getGrnDate() {
        return grnDate;
    }

    public String getGrnId() {
        return grnId;
    }

    public String getSupId() {
        return supId;
    }
}
