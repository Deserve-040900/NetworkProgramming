/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL;

import java.net.*;
/**
 *
 * @author Xuan040900
 */
public class Example1 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://hub.docker.com/port:8080");
        System.out.println("The URL is :" + url.toString());
        System.out.println("The shceme: " + url.getProtocol());
  
        // Retrieve the filename of URL
        System.out.println("The user info " + url.getUserInfo());
  
        // Retrieve the hostname of URL
        System.out.println("The host is: " + url.getHost());
  
        // Retrieve the path of URL
        System.out.println("The path is: " + url.getPath());
  
        // Retrieve the port of URL
        System.out.println("port is: " + url.getPort());
        System.out.println("The query string is " + url.getQuery());
        System.out.println("The ref is " + url.getRef());
    }
}
