/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
/**
 *
 * @author User
 */
public class Exercise {

    public static void main(String[] args) throws Exception {
        URL g = new URL("https://google.com");
        URLConnection gg = g.openConnection();
        
        URL iuh = new URL("http://iuh.edu.vn");
        URLConnection uc = iuh.openConnection();      
        
        BufferedReader i1 = new BufferedReader(new InputStreamReader(uc.getInputStream()));        
        BufferedReader i2 = new BufferedReader(new InputStreamReader(gg.getInputStream()));
        String inputLine;
        
        while ((inputLine = i1.readLine()) != null) {
            System.out.println(inputLine);
        }
        String inputLine1;
        while((inputLine1 = i2.readLine()) != null) {
            System.out.println(inputLine1);
        }    
        i1.close();
        i2.close();
    }
}
