/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buyer;

/**
 *
 * @author PC
 */
public class Buyer {
    
    private String buyerId;
    private String buyerTitle;
    private String buyerName;
    private String companyName;
    private String companyAddress;
    private String city;
    private String country;
    private String eMailAddress;
    private String webSite;
    private String telephone;
    private String Fax;
    private String postalCode;
    
    public Buyer(){ 
    }
    
    public Buyer(String buyerId){
        this.buyerId = buyerId;
    }
    
    public Buyer(String buyerId, String buyerName, String companyName, String companyAddress) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Buyer(String buyerId, String eMailAddress, String webSite, String telephone, String Fax) {
        this.buyerId = buyerId;
        this.eMailAddress = eMailAddress;
        this.webSite = webSite;
        this.telephone = telephone;
        this.Fax = Fax;
    }
    
    public Buyer(String buyerId, String companyAddress, String city, String country, String eMailAddress, String telephone){
        
        this.buyerId = buyerId;
        this.companyAddress = companyAddress;
        this.city = city;
        this.country = country;
        this.eMailAddress = eMailAddress;
        this.telephone = telephone;
        
    }
    
    public Buyer(String buyerId, String buyerTitle, String buyerName, String companyName, String companyAddress, String city, String country, String eMailAddress, String webSite, String telephone, String Fax, String postalCode) {
        this.buyerId = buyerId;
        this.buyerTitle = buyerTitle;
        this.buyerName = buyerName;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.city = city;
        this.country = country;
        this.eMailAddress = eMailAddress;
        this.webSite = webSite;
        this.telephone = telephone;
        this.Fax = Fax;
        this.postalCode = postalCode;
    }
    
    public void setBuyerId(String buyerId){
        this.buyerId = buyerId;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public void setBuyerTitle(String buyerTitle) {
        this.buyerTitle = buyerTitle;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public void setBuyerName(String buyerName){
        this.buyerName = buyerName;
    }
    
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    
    public void setAddress(String companyAddress){
        this.companyAddress = companyAddress;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public void setEMailAddress(String eMailAddress){
        this.eMailAddress = eMailAddress;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String getBuyerId(){
        return buyerId;
    }

    public String getFax() {
        return Fax;
    }

    public String getBuyerTitle() {
        return buyerTitle;
    }

    public String getWebSite() {
        return webSite;
    }
    
    public String getBuyerName(){
        return buyerName;
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public String getAddress(){
        return companyAddress;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getCountry(){
        return country;
    }
    
    public String getEMailAddress(){
        return eMailAddress;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    
}
