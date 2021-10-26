

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    
	public static void main(String[] args) {
		try {
			System.out.println("Server dang chay");
			ServerSocket svr=new ServerSocket(9999);
			try {
				Socket soc=svr.accept();
				InputStream is=soc.getInputStream();
				OutputStream os=soc.getOutputStream();
				
				Scanner in=new Scanner(is);
				PrintWriter out=new PrintWriter(os,true);
				boolean done=false;
				while(!done){
					String rev=in.nextLine();//Nh?n
					out.println("Echo: "+rev);
					if(rev.equals("BYE"))
						{done=true;
						out.println("BYE");
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				svr.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
