/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ComputerShop.PTypeModify;
import ComputerShop.RegisterModify;
import Model.PType;
import java.awt.HeadlessException;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xuan040900
 */
public class PTypeGUI extends javax.swing.JFrame {
    DefaultTableModel tbm;
    List<PType> type = new ArrayList<>();

    /**
     * Creates new form PTypeGUI
     */
    public PTypeGUI() {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            initComponents();
            this.setLocationRelativeTo(null);
            tbm = (DefaultTableModel) tbType.getModel();
            showType();
        } catch (RemoteException e) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
    
    public void showType(){
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            PTypeModify c = (PTypeModify)r.lookup("rmiPType");
            type = c.findAll();
            tbm.setRowCount(0);
            
            type.forEach(pType -> {
                tbm.addRow(new Object[] {
                    tbm.getRowCount() + 1, pType.getType_name()
                });
            });
        } catch (NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
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
        tbType = new javax.swing.JTable();
        txtTypeName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TID", "Type_name"
            }
        ));
        jScrollPane1.setViewportView(tbType);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("New type name");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(txtTypeName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            PTypeModify c = (PTypeModify)r.lookup("rmiPType");
            String name = txtTypeName.getText();

            PType pt = new PType(name);
            c.insert(pt);

            showType();
        } catch (NumberFormatException | NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }  
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            PTypeModify c = (PTypeModify)r.lookup("rmiPType");
            int selectedIndex = tbType.getSelectedRow();
            if(selectedIndex >= 0){
                PType cpt = type.get(selectedIndex);
                // show box option
                int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this object ?");
                System.out.println("Option: " + option);
                // 0 yes 1 no 2 cancel
                if(option == 0){
                    c.delete(cpt.getId());
                    showType();
                }else{
                    showType();
                }
            }
        } catch (HeadlessException | NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new PTypeGUI().setVisible(true);
                }
            });
        } catch (RemoteException e) {
            java.util.logging.Logger.getLogger(PTypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbType;
    private javax.swing.JTextField txtTypeName;
    // End of variables declaration//GEN-END:variables
}
