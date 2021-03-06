/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeWorkArea;

import Business.DeviceCategory.Device;
import UserInterface.EnterpriseWorkQueues.ManufacturerWorkQueueJPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import UserInterface.EnterpriseWorkQueues.HealthcareWorkQueueJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


/**
 *
 * @author divinity
 */
public class AdministrativeWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdministrativeWorkAreaJPanel
     */
    private static int quantity;
    private double totalRevenue;
    private double revenue;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount account;
    public AdministrativeWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem business) {
        initComponents();
        if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.HealthcareProvider)){
            deviceCatalogjButton.setEnabled(false);
            devicePerformanceBtn.setEnabled(false);
        }
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        valueLabel.setText(enterprise.getName());
        System.out.println(enterprise);
        System.out.println(enterprise.getEnterpriseType());
        this.business = business;
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        employeeAccessJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        deviceCatalogjButton = new javax.swing.JButton();
        workQueueJButton = new javax.swing.JButton();
        devicePerformanceBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(201, 218, 229));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("My Work Area - Enterprise Admin Role");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        employeeAccessJButton.setText("Manage Employee Access");
        employeeAccessJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeAccessJButtonActionPerformed(evt);
            }
        });
        add(employeeAccessJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 230, -1));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 200, 20));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 20));

        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 230, -1));

        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        add(manageOrganizationJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 230, -1));

        deviceCatalogjButton.setText("Manage Device Catalogue");
        deviceCatalogjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceCatalogjButtonActionPerformed(evt);
            }
        });
        add(deviceCatalogjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 230, -1));

        workQueueJButton.setText("Manage Work Queue");
        workQueueJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workQueueJButtonActionPerformed(evt);
            }
        });
        add(workQueueJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 230, -1));

        devicePerformanceBtn.setText("Device Performance Dashboard");
        devicePerformanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devicePerformanceBtnActionPerformed(evt);
            }
        });
        add(devicePerformanceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void employeeAccessJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeAccessJButtonActionPerformed
        // TODO add your handling code here:
        ManageEmployeeAccessJPanel manageEmployeeJPanel = new ManageEmployeeAccessJPanel(userProcessContainer,  enterprise);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
       
    }//GEN-LAST:event_employeeAccessJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganizationJPanel manageNetworkJPanel=new ManageOrganizationJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("manageNetworkJPanel",manageNetworkJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void deviceCatalogjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviceCatalogjButtonActionPerformed
        // TODO add your handling code here:
        ManageDeviceJPanel managedevice=new ManageDeviceJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("device",managedevice);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_deviceCatalogjButtonActionPerformed

    private void workQueueJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workQueueJButtonActionPerformed
        // TODO add your handling code here:
        if(enterprise.getEnterpriseType().toString().equals("Manufacturer")){
        ManufacturerWorkQueueJPanel managemanufacturerequeue =new ManufacturerWorkQueueJPanel(userProcessContainer, account, enterprise, business);
        userProcessContainer.add("manufacturequeue",managemanufacturerequeue);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        
        else if((enterprise.getEnterpriseType().toString().equals("Healthcare Provider"))){
        HealthcareWorkQueueJPanel managehealthcarequeue =new HealthcareWorkQueueJPanel(userProcessContainer, account, enterprise, business);
        userProcessContainer.add("healthcarequeue",managehealthcarequeue);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        
    }//GEN-LAST:event_workQueueJButtonActionPerformed

    private void devicePerformanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devicePerformanceBtnActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset pieDataset= new DefaultPieDataset();
        double total= generateTotalRevenue();
        for(Device dev1: enterprise.getDeviceDirectory().getDeviceList()){
            System.out.println("Inside pie chart work queue");
            
           

                System.out.println("Inside pie chart Device list if condition");

                    
                System.out.println("Inside pie chart Device list");
                double makePrice= dev1.getMakinPrice();
                double sellPrice=   dev1.getSellingPrice();
                quantity= dev1.getTotalOrderQuantity();
                System.out.println("Device total quantity:"+ quantity);
                revenue= (((sellPrice- makePrice)*quantity));
            System.out.println("Revenue:"+ revenue);
            
                System.out.println("divice performance:"+ (revenue/total)*100);
                pieDataset.setValue(dev1.getDeviceName(), (revenue/total)*100);
                    }
            
            
        
                                                           
    JFreeChart chart= ChartFactory.createPieChart3D("Device Performance", pieDataset, true, true, false);
    PiePlot3D p= (PiePlot3D) chart.getPlot();
    p.setStartAngle(0);
    p.setDirection(Rotation.CLOCKWISE);
    p.setForegroundAlpha(0.5f);
    ChartFrame frame= new ChartFrame("Pie Chart Evaluaton", chart);
    frame.setVisible(true);
    frame.setSize(1000, 700);
        
    }//GEN-LAST:event_devicePerformanceBtnActionPerformed

        private double generateTotalRevenue(){
        totalRevenue=0;
        for(Device dev: enterprise.getDeviceDirectory().getDeviceList()){
            System.out.println("dev"+ dev.getDeviceName() + "selling price" + dev.getSellingPrice()
            + "making price" + dev.getMakinPrice() + "order quantity" + dev.getTotalOrderQuantity());
            totalRevenue= (((dev.getSellingPrice())-(dev.getMakinPrice()))*(dev.getTotalOrderQuantity()))+totalRevenue; 
        }
        System.out.println("Total Revenue:"+ totalRevenue);
        return totalRevenue;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deviceCatalogjButton;
    private javax.swing.JButton devicePerformanceBtn;
    private javax.swing.JButton employeeAccessJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton workQueueJButton;
    // End of variables declaration//GEN-END:variables
}
