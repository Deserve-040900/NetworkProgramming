/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITdepartment;

import ITInterface.ClassITF;
import ITObject.ClassObj;
import ITdepartment.Connect;
import static ITdepartment.Section.connection;
import java.awt.HeadlessException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class ViewClass extends javax.swing.JFrame {

    /**
     * Creates new form SetupTeacher
     */
    DefaultTableModel tableModel;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<ClassObj> lst= new ArrayList<>();
    
    public ViewClass() {
        initComponents();
        conn = Connect.connection();
        tableModel = (DefaultTableModel) classTable.getModel();
        display();
    }
    
    public void display(){
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 5000);
            ClassITF clf = (ClassITF) r.lookup("ClassITF");
            lst = clf.display();
            tableModel.setRowCount(0);
            for(ClassObj cl: lst){
                tableModel.addRow(new Object[]{
                    cl.getClass_id(),
                    cl.getCourse_name(),
                    cl.getStudent_quantity(),
                    cl.getTeacher_id()
                });
            }   
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        classidtxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cnametxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantitytxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tidtxt = new javax.swing.JTextField();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("CLASS ID");

        classidtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classidtxtKeyPressed(evt);
            }
        });

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CLASS ID", "COURSE NAME", "STUDENT QUATITY", "TEACHER ID"
            }
        ));
        jScrollPane1.setViewportView(classTable);
        if (classTable.getColumnModel().getColumnCount() > 0) {
            classTable.getColumnModel().getColumn(0).setResizable(false);
            classTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            classTable.getColumnModel().getColumn(2).setResizable(false);
            classTable.getColumnModel().getColumn(2).setPreferredWidth(15);
            classTable.getColumnModel().getColumn(3).setResizable(false);
            classTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        insertBtn.setText("INSERT");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("BACK TO MENU");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("COURSE NAME");

        jLabel5.setText("STUDENT QUANTITY");

        jLabel6.setText("TEACHER ID");

        tidtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tidtxtKeyReleased(evt);
            }
        });

        closeBtn.setText("CLOSE");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cnametxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(insertBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn)
                        .addGap(18, 18, 18)
                        .addComponent(exitBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(closeBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn)
                    .addComponent(exitBtn)
                    .addComponent(closeBtn))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//    public void refresh(){
//        DefaultTableModel tbModel = (DefaultTableModel)setupTable.getModel();
//        int r = tbModel.getRowCount();
//        for(int i=0; i<r; i++){
//            tbModel.removeRow(0);
//        }
//        display();
//    }
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 5000);
            ClassITF clf = (ClassITF) r.lookup("ClassITF");
            
            String classid = classidtxt.getText();
            String course = cnametxt.getText();
            int quantity = Integer.parseInt(quantitytxt.getText());
            String teacher = tidtxt.getText();
            ClassObj cl = new ClassObj(classid, course, quantity, teacher);
            clf.Insert(cl);
          
            display();
            
           
        } catch (HeadlessException throwException) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        } catch (RemoteException | NotBoundException | NullPointerException ex) {
            Logger.getLogger(ViewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 5000);
            ClassITF clf = (ClassITF) r.lookup("ClassITF");
            
            String classid = classidtxt.getText();
            String course = cnametxt.getText();
            String teacher = tidtxt.getText();
            
            ClassObj cl = new ClassObj(classid, course, ABORT, teacher);
            String str = cl.getClass_id();
            clf.Delete(cl);
            display();
            
           
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ViewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 5000);
            ClassITF clf = (ClassITF) r.lookup("ClassITF");
            
            String classid = classidtxt.getText();
            String course = cnametxt.getText();
            int quantity = Integer.parseInt(quantitytxt.getText());
            String teacher = tidtxt.getText();
            ClassObj cl = new ClassObj(classid, course, quantity, teacher);
            clf.Update(cl);
            display();
            
           
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (RemoteException | NotBoundException | NullPointerException ex) {
            Logger.getLogger(ViewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        MainMenu obj = new MainMenu();
        obj.setVisible(true);
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void tidtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tidtxtKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)classTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        classTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(tidtxt.getText().trim()));
    }//GEN-LAST:event_tidtxtKeyReleased

    private void classidtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classidtxtKeyPressed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)classTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        classTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(classidtxt.getText().trim()));
        
        
    }//GEN-LAST:event_classidtxtKeyPressed

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
            java.util.logging.Logger.getLogger(ViewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classTable;
    private javax.swing.JTextField classidtxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextField cnametxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantitytxt;
    private javax.swing.JTextField tidtxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
