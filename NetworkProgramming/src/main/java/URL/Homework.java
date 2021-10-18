/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import javax.swing.text.Document;


/**
 *
 * @author DELL
 */
public class Homework {
    public static void main(String [] args) throws Exception, IOException {
        //CHECK HTTP AND HTTPS
        System.out.println("THIS IS THE FIRST URL WITH HTTPS");
        URL g = new URL("https://www.google.com");
        Exercise urlc1 = g.openConnection();
        BufferedReader in1 = new BufferedReader (new InputStreamReader(urlc1.getInputStream()));
        String Line1;
        while ((Line1 = in1.readLine()) !=null)
            System.out.println(Line1);
        in1.close();
          
        System.out.println("\nTHIS IS THE SECOND URL WITH HTTP");
        URL i = new URL("http://www.iuh.edu.vn");
        Exercise urlc2 = i.openConnection();
        BufferedReader in2 = new BufferedReader (new InputStreamReader(urlc2.getInputStream()));
        String Line2;
        while ((Line2 = in2.readLine()) !=null)
            System.out.println(Line2);
        in2.close();
        
        //GET CONTENT OF URL
        String ct = urlc1.getContentType( ); 
        Object contents = g.getContent(); 
        System.out.println("\nTHE GOOGLE URL");
        System.out.println( contents.getClass().getName());  
        System.out.println(" The content is : "+ct);  
        
        System.out.println("\nTHE IUH URL");
        String ct2 = urlc2.getContentType( );   
        Object contents2 = i.getContent();  
        System.out.println( contents2.getClass().getName());  
        System.out.println(" The content is : "+ ct2);  
        }
   
}
