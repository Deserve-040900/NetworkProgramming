/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class ChatServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket sock = new DatagramSocket(2000);
        Scanner a = new Scanner(System.in);

        byte[] inputByte = new byte[5000];
        while (true) {
            DatagramPacket packet = new DatagramPacket(inputByte, inputByte.length);
            sock.receive(packet);
            String inString = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Client: " + inString);

            System.out.println("Server: ");
            String str = a.nextLine();
            if(str.equals("BYE") || inString.equals("BYE")){
                    break;
                }
            DatagramPacket datagram = new DatagramPacket(str.getBytes(), str.length(), packet.getAddress(), packet.getPort());
            sock.send(datagram);

        }
    }
}
