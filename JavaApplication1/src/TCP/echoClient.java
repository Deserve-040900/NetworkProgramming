/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Xuan040900
 */
public class echoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket sk = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        BufferedReader br = null;
        try {
                sk = new Socket("localhost",9999);
                din = new DataInputStream(sk.getInputStream());
                OutputStream os = sk.getOutputStream();
                dout = new DataOutputStream(os);
                br = new BufferedReader(new InputStreamReader(System.in));
                
                String strServer = "", strClient = "";
                while(!strServer.equals("stop")){
                    strServer = br.readLine();
                    dout.writeUTF(strServer);
                    dout.flush();
                    strClient = din.readUTF();
                    System.out.println("Server says: " + strClient);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (br != null) {
                    br.close();
                }

                if (din != null) {
                    din.close();
                }

                if (dout != null) {
                    dout.close();
                }
                if (sk != null) {
                    // closes this socket                    */
                    sk.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
