/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DeviceLabOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author divinity
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private DoctorOrganization doctorOrganization;
    private DeviceLabOrganization deviceOrganization;

    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.doctorOrganization = (DoctorOrganization) organization;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        populateTable();
        System.out.println("under doctor work area ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 225, 226));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 86, 550, 140));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 129, -1));

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });
        add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 129, -1));

        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });
        add(btnReject, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 129, -1));

        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Doctor WorkArea");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == null) {
            request.setReceiver(userAccount);
            request.setStatus("Pending for Approval");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request Already in Process. !!");
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }

        WorkRequest requestObjectForDoctor = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Pending for Approval")) {
            requestObjectForDoctor.setStatus("Approved");
            populateTable();
            System.out.println("inside approval " + requestObjectForDoctor.getRequestId());
            ChangeStatusforDeviceLab(requestObjectForDoctor);
        }  else if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Approved")) {
            JOptionPane.showMessageDialog(null, "Request already approved.");
        } else if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Rejected")) {
            JOptionPane.showMessageDialog(null, "Request already rejected.");
        } else {
            JOptionPane.showMessageDialog(null, "Please assign the Request first !!");
        }
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;
        }

        WorkRequest requestObjectForDoctor = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Pending for Approval")) {
            requestObjectForDoctor.setStatus("Rejected");
            ChangeStatusforDeviceLab(requestObjectForDoctor);
            populateTable();
        } else if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Approved")) {
            JOptionPane.showMessageDialog(null, "Request already approved.");
        } else if (requestObjectForDoctor.getStatus().equalsIgnoreCase("Rejected")) {
            JOptionPane.showMessageDialog(null, "Request already rejected.");
        } else {
            JOptionPane.showMessageDialog(null, "Please assign the Request first !!");
        }
    }//GEN-LAST:event_btnRejectActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : doctorOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();

            model.addRow(row);
        }
    }

    public void ChangeStatusforDeviceLab(WorkRequest req) {
        WorkRequest parentReq = req.getParentRequestObject();
        parentReq.setStatus(req.getStatus());
        ChangeStatusforAuthorization(parentReq);

    }

    public void ChangeStatusforAuthorization(WorkRequest req) {
        WorkRequest parentReq = req.getParentRequestObject();
        parentReq.setStatus(req.getStatus());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
