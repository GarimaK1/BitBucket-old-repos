/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import Business.Role.AuthorizationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author divinity
 */
public class AuthorizationOrganization extends Organization {
    
    public AuthorizationOrganization() {
        super(Type.Authorization.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AuthorizationRole());
        return roles;
    }
    
}
