/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Xuan040900
 */
public class ServerThread2 implements Runnable{
    private Socket sk = null;
    private PrintWriter pw = null;
    private Scanner sc = null;
    private String name;

    public ServerThread2(Socket sk, String name) throws IOException{
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
                Scanner in = new Scanner(str);
                in.useDelimiter("@");
                
                int so1 = in.nextInt();
                String pheptinh = in.next();
                int so2 = in.nextInt();
                if(pheptinh.equals("+"))
                    out.println(so1 + so2);
                else if(pheptinh.equals("-"))
                    out.println(so1 - so2);
                else if(pheptinh.equals("*"))
                    out.println(so1 * so2);
                else if(pheptinh.equals("/"))
                    out.println((float)so1 / so2);
                
            }
        } catch (Exception e) {
            System.out.println(name + " has departed");
        } finally{
            try { sk.close(); } catch (Exception e) {}
        }
    }
}
