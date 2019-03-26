/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeviceCategory;


import Business.Enterprise.Enterprise;
import java.util.ArrayList;
/**
 *
 * @author divinity
 */
public class DeviceDirectory {
    
        private ArrayList<Device> deviceList;

    public DeviceDirectory() {
        deviceList = new ArrayList<>();

    }

    public ArrayList<Device> getHealthcareProList() {
        return deviceList;
    }



    public Device createAndAddDevice( String name, Double makingPrice, Double sellingPrice) {
        Device dev = new Device(name, makingPrice, sellingPrice);





        deviceList.add(dev);
        System.out.println(dev.getDeviceName());
        return dev;
    }

    public ArrayList<Device> getDeviceList() {
        return deviceList;
    }
    
    
}
