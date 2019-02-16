/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
//import Business.Demographic;
/**
 *
 * @author User
 */
public class Person {
    Demographic demog;
    Address address;
    Savings savings;
    Checking checking;
    DLInfo dlinfo;
    Medical medical;
    
    public Person(){
        demog = new Demographic();
        address = new Address();
        savings = new Savings();
        checking = new Checking();
        dlinfo = new DLInfo();
        medical = new Medical();
    }

    public Demographic getDemog() {
        return demog;
    }

    public void setDemog(Demographic demog) {
        this.demog = demog;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    public DLInfo getDlinfo() {
        return dlinfo;
    }

    public void setDlinfo(DLInfo dlinfo) {
        this.dlinfo = dlinfo;
    }

    public Medical getMedical() {
        return medical;
    }

    public void setMedical(Medical medical) {
        this.medical = medical;
    }
   
}
