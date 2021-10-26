/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import com.mysql.cj.xdevapi.Client;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ThreadChat3 implements Runnable{
    private Socket sk = null;
    private Scanner sc = null;
    ServerSocket server = null;
    public ClientAsg3 chat = null;

    public ThreadChat3(){
        try {
            server = new ServerSocket(1234);// tạo mới server socket nhận 1234 làm tham số
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }
    
    public void run(){
        try {
            while (true) {                
                while ((sk = server.accept()) != null) {// nhận kết nối từ máy khác đến              
                    this.sc = new Scanner(this.sk.getInputStream());
                    String chuoi = sc.nextLine().trim();// nhận chuỗi
                    chat.show(chuoi + "\n");// hiển thị chuỗi
                }                
            }
        } catch (Exception e) {
            
        } finally{
            try { sk.close(); } catch (Exception e) {}
        }
    }
}
