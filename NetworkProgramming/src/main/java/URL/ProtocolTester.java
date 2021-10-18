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
public class ProtocolTester {
    public static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol()+" is supported");
        } catch (MalformedURLException e) {
            String ptc = url.substring(0,url.indexOf(':'));
            System.out.println(ptc+" is not supported");
        }
    }
}
