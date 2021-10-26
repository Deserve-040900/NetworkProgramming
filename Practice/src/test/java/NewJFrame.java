/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Quoc
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    public NewJFrame() {
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

        fchPath = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        tfDomain = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientPath = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPath = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("domain");

        tfDomain.setText("localhost");

        jButton1.setText("up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("download");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("user");

        jLabel3.setText("pass");

        jButton3.setText("login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("browser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("client's folder");

        jLabel5.setText("server's folder");

        jScrollPane1.setViewportView(lstClientPath);

        jScrollPane2.setViewportView(lstPath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfPass))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfUser)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String fileName = (String) this.lstPath.getSelectedValue();
        System.out.println(fileName);
        try {
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            //goi tin hieu lenh
            pw.println("DOWNLOAD");
            pw.flush();
            System.out.println("Da goi lenh download len server");
            pw.println(fileName);
            pw.flush();
            //doi server goi noi dung tap tin ve
            System.out.println("Doi server goi noi dung tap tin ve");
            String cpath = path + "\\" + fileName;
            FileOutputStream fos;
            fos = new FileOutputStream(new File(cpath));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
            byte buf[] = new byte[bis.available()];
            bos.write(bis.read(buf));
            bos.flush();
            bos.close();
            pw = new PrintWriter(s.getOutputStream());
            pw.println("DANHAN");
            pw.flush();
            //cap nhat lai thu muc client vua download
            this.capNhatClientFolder(cpath);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void capNhatClientFolder(String cpath) {
        //mo thu muc voi duong dan path ra
        File dir = new File(path);
        File dsFile[] = dir.listFiles();
        if (dsFile == null) {
            JOptionPane.showMessageDialog(null, " Duong dan sai!");
        } else {
            try {
                //luu duong dan hien tai ma list hien thi danh tap tin trong folder do.
//path=txtPath.getText();
                DefaultListModel dm = new DefaultListModel();
                for (int i = 0; i < dsFile.length; i++) {
                    String filename = dsFile[i].getName();
                    dm.addElement(filename);
                }
                this.lstClientPath.setModel(dm);
                this.validate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    Socket s;
    public static final int PORT = 10000;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String domain = this.tfDomain.getText();
        try {
            InetAddress ia = InetAddress.getByName(domain);
            try {
                s = new Socket(ia, PORT);
                //goi user, pass len server
                PrintWriter pw = null;
                //lay du lieu tu form do su dung go vao
                
                String user = this.tfUser.getText();
                String pass = this.tfPass.getText();
                String cmd = "DANGNHAP";
                pw.println(cmd);
                pw.println(user);
                pw.println(pass);                
                System.out.println(cmd);
                System.out.println(user);
                System.out.println(pass);
                pw.flush();
                Scanner sc = new Scanner(s.getInputStream());
                int cmdR = sc.nextInt();
                if (cmdR == 1) {
                    JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                    //luu duong dan hien tai ma list hien thi danh tap tin trong folder do.
                    DefaultListModel dm = new DefaultListModel();
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        dm.addElement(sc.nextLine());
                    }
                    this.lstPath.setModel(dm);
                } else {
                    JOptionPane.showMessageDialog(this, "Dang nhap khong thanh cong");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    String path;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        fchPath.setVisible(true);
        //thiet lap
        fchPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //kiem tra form nay duoc chon nut gi?
        if (fchPath.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                path = fchPath.getSelectedFile().getCanonicalPath();
                File dir = new File(path);
                File dsFile[] = dir.listFiles();
                if (dsFile == null) {
                    JOptionPane.showMessageDialog(null, "sai duong dan!");
                } else {
                    try {
                        //luu duong dan hien tai ma list hien thi danh tap
                        // tin trong folder do.
                        DefaultListModel dm = new DefaultListModel();
                        for (int i = 0; i < dsFile.length; i++) {
                            String filename = dsFile[i].getName();
                            dm.addElement(filename);
                        }
                        this.lstClientPath.setModel(dm);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed
    public void updateFolderServer() {
        try {
            BufferedInputStream bi = null;
            Scanner sc = new Scanner(bi);
            DefaultListModel dm = new DefaultListModel();
            //server goi ve so luong tap tin thu muc sau khi upload
            int n = sc.nextInt();
            System.out.println("Da nhan duoc so luong tap tin goi tu server");
            //nhan ten tung tap tin thu muc
            for (int i = 0; i < n; i++) {
                String filename = sc.nextLine();
                dm.addElement(filename);
            }
            System.out.println("Da hien thi xong danh sach tap tin");
            //hien thi len form
            this.lstPath.setModel(dm);
            //ve lai giao dien
            this.validate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String fileName = (String) this.lstClientPath.getSelectedValue();
        String cpath = path + "\\" + fileName;
        System.out.println(cpath);
        try {
            PrintWriter pw = null;
            //goi tin hieu lenh
            pw.println("UPLOAD");
            pw.flush();
            System.out.println("Da goi lenh upload len server");
            pw.println(fileName);
            pw.flush();
            System.out.println("Da goi ten tap tin len server");
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
            DataOutputStream dos = new DataOutputStream(bos);
            //mo tap tin ra
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cpath));
            //lap doc noi dung tap tin va goi lieu len server
            byte buf[] = new byte[bis.available()];
            //tao bo dem doc het du lieu tu tap tin vao bo dem roi day
            //vao luong len server.
            bos.write(bis.read(buf));
            System.out.println("da goi du lieu tap tin len server");
            bos.flush();
            //bis.close();
            //doi nhan danh sach tap thu cua folder o server voi tinh trang moi
            Scanner sc = new Scanner(s.getInputStream());
            String cmd = sc.nextLine();
            System.out.println("da nhan dap tra tu server");
            if (cmd.equals("DANHAN")) {
                JOptionPane.showMessageDialog(null, "Sent successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
            //nhan update
            updateFolderServer();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fchPath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstClientPath;
    private javax.swing.JList<String> lstPath;
    private javax.swing.JTextField tfDomain;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
