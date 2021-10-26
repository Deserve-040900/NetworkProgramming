/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Xuan040900
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Server starting ...");
        Thread t = new Thread(new udpRunnable());
        t.start();
    }    
}

class udpRunnable implements Runnable{
    public void run(){
        try {
            DatagramSocket dSoc = new DatagramSocket(1999);
            try {
                byte []buf = new byte[512];
                DatagramPacket pk = new DatagramPacket(buf, buf.length);
                dSoc.receive(pk);// receive from client
                
                String rev = new String(pk.getData());
                System.out.println("Receive : " + rev.trim());
                
                buf = new byte[512];
                buf = "Received: ".getBytes();
                InetAddress add = pk.getAddress();// get IP address from client
                int port = pk.getPort();// get port is send from client
                
                pk = new DatagramPacket(buf, buf.length, add, port);
                dSoc.send(pk);// client to server
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                dSoc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}