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
import Business.Organization.AuthorizationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AuthorizationWorkArea.AuthorizationWorkAreaJPanel;

import javax.swing.JPanel;

public class AuthorizationRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AuthorizationWorkAreaJPanel(userProcessContainer, account, (AuthorizationOrganization)organization, enterprise,  business);
    }
    
        @Override
    public String toString() {
        return "Healthcare Representative";
    }
    
}
