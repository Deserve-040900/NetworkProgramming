/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Xuan040900
 */
public class ServerThread1 implements Runnable{
    private Socket sk = null;
    private PrintWriter pw = null;
    private Scanner sc = null;
    private String name;

    public ServerThread1(Socket sk, String name) throws IOException{
        this.name = name;
        this.sk = sk;
        this.pw = new PrintWriter(this.sk.getOutputStream(),true);
        this.sc = new Scanner(this.sk.getInputStream());
        new Thread(this).start();
    }
    
    public void run(){
        try {
            while (true) {                
                String str = sc.nextLine().trim();
                str = str.toUpperCase();
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(name + " has departed");
        } finally{
            try { sk.close(); } catch (Exception e) {}
        }
    }
}
