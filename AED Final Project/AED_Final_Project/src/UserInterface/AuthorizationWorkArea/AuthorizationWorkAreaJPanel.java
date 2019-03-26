/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AuthorizationWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AuthorizationOrganization;
import Business.Organization.DeviceLabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeviceLabLevelWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.EnterpriseWorkQueues.EmailCommunicationJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author divinity
 */
public class AuthorizationWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private AuthorizationOrganization authOrganization;
    private Organization org;

    public AuthorizationWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.authOrganization = (AuthorizationOrganization) organization;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        System.out.println("My Papa " + enterprise.getName());
        populateTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : authOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];

            row[0] = request;
            //System.out.println(request.getDevice().getDeviceName());
            row[1] = request.getSender().getEmployee().getName();
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[2] = request.getStatus();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        placeOrderBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 225, 226));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device", "Sender", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Forward To Lab >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        placeOrderBtn.setText("Status Update /Place Order");
        placeOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Authorization Workarea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(refreshJButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(placeOrderBtn)
                .addGap(70, 70, 70)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(refreshJButton)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(placeOrderBtn))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }
        WorkRequest requestObjForAuthenticator = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (requestObjForAuthenticator.getStatus().equalsIgnoreCase("To Be Processed")) {

            DeviceLabLevelWorkRequest requestObjForDeviceLab = new DeviceLabLevelWorkRequest();
            //Devrequest = (DeviceLabLevelWorkRequest)request;

            requestObjForDeviceLab.setDevice(requestObjForAuthenticator.getDevice());
            requestObjForDeviceLab.setEnterprise(requestObjForAuthenticator.getEnterprise());
            requestObjForDeviceLab.setSender(userAccount);
            requestObjForDeviceLab.setStatus("To Be Processed");
            requestObjForDeviceLab.setParentId(requestObjForAuthenticator.getRequestId());
            requestObjForAuthenticator.setStatus("Sent to Lab");
            business.getAllWorkList().add(requestObjForDeviceLab);

            requestObjForAuthenticator.setChildRequestObject(requestObjForDeviceLab);
            requestObjForDeviceLab.setParentRequestObject(requestObjForAuthenticator);

            //request.setStatus("Sent to Lab");
            Organization org = null;
            Enterprise enterprise1 = null;

            for (Network net : business.getNetworkList()) {
                for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (ent.equals(requestObjForDeviceLab.getEnterprise())) {
                        for (Organization org1 : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (org1 instanceof DeviceLabOrganization) {
                                org = org1;
                                enterprise1 = ent;
                                break;
                            }
                        }
                        if (org != null && enterprise1 != null) {
                            org.getWorkQueue().getWorkRequestList().add(requestObjForDeviceLab);
                            userAccount.getWorkQueue().getWorkRequestList().add(requestObjForAuthenticator);
                            JOptionPane.showMessageDialog(null, "Device is sent for Testing");
                            //System.out.println(dev);

                        }
                    }
                }

            }
        }
        
        else if(requestObjForAuthenticator.getStatus().equalsIgnoreCase("Sent to Lab")){
           JOptionPane.showMessageDialog(null, "Device is already under Testing"); 
        }
        else if(requestObjForAuthenticator.getStatus().equalsIgnoreCase("Order Placed") ||
                requestObjForAuthenticator.getStatus().equalsIgnoreCase("Order Delivered")){        
            JOptionPane.showMessageDialog(null, "Order already Placed and Delivered !"); }
        else
            JOptionPane.showMessageDialog(null, "Device status is already updated");
        populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void placeOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderBtnActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }

        WorkRequest requestObjForAuthenticator = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        //ChangeStatusforSalesPerson(requestObjForAuthenticator);
        sendEmailMethod(requestObjForAuthenticator);


    }//GEN-LAST:event_placeOrderBtnActionPerformed
    public void ChangeStatusforSalesPersonRejected(WorkRequest req) {
        WorkRequest ParentReq = req.getParentRequestObject();
        if (req.getStatus().equals("Rejected")) {
            ParentReq.setStatus(req.getStatus());
            ChangeStatusforManufacturerReject(ParentReq);
        }
    }

    public void ChangeStatusforManufacturerReject(WorkRequest req) {

        WorkRequest ParentReq = req.getParentRequestObject();
        if (ParentReq != null) {
            ParentReq.setStatus(req.getStatus());
        }

    }

    private void sendEmailMethod(WorkRequest req) {
        String email = req.getSender().getEmailId().toString();
        String devId = req.getDevice().getDeviceId();
        if (req.getStatus().equalsIgnoreCase("Approved")) {
            System.out.println("going to email jpanel.");
            EmailCommunicationJPanel emailCommunication = new EmailCommunicationJPanel(userProcessContainer, userAccount, email, req);
            userProcessContainer.add("emailCommunication", emailCommunication);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            //req.setStatus("Order Placed");
        } 
        else if(req.getStatus().equalsIgnoreCase("Rejected")){
            ChangeStatusforSalesPersonRejected(req);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton placeOrderBtn;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
