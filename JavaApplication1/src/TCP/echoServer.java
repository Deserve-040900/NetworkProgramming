/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.*;
/**
 *
 * @author Xuan040900
 */
public class echoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataInputStream din = null;
        ServerSocket svk = null;
        DataOutputStream dout = null;
        BufferedReader br = null;
        
        try {
                svk = new ServerSocket(9999);
                System.out.println("Server is running ...");
                Socket sk = svk.accept();
                din = new DataInputStream(sk.getInputStream());
                OutputStream os = sk.getOutputStream();
                dout = new DataOutputStream(os);
                br = new BufferedReader(new InputStreamReader(System.in));
                
                String strServer = "", strClient = "";
                while(!strClient.equals("stop")){
                    strClient = din.readUTF();
                    System.out.println("Client says: " + strServer);                    
                    strServer = br.readLine();
                    dout.writeUTF(strServer);
                    dout.flush();
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
                if (svk != null) {
                    // closes this socket                    */
                    svk.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
