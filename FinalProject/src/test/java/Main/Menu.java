/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.*;
import View.ProductGUI;
import View.UserGUI;
import View.LoginGUI;
import View.RegisterGUI;
import View.ViewAllGUI;
/**
 *
 * @author Xuan040900
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Register = new javax.swing.JMenuItem();
        Login = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        ViewAll = new javax.swing.JMenu();
        Computer = new javax.swing.JMenuItem();
        CPU = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computer Shop Management");

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        jMenu1.add(Register);

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jMenu1.add(Login);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        ViewAll.setText("Management system");
        ViewAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllActionPerformed(evt);
            }
        });

        Computer.setText("Product");
        Computer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComputerActionPerformed(evt);
            }
        });
        ViewAll.add(Computer);

        CPU.setText("User");
        CPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUActionPerformed(evt);
            }
        });
        ViewAll.add(CPU);

        jMenuItem1.setText("View All");
        ViewAll.add(jMenuItem1);

        jMenuBar1.add(ViewAll);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void ComputerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComputerActionPerformed
        // TODO add your handling code here:
        ProductGUI obj = new ProductGUI();
        obj.setVisible(true);
    }//GEN-LAST:event_ComputerActionPerformed

    private void CPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUActionPerformed
        // TODO add your handling code here:
        UserGUI obj = new UserGUI();
        obj.setVisible(true);
    }//GEN-LAST:event_CPUActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
        RegisterGUI obj = new RegisterGUI();
        obj.setVisible(true);
    }//GEN-LAST:event_RegisterActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        LoginGUI obj = new LoginGUI();
        obj.setVisible(true);
    }//GEN-LAST:event_LoginActionPerformed

    private void ViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAllActionPerformed
        // TODO add your handling code here:
        ViewAllGUI obj = new ViewAllGUI();
        this.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_ViewAllActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CPU;
    private javax.swing.JMenuItem Computer;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenu ViewAll;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}