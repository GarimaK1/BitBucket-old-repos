/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

/**
 *
 * @author divinity
 */
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SalesWorkArea.SalesWorkAreaJPanel;

import javax.swing.JPanel;

public class SalesRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        System.out.println("business we are passing " + business.getNetworkList());
        return new SalesWorkAreaJPanel(userProcessContainer, account, (SalesOrganization) organization, enterprise, business);
    }

    @Override
    public String toString() {
        return "Sales Representative";
    }

}
