/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class DLInfo {
    private String lnumber;
    private String issue_dt;
    private String expir_dt;
    private String blood_type;
    private ImageIcon i;  ///////////think this through.       

    public ImageIcon getI() {
        return i;
    }

    public void setI(ImageIcon i) {
        this.i = i;
    }

    public String getLnumber() {
        return lnumber;
    }

    public void setLnumber(String lnumber) {
        this.lnumber = lnumber;
    }

    public String getIssue_dt() {
        return issue_dt;
    }

    public void setIssue_dt(String issue_dt) {
        this.issue_dt = issue_dt;
    }

    public String getExpir_dt() {
        return expir_dt;
    }

    public void setExpir_dt(String expir_dt) {
        this.expir_dt = expir_dt;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }
    
}
