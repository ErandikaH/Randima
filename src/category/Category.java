/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

/**
 *
 * @author PC
 */
public class Category {
    
    String categoryId;
    String categoryName;

    public Category() {
    }

    public Category(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    
}
