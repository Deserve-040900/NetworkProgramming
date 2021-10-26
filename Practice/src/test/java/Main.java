/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Quoc
 */
public class Main {

    public static final int DANGNHAP = 1;
    public static final int KHONGLALENH = 0;
    public static final int DANGNHAPKHONGTHANHCONG = 0;
    public static final int DANGNHAPTHANHCONG = 1;
    public static final int THOAT = 2;
    public static final int UPLOAD = 3;
    public static final int DOWNLOAD = 4;

    public static int laLenh(String cmd) {
        if (cmd.equals("DANGNHAP")) {
            return DANGNHAP;
        }
        if (cmd.equals("UPLOAD")) {
            return UPLOAD;
        }
        if (cmd.equals("DOWNLOAD")) {
            return DOWNLOAD;
        }
        return KHONGLALENH;
    }
    public static final int PORT = 10000;

    public static void main(String[] args) {
        //gia su co user, pass, path
//sinh vien thay 1 user nay bang cach truy xuat co so du lieu
// cac user da tao ra o buoc 1 do chuong trinh quan ly user
        String userA = "admin";
        String passA = "admin";
        String path = "C:/";
        ServerSocket s;
        try {
            s = new ServerSocket(PORT);
            while (true) {
                Socket new_s = s.accept();
                //nhan lenh giao tiep tu client
                boolean lap = true;
                while (lap) {
                    String cmd;
                    Scanner sc = new Scanner(System.in);
                    cmd = sc.nextLine();
                    //dieu phoi su kien yeu cau o phai client
                    switch (laLenh(cmd)) {
                        case DANGNHAP:
                            String user = sc.nextLine();
                            String pass = sc.nextLine();
                            PrintWriter pw;
                            pw = new PrintWriter(new_s.getOutputStream());
                            if (user.equals(userA) && pass.equals(passA)) {
                                pw.println(DANGNHAPTHANHCONG);
                                //mo thu muc len goi ve cho client
                                File dir = new File(path);
                                File dsFile[] = dir.listFiles();
                                if (dsFile == null) {
                                    JOptionPane.showMessageDialog(null, "sai duong dan");
                                } else {
                                    pw.println(dsFile.length);
                                    for (int i = 0; i < dsFile.length; i++) {
                                        pw.println(dsFile[i].getName());
                                    }
                                }
                            } else {
                                //goi ve khong mo duoc
                                pw.println(DANGNHAPKHONGTHANHCONG);
                                pw.println("Dang nhap ko thanh cong");
                            }
                            pw.flush();
                            break;
                        case THOAT:
                            lap = false;
                            break;
                        case UPLOAD:
                            System.out.println("Da vao lenh upload");
                            String fileName = sc.nextLine();
                            System.out.println("Da lay ten tap tin");
                            try {
                                String path2;
                                //kiem tra chuoi duong dan co dau / cuoi cung hay ko?
                                //va gan ten tap tin tu client vao tuong ung
                                if (path.lastIndexOf("/") >= path.length() - 1) {
                                    path2 = path + fileName;
                                } else {
                                    path2 = path + "/" + fileName;
                                }
                                System.out.println(path2);
                                FileOutputStream fos = new FileOutputStream(new File(path2));
                                BufferedOutputStream bos = new BufferedOutputStream(fos);
                                BufferedInputStream bis;
                                bis = new BufferedInputStream(new_s.getInputStream());
                                byte buf[] = new byte[bis.available()];
                                bos.write(bis.read(buf));
                                bos.flush();
                                bos.close();
                                pw = new PrintWriter(new_s.getOutputStream());
                                pw.println("DANHAN");
                                pw.flush();
                                //yeu cau update lai listbox o server
                                //mo thu muc ra va tra ve noi dung thu muc o phia server
                                Main.traThuMucClient(path, pw);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case DOWNLOAD:
                            //lay ten tap tin do client goi len
                            System.out.println("Da vao lenh download");
                            String fileNameD = sc.nextLine();
                            System.out.println("Da lay ten tap tin");
                            try {
                                String cpath;
                                //kiem tra chuoi duong dan co dau / cuoi cung hay ko?
                                //va gan ten tap tin tu client vao tuong ung
                                if (path.lastIndexOf("/") >= path.length() - 1) {
                                    cpath = path + fileNameD;
                                } else {
                                    cpath = path + "/" + fileNameD;
                                }
                                System.out.println(cpath);
                                //mo tap tin ra
                                BufferedInputStream bis;
                                bis = new BufferedInputStream(new FileInputStream(cpath));
                                //lap doc noi dung tap tin va goi lieu len server
                                byte buf[] = new byte[bis.available()];
                                //tao bo dem doc het du lieu tu tap tin vao bo dem roi day
                                //vao luong len server.
                                BufferedOutputStream bos;
                                bos = new BufferedOutputStream(new_s.getOutputStream());
                                bos.write(bis.read(buf));
                                System.out.println("da goi du lieu tap tin ve cho client");
                                bos.flush();
                                //doi nhan danh sach tap thu cua folder o server voi tinh trang moi
                                Scanner scRequest = new Scanner(new_s.getInputStream());
                                String cmdRequest = scRequest.nextLine();
                                System.out.println("da nhan dap tra tu server");
                                if (cmdRequest.equals("DANHAN")) {
                                    System.out.println("Da gui thanh cong");
                                } else {
                                    System.out.println("da gui that bai");
                                }

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                    }
                }
                new_s.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static void traThuMucClient(String path, PrintWriter out) {
        try {
            File dir = new File(path);
            File dsFile[];
            System.out.println("Dang doc tap tin");
            try {
                dsFile = dir.listFiles();
                System.out.println("da la ds tap tin");
                out.println(dsFile.length);
                for (int i = 0; i < dsFile.length; i++) {
                    String filename = dsFile[i].getName();
                    out.println(filename);
                }
                out.flush();
                System.out.println("da goi client");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
