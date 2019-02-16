/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author User
 */
public class Address {
    
    private String st_addr;
    private String city;
    private String state;
    private String zip_code;

    public String getSt_addr() {
        return st_addr;
    }

    public void setSt_addr(String st_addr) {
        this.st_addr = st_addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    
    
}
