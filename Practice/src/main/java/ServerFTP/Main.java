/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerFTP;

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
 * @author Xuan040900
 */
public class Main {

    // khai báo các hằng trong giao thức
    public static final int Login = 1;
    public static final int KHONGLALENH = 0;
    public static final int LoginUnsuccessful = 0;
    public static final int LoginSuccessful = 1;
    public static final int Exit = 2;
    public static final int Upload = 3;
    public static final int Download = 4;

    // đổi chuỗi thành hằng để chờ xử lý
    public static int laLenh(String cmd) {
        if (cmd.equals("LOGIN")) {
            return Login;
        }
        if (cmd.equals("UPLOAD")) {
            return Upload;
        }
        if (cmd.equals("DOWNLOAD")) {
            return Download;
        }
        return KHONGLALENH;
    }

    //thiet lap port giao tiep cua ung dung, FTP co port la 20 va 21
    public static final int PORT = 10000;

    public static void main(String[] args) {
        // thay user nay bang cach truy xuat co so du lieu, gia su co user, pass, path da tao ra o buoc 1 chuong trinh quan ly user
        String userA = "Admin";
        String passA = "Admin";
        String path = "C:/";
        ServerSocket server;

        try {
            server = new ServerSocket(PORT);
            while (true) {
                Socket new_s = server.accept();
                //nhan lenh giao tiep tu client
                boolean lap = true;
                while (lap) {
                    String cmd;
                    Scanner sc = new Scanner(System.in);
                    cmd = sc.nextLine();
                    //dieu phoi su kien yeu cau o phai client
                    switch (laLenh(cmd)) {
                        case Login:
                            String user = sc.nextLine();
                            String pass = sc.nextLine();
                            PrintWriter pw;
                            pw = new PrintWriter(new_s.getOutputStream());
                            if (user.equals(userA) && pass.equals(passA)) {
                                pw.println(LoginSuccessful);
                                //mo thu muc len goi ve cho client
                                File dir = new File(path);
                                File dsFile[] = dir.listFiles();
                                if (dsFile == null) {
                                    JOptionPane.showMessageDialog(null, "Sai đường dẫn !");
                                } else {
                                    pw.println(dsFile.length);
                                    for (int i = 0; i < dsFile.length; i++) {
                                        pw.println(dsFile[i].getName());
                                    }
                                }
                            } else {
                                //goi ve khong mo duoc
                                pw.println(LoginUnsuccessful);
                                pw.println("Đăng nhập không thành công !");
                            }
                            pw.flush();
                            break;
                        case Exit:
                            lap = false;
                            break;
                        case Upload:
                            System.out.println("Đã chọn lệnh Upload");
                            String fileName = sc.nextLine();
                            System.out.println("Đã chọn tên tập tin");
                            try {
                                String path2;
                                //kiem tra chuoi duong dan co dau / cuoi cung hay ko? va gan ten tap tin tu client vao tuong ung
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
                                pw.println("Received");
                                pw.flush();
                                //yeu cau update lai listbox o server
                                //mo thu muc ra va tra ve noi dung thu muc o phia server
                                Main.FolderClient(path, pw);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case Download:
                            //lay ten tap tin do client goi len
                            System.out.println("Đã chọn lệnh download");
                            String fileNameD = sc.nextLine();
                            System.out.println("Đã chọn tên tập tin");
                            try {
                                String cpath;
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
                                System.out.println("đã gửi dữ liệu về cho client");
                                bos.flush();
                                //doi nhan danh sach tap thu cua folder o server voi tinh trang moi
                                Scanner scRequest = new Scanner(new_s.getInputStream());
                                String cmdRequest = scRequest.nextLine();
                                System.out.println("Đã nhận trả lời từ server");
                                if (cmdRequest.equals("Receive")) {
                                    System.out.println("Successfully sent");
                                } else {
                                    System.out.println("Unsuccessfully sent");
                                }

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                    }
                }
                new_s.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static void FolderClient(String path, PrintWriter out) {
        try {
            File dir = new File(path);
            File dsFile[];
            System.out.println("Reading file ...");
            try {
                dsFile = dir.listFiles();
                System.out.println("File List");
                out.println(dsFile.length);
                for (int i = 0; i < dsFile.length; i++) {
                    String filename = dsFile[i].getName();
                    out.println(filename);
                }
                out.flush();
                System.out.println("Called client");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
