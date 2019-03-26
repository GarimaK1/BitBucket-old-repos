/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.DeviceCategory.Device;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {
    private String parentId;
    private String requestId;
    private Device device;
    private Enterprise enterprise;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private WorkRequest parentRequestObject;
    private WorkRequest childRequestObject;

    public WorkRequest() {
        requestDate = new Date();
        int rand_int1 = ThreadLocalRandom.current().nextInt();
        this.requestId = "REQ_" + rand_int1;
        System.out.println("in super class constructor" + requestId);
        
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return getDevice().getDeviceName();
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public WorkRequest getParentRequestObject() {
        return parentRequestObject;
    }

    public void setParentRequestObject(WorkRequest parentRequestObject) {
        this.parentRequestObject = parentRequestObject;
    }

    public WorkRequest getChildRequestObject() {
        return childRequestObject;
    }

    public void setChildRequestObject(WorkRequest childRequestObject) {
        this.childRequestObject = childRequestObject;
    }
    
    

}
