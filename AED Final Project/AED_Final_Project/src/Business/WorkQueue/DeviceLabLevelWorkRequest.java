/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author divinity
 */
public class DeviceLabLevelWorkRequest extends WorkRequest {
    
    private String testResult;
    private String FDAApproved;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getFDAApproved() {
        return FDAApproved;
    }

    public void setFDAApproved(String FDAApproved) {
        this.FDAApproved = FDAApproved;
    }

    
    
}
