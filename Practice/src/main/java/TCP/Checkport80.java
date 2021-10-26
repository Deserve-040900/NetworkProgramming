/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Xuan040900
 */
public class Checkport80 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("Client socket Address: " + server.getLocalSocketAddress() + "...");
            System.out.println("Connecting to " + "Xuan040900" + " on port " + 80);
            Socket sk = new Socket("Xuan040900", 80);
            System.out.println("Socket Address: " + sk.getRemoteSocketAddress());
            sk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
