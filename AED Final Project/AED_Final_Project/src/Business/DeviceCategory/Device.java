/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeviceCategory;

import Business.Enterprise.Enterprise;
//import UserInterface.EnterpriseWorkQueues.EmailCommunicationJPanel;


import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author divinity
 */
public class Device {

    private String deviceId;
    private String deviceName;
    private Enterprise enterprise;
    private double makinPrice;
    private double sellingPrice;
    private int totalOrderQuantity;

    //private EmailCommunicationJPanel  emailComm;
    private int orderQuantity;

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getMakinPrice() {
        return makinPrice;
    }

    public void setMakinPrice(double makinPrice) {
        this.makinPrice = makinPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public Device( String name, Double makingPrice, Double sellingPrice) {

        this.deviceId = deviceIdGenerator();
        this.deviceName = name;
        this.makinPrice = makingPrice;
        this.sellingPrice = sellingPrice;

}
    private String deviceIdGenerator() {

        int rand_int1 = ThreadLocalRandom.current().nextInt();
        String deviceRefId = "DEVICE_" + rand_int1;
        return deviceRefId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return getDeviceName();
    }





    public int getTotalOrderQuantity() {
        return totalOrderQuantity;
    }

    public void setTotalOrderQuantity(int totalOrderQuantity) {
        this.totalOrderQuantity = totalOrderQuantity;
    }



}
