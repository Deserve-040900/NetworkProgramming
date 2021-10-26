/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class ChatClient {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DatagramSocket sock = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner s = new Scanner(System.in);
            while(true){
                System.out.println("Client: ");
                String str = s.nextLine();                
                
                DatagramPacket datagramPacket =  new DatagramPacket(str.getBytes(), str.length(), add, 2000);
                sock.send(datagramPacket);
                
                byte []inputByte = new byte[5000];
                DatagramPacket inputPacket = new DatagramPacket(inputByte, inputByte.length);
                sock.receive(inputPacket);
                
                String inString = new String(inputPacket.getData(), 0, inputPacket.getLength());
                System.out.println("Server: "+inString);
                if(str.equals("BYE")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
