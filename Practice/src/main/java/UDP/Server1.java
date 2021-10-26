/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Xuan040900
 */
public class Server1 {
    static final int port = 1234;
    private DatagramSocket socket = null;

    public Server1() {
        try {
            socket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action(){
        InetAddress host = null;
        int port;
        String str = "";
        try {
            System.out.println("Server is listening ...");
            while (true) {                
                DatagramPacket packet = receive();
                host = packet.getAddress();
                port = packet.getPort();
                str = new String(packet.getData()).trim();
                str = str.toUpperCase();
                if(!str.equals(""))
                    send(str, host, port);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            socket.close();
        }
    }
    
    private void send(String str, InetAddress host, int port) throws IOException{
        byte[] buffer = str.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, host, port);
        socket.send(packet);
    }
    private DatagramPacket receive() throws IOException{
        byte[] buffer = new byte[65507];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }
    
    public static void main(String[] args) {
        new Server1().action();
    }
}
