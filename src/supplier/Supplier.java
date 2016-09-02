/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

/**
 *
 * @author PC
 */
public class Supplier {
    
    private String supId;
    private String supName;
    private String city;
    private String eMail;
    private String comName;
    private String address;
    private String telephone;

    public Supplier() {
    }

    public Supplier(String supId) {
        this.supId = supId;
    }

    public Supplier(String supId, String supName, String eMail, String telephone) {
        this.supId = supId;
        this.supName = supName;
        this.eMail = eMail;
        this.telephone = telephone;
    }

    public Supplier(String supId, String supName, String city, String eMail, String comName, String address, String telephone) {
        this.supId = supId;
        this.supName = supName;
        this.city = city;
        this.eMail = eMail;
        this.comName = comName;
        this.address = address;
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getComName() {
        return comName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSupId() {
        return supId;
    }

    public String getSupName() {
        return supName;
    }

    public String getTelephone() {
        return telephone;
    }
    
}
