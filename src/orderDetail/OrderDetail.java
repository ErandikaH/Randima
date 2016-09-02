/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

/**
 *
 * @author PC
 */
public class OrderDetail {
    
    private String orderId;
    private String productCode;
    private int qty;
    private double discount;
    private String containerNo;
    private double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String orderId) {
        this.orderId = orderId;
    }

    public OrderDetail(String orderId, String productCode) {
        this.orderId = orderId;
        this.productCode = productCode;
    }

    public OrderDetail(String orderId, String productCode, int qty) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.qty = qty;
    }

    public OrderDetail(String orderId, String productCode, int qty, String containerNo) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.qty = qty;
        this.containerNo = containerNo;
    }

    public OrderDetail(String orderId, String productCode, int qty, double discount, String containerNo, double unitPrice) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.qty = qty;
        this.discount = discount;
        this.containerNo = containerNo;
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public double getDiscount() {
        return discount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQty() {
        return qty;
    }
    
    public String getContainerNo() {
        return containerNo;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
}
