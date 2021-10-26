/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ComputerModify;
import Model.Computer;
import java.awt.HeadlessException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

/**
 *
 * @author Xuan040900
 */
public class ComputerGUI extends javax.swing.JInternalFrame {
    DefaultTableModel tbm; // hien thi du lieu len table
    List<Computer> com = new ArrayList<>(); // luu tru va quan ly du lieu
    
    /**
     * Creates new form Laptop
     */
    public ComputerGUI() {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            initComponents();
            tbm = (DefaultTableModel) tbComputer.getModel();
            showComputer();
        } catch (NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
    
    private void showComputer(){
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            com = c.findAll();
            tbm.setRowCount(0);

    //        for (Computer computer : com) {
    //            tbm.addRow(new Object[] {
    //                tbm.getRowCount() + 1, computer.getProducer(), computer.getType(), computer.getPrice()
    //            });
    //        } ==> convert to below
            com.forEach(computer -> {
                tbm.addRow(new Object[] {
                    tbm.getRowCount() + 1,
                    computer.getProducer(),
                    computer.getType(),
                    computer.getPrice()
                });
            });
        } catch (NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearchProducer = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComputer = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtProducer = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        btnSearchID = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("COMPUTER");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Computer Type");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearchProducer.setText("SearchBy Producer");
        btnSearchProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProducerActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tbComputer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Producer", "Type", "Price"
            }
        ));
        jScrollPane1.setViewportView(tbComputer);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Computer Price");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setText("Computer Producer");

        btnSearchID.setText("SearchBy ID");
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(85, 85, 85)
                                .addComponent(btnDelete)
                                .addGap(83, 83, 83))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProducer, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(txtType))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnReset)
                                .addGap(98, 98, 98)
                                .addComponent(btnExit))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSearchProducer)
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSearchID)
                                        .addGap(47, 47, 47)))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProducer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnSearchProducer))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSearchID)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnExit)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            dispose();
        } catch (NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            txtProducer.setText("");
            txtType.setText("");
            txtPrice.setText("");
        } catch (NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            String producer = txtProducer.getText();
            String type = txtType.getText();
            int price = Integer.parseInt(txtPrice.getText());

            Computer com = new Computer(producer, type, price);
            c.insert(com);

            showComputer();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You must fill all field!");
        } catch (java.rmi.RemoteException | NotBoundException ex) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            // lay vi tri index
            int selectedIndex = tbComputer.getSelectedRow();
            if(selectedIndex >= 0){
                Computer cpt = com.get(selectedIndex);
                // show box option
                int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this object ?");
                System.out.println("Option: " + option);
                // 0 yes 1 no 2 cancel
                if(option == 0){
                    c.delete(Integer.parseInt(cpt.getId()));
                    showComputer();
                }
                else{
                    showComputer();
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You must fill all field!");
        } catch (RemoteException | NotBoundException ex) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProducerActionPerformed
//        TableRowSorter<DefaultTableModel> str = new TableRowSorter<DefaultTableModel>(tbm);
//        tbComputer.setRowSorter(str);
//        str.setRowFilter(RowFilter.regexFilter(txtID.getText().trim()));
//        com = c.searchByID(input);
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            String input = JOptionPane.showInputDialog(this, "Enter producer name to search");
            if(input != null && input.length() > 0){
                com = c.searchByProducer(input);
                tbm.setRowCount(0);

                com.forEach(computer -> {
                    tbm.addRow(new Object[] {
                        tbm.getRowCount() + 1,
                        computer.getProducer(),
                        computer.getType(),
                        computer.getPrice()
                    });
                });
            }else{
                showComputer();
            }
        } catch (HeadlessException | NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }        
    }//GEN-LAST:event_btnSearchProducerActionPerformed

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 2000);
            ComputerModify c = (ComputerModify)r.lookup("ComputerModify");
            String input = JOptionPane.showInputDialog(this, "Enter Computer ID to search");
            if(input != null && input.length() > 0){
                com = c.searchByID(input);
                tbm.setRowCount(0);

                com.forEach(computer -> {
                    tbm.addRow(new Object[] {
                        tbm.getRowCount() + 1,
                        computer.getProducer(),
                        computer.getType(),
                        computer.getPrice()
                    });
                });
            }else{
                showComputer();
            }
        } catch (HeadlessException | NotBoundException | RemoteException e) {
            java.util.logging.Logger.getLogger(ComputerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnSearchIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JButton btnSearchProducer;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbComputer;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProducer;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
