/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author PC
 */
public class Item {
    
    private String Itemcode;
    private String description;
    private double unitPrice;
    private int qty;
    private int reorderLevel;

    public Item() {
    }

    public Item(String Itemcode) {
        this.Itemcode = Itemcode;
    }

    public Item(String description, int qty) {
        this.description = description;
        this.qty = qty;
    }

    public Item(String Itemcode, String description, int qty) {
        this.Itemcode = Itemcode;
        this.description = description;
        this.qty = qty;
    }

    public Item(String Itemcode, String description, double unitPrice, int qty, int reorderLevel) {
        this.Itemcode = Itemcode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.reorderLevel = reorderLevel;
    }

    public void setItemcode(String Itemcode) {
        this.Itemcode = Itemcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getItemcode() {
        return Itemcode;
    }

    public String getDescription() {
        return description;
    }

    public int getQty() {
        return qty;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
}
