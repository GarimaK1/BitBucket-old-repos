/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseWorkQueues;

import Business.DeviceCategory.Device;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HealthcareProviderWorkRequest;
import Business.WorkQueue.ManufacturerWorkRequest;
import Business.WorkQueue.SalesLevelWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author divinity
 */
public class ManufacturerWorkQueueJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManufacturerWorkQueueJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount account;

    public ManufacturerWorkQueueJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.account = account;
        valueLabel.setText(enterprise.getName());
        populateComboBox();
        populateRequestTable();
        populatecomboboxDevice();
        populatesalesOrgJcomboBox();

    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        System.out.println("device selected start populate");
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
            System.out.println("inside account workques");

            System.out.println("enterprise selected " + request.getEnterprise());
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getEnterprise();;
            row[2] = request.getStatus();
            String result = ((ManufacturerWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            model.addRow(row);
        }
    }

    public void populatesalesOrgJcomboBox() {
        salesDepartmentCombo.removeAllItems();
        if (enterprise.getEnterpriseType().toString().equals("Manufacturer")) {
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (org instanceof SalesOrganization) {
                    salesDepartmentCombo.addItem(org);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateComboBox() {
        jComboHCP.removeAllItems();
        for (Network net : business.getNetworkList()) {
            for (Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter.getEnterpriseType().toString().equals("Healthcare Provider")) {
                    jComboHCP.addItem(enter);
                }
            }
        }
    }

    public void populatecomboboxDevice() {
        comboDevice.removeAllItems();
        for (Device dev : enterprise.getDeviceDirectory().getDeviceList()) {
            comboDevice.addItem(dev);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jComboHCP = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboDevice = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        FwdToSaleBtn = new javax.swing.JButton();
        salesDepartmentCombo = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(234, 225, 226));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setText("Send Request To HCP >");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 242, -1, -1));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Device", "To Healthcare", "Status"
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
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 68, 481, 91));

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 23, 127, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 158, 26));

        jComboHCP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboHCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHCPActionPerformed(evt);
            }
        });
        add(jComboHCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 177, 189, -1));

        jLabel1.setText("Select Healthcare:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 181, -1, -1));

        jLabel2.setText("Select Device: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 213, -1, -1));

        comboDevice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDeviceActionPerformed(evt);
            }
        });
        add(comboDevice, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 209, 187, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        FwdToSaleBtn.setText("forward request to Sales >");
        FwdToSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FwdToSaleBtnActionPerformed(evt);
            }
        });
        add(FwdToSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 260, -1));

        salesDepartmentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        salesDepartmentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesDepartmentComboActionPerformed(evt);
            }
        });
        add(salesDepartmentCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        Enterprise enterp = (Enterprise) jComboHCP.getSelectedItem();
        Device dev = (Device) comboDevice.getSelectedItem();

        ManufacturerWorkRequest requestObjectforManufacturere = new ManufacturerWorkRequest();

        if (enterp == null || dev == null || requestObjectforManufacturere == null) {
            JOptionPane.showMessageDialog(null, "Please select all options!");
        } else {
            requestObjectforManufacturere.setDevice(dev);
            requestObjectforManufacturere.setEnterprise(enterp);
            requestObjectforManufacturere.setSender(account);
            requestObjectforManufacturere.setStatus("Initiated Sale Request");
            business.getAllWorkList().add(requestObjectforManufacturere);

            HealthcareProviderWorkRequest requestObjectforHealthcare = new HealthcareProviderWorkRequest();

            requestObjectforHealthcare.setDevice(dev);
            requestObjectforHealthcare.setEnterprise(enterp);
            requestObjectforHealthcare.setSender(account);
            requestObjectforHealthcare.setParentId(requestObjectforManufacturere.getRequestId());
            System.out.println("sender " + account.getUsername());
            requestObjectforHealthcare.setStatus("Pending Request");
            business.getAllWorkList().add(requestObjectforHealthcare);

            Enterprise enterprise1 = null;
            for (Network net : business.getNetworkList()) {
                for (Enterprise enter : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enter.getName().equals(enterp.getName())) {
                        System.out.println("enterprise matched ");
                        enterprise1 = enter;
                        break;
                    }
                    System.out.println("after first if");
                }
            }
            if (enterprise1 != null) {
                enterprise1.getWorkQueue().getWorkRequestList().add(requestObjectforHealthcare);
                System.out.println("adding to account");
                account.getWorkQueue().getWorkRequestList().add(requestObjectforManufacturere);
                System.out.println("below list added to account");
                System.out.println(account.getWorkQueue().getWorkRequestList());
            }

        }

    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void jComboHCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboHCPActionPerformed

    private void comboDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDeviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDeviceActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void FwdToSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FwdToSaleBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Request !!");
            return;

        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getStatus().equals("Accept")) {

            SalesLevelWorkRequest workRequestObjForSales = new SalesLevelWorkRequest();

            workRequestObjForSales.setDevice(request.getDevice());
            workRequestObjForSales.setEnterprise(request.getEnterprise());
            workRequestObjForSales.setSender(account);
            workRequestObjForSales.setStatus("To Be Processed");
            workRequestObjForSales.setParentId(request.getRequestId());
            workRequestObjForSales.setParentRequestObject(request);
            business.getAllWorkList().add(workRequestObjForSales);
            //JOptionPane.showMessageDialog(null, "sales object created ");
            //JOptionPane.showMessageDialog(null, "started adding to sales work queue");
            Organization salesOrg = (Organization) salesDepartmentCombo.getSelectedItem();
            salesOrg.getWorkQueue().getWorkRequestList().add(workRequestObjForSales);
            //JOptionPane.showMessageDialog(null, "added to sales work queue");
            JOptionPane.showMessageDialog(null, "Request is forwaded to Sales Department");

            request.setChildRequestObject(workRequestObjForSales);

            request.setStatus("Sent to Sales Department");
        } else if (request.getStatus().equalsIgnoreCase("Sent to Sales Department")) {
            JOptionPane.showMessageDialog(null, "Request already forwarded to sales.");
        } else if (salesDepartmentCombo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Create Sales organization first.");
        } else {
            JOptionPane.showMessageDialog(null, "Request is Not Approved !");
        }

    }//GEN-LAST:event_FwdToSaleBtnActionPerformed

    private void salesDepartmentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesDepartmentComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesDepartmentComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FwdToSaleBtn;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox comboDevice;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox jComboHCP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JComboBox salesDepartmentCombo;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
