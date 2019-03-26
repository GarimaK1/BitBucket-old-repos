/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, String email, Employee employee, Role role) {
        UserAccount userAccount = null;
        if (checkIfUsernameIsUnique(username)) {
            userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setEmailId(email);
            userAccount.setEmployee(employee);
            userAccount.setRole(role);
            userAccountList.add(userAccount);
            //Organization.completeUserList.add(username);
            //EcoSystem.checkUserList.add(username);
//            System.out.println("adding person to orgy complete user list: " + username + ", New size: " + Organization.completeUserList.size());
//            System.out.println("adding person to ecosystem complete user list: " + username + ", New size: " + EcoSystem.checkUserList.size());
//            System.out.println(userAccount.getEmailId());
            return userAccount;
        } else {
            JOptionPane.showMessageDialog(null, "Username already Exist !");
        }
        return userAccount;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        System.out.println("Checking username unique");
        for (int i = 0; i < Organization.completeUserList.size(); i++) {
            String user = Organization.completeUserList.get(i);
            System.out.println("List element: " + user);
            if (user.equals(username)) {
                System.out.println("username matches");
                return false;
            }
        }
        return true;
    }
//
//    public boolean checkIfUsernameIsUniqueLooping(String username) {
//        DB4OUtil dB4OUtil = DB4OUtil.getInstance();
//        if(dB4OUtil != null){
//        EcoSystem system = dB4OUtil.retrieveSystem();
//        
//
//        for (Network network : system.getNetworkList()) {
//            //Step 2.a: check against each enterprise
//            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
//                for (UserAccount userAcc : enterprise.getUserAccountDirectory().getUserAccountList()) {
//                    System.out.println("enterprise users " + userAcc.getUsername());
//                    if (userAcc.getUsername().equalsIgnoreCase(username)) {
//
//                        return false;
//                    }
//                }
//
//                //Step 3:check against each organization for each enterprise
//                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
//                    for (UserAccount userAcc1 : organization.getUserAccountDirectory().getUserAccountList()) {
//                        System.out.println("enterprise users " + userAcc1.getUsername());
//                        if (userAcc1.getUsername().equalsIgnoreCase(username)) {
//                            return false;
//                        }
//
//                    }
//
//                }
//
//            }
//        }
//      }
//        return true;
//    }

}
