/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import static UDP.Chat3.PORT;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Main3 {
    public static void main(String args[]) {
        
        Chat3 app = new Chat3();
        app.setVisible(true);
        DatagramSocket socket;
        String strContent = "";
        
        try {
            byte []buffer = new byte[1024];
            socket = new DatagramSocket(PORT);
            boolean Finish = false;
            DatagramPacket receivePt;
            String stReceive;
            
            while (Finish != true) {
                receivePt = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePt);
                stReceive = new String(receivePt.getData(), 0, receivePt.getLength());
                strContent = app.getContentChat();
                strContent+= "Localhost: " + stReceive;
                app.setContentChat(strContent);
                if (stReceive.equals("over") || stReceive.equals("stop")) {
                    Finish = true;
                }
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
