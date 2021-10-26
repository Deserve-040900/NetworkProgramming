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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run() {
                try {
                    DatagramSocket cSoc = new DatagramSocket(2000);
                    try {
                        byte []buf = new byte[512];
                        buf = "Hello Server".getBytes();
                        InetAddress add = InetAddress.getByName("localhost");
                        DatagramPacket pk = new DatagramPacket(buf, buf.length, add, 1999);
                        cSoc.send(pk);
                        
                        buf = new byte[512];
                        pk = new DatagramPacket(buf, buf.length);
                        cSoc.receive(pk);
                        String rev = new String(pk.getData());
                        System.out.println("Receive " + rev);
                    } catch (Exception e) {
                    }
                    finally{
                        cSoc.close();
                    }
                } catch (Exception e) {
                }
            }
        });
    }    
}
