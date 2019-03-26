/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DeviceLabAssitantWorkArea.DeviceLabAssistantWorkAreaJPanel;

import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DeviceLabAssistantWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
    }

    @Override
    public String toString() {
        return "Lab Assistant";
    }

}
