/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Xuan040900
 */
public class Server2 {
    static final int port = 1234;
    private ServerSocket ss = null;
    
    public Server2(){
        try {
            ss = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Action(){
        Socket sk = null;
        int i=0;
        System.out.println("Server listening ...");
        try {
            while ((sk = ss.accept()) != null) {                
                new ServerThread2(sk, "Client#" +i);
                System.out.printf("Thread for Client#%d generating ... %n", i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Server2().Action();
    }
}
