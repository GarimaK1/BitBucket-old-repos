/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private Enterprise enterprise;
    private JPanel userProcessContainer;

    /**
     * Creates new form ManageOrganizationJPanel
     *
     * @param userProcessContainer
     * @param enterprise
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;

        populateTable();
        populateCombo();
    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        if (enterprise.getEnterpriseType().toString().equals("Manufacturer")) {
            System.out.println("identified manufacturere");
            for (Type type : Organization.Type.values()) {
                if (type.getValue().equals(Type.Sales.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }

        } else if (enterprise.getEnterpriseType().toString().equals("Healthcare Provider")) {
            System.out.println("identified healthcare");
            for (Type type : Organization.Type.values()) {
                if (type.getValue().equals(Type.Sales.getValue()) || type.getValue().equals(Type.Admin.getValue())) {
                    System.out.println("removed values");
                } else {
                    organizationJComboBox.addItem(type);

                }
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(201, 218, 229));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        organizationJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 67, 480, 92));

        addJButton.setText("Create Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 222, -1, -1));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 177, 169, -1));

        jLabel1.setText("Organization Type:  ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 177, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 287, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Manage Organization");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Type type = (Type) organizationJComboBox.getSelectedItem();
        System.out.println(type);

        if (type.equals(Type.Sales)) {
            if (enterprise.getOrganizationDirectory().getOrganizationList().isEmpty()) {
                System.out.println("No org exists yet.");
                enterprise.getOrganizationDirectory().createOrganization(type);
                populateTable();
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Sales Organization already exists");
            }
        }

        boolean flag = true;

        if (type.equals(Type.Authorization) || type.equals(Type.DeviceLab) || type.equals(Type.Doctor)) {

            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                //System.out.println(org.getName());
                if (type.getValue().equals(org.getName())) {
                    JOptionPane.showMessageDialog(null, type.getValue() + " already exists");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                enterprise.getOrganizationDirectory().createOrganization(type);
                populateTable();
            }

        }

    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
