/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DeviceLab.getValue())){
            organization = new DeviceLabOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Authorization.getValue())){
            organization = new AuthorizationOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Sales.getValue())){
            organization = new SalesOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new DeviceLabOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}