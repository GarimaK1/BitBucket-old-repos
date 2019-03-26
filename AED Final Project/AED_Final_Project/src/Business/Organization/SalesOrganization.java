/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import Business.Role.SalesRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author divinity
 */
public class SalesOrganization extends Organization {
    
        public SalesOrganization() {
        super(Type.Sales.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesRole());
        return roles;
    }
}
