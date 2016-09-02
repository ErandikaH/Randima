/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Order {
    
    private String orderId;
    private String buyerId;
    private Boolean status;
    private Date orderDate;
    private Date deliveryDate;
    
    public Order() {
    }

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public Order(String orderId, String buyerId, Boolean status) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.status = status;
    }

    public Order(String orderId, String buyerId, Boolean status, Date orderDate, Date deliveryDate) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getStatus() {
        return status;
    }

    
}

    