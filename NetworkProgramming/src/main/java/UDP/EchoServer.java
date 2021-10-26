/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.*;
import java.net.*;

/**
 *
 * @author DELL
 */
public class EchoServer {
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket sock = null;
		
		try
		{
			//1. creating a server socket, parameter is local port number
			sock = new DatagramSocket(5555);
			
			//buffer to receive incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
			
			//2. Wait for an incoming data
			echo("Server socket created. Waiting for incoming data...");
			
			//communication loop
			while(true)
			{
				sock.receive(incoming);
				byte[] data = incoming.getData();
				String s = new String(data, 0, incoming.getLength());
				
				//echo the details of incoming data - client ip : client port - client message
				echo(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " - " + s);
				
				s = "OK : " + s;
				DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
				sock.send(dp);
			}
		}
		
		catch(IOException e)
		{
			System.err.println("IOException " + e);
		}
	}
	
	//simple function to echo data to terminal
	public static void echo(String msg)
	{
		System.out.println(msg);
	}
    
}
