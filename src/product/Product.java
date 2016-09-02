/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author PC
 */
public class Product {
    
    private String productCode;
    private String productDescription;
    private String grade;
    private double unitWeight;
    private double productUnitPrice;
    private int productQtyOnHand;
    private int productReorderLevel;
    private String categoryId;

    public Product() {
    }

    public Product(String productCode) {
        this.productCode = productCode;
    }

    public Product(String productCode, int productQtyOnHand) {
        this.productCode = productCode;
        this.productQtyOnHand = productQtyOnHand;
    }

    public Product(String productCode, String productDescription, String categoryId,int productQtyOnHand) {
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.categoryId = categoryId;
        this.productQtyOnHand = productQtyOnHand;
    }

    public Product(String productCode, double unitWeight, double productUnitPrice, int productQtyOnHand, int productReorderLevel) {
        this.productCode = productCode;
        this.unitWeight = unitWeight;
        this.productUnitPrice = productUnitPrice;
        this.productQtyOnHand = productQtyOnHand;
        this.productReorderLevel = productReorderLevel;
    }

    public Product(String productCode, String productDescription, String grade, double unitWeight, double productUnitPrice, int productQtyOnHand, int productReorderLevel, String categoryId) {
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.grade = grade;
        this.unitWeight = unitWeight;
        this.productUnitPrice = productUnitPrice;
        this.productQtyOnHand = productQtyOnHand;
        this.productReorderLevel = productReorderLevel;
        this.categoryId = categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductQtyOnHand(int productQtyOnHand) {
        this.productQtyOnHand = productQtyOnHand;
    }

    public void setProductReorderLevel(int productReorderLevel) {
        this.productReorderLevel = productReorderLevel;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public void setUnitWeight(double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getGrade() {
        return grade;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductQtyOnHand() {
        return productQtyOnHand;
    }

    public int getProductReorderLevel() {
        return productReorderLevel;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public double getUnitWeight() {
        return unitWeight;
    } 
    
}
