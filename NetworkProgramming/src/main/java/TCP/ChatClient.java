package TCP;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		try{
			Socket s=new Socket("localhost",9999);
			try {
				
				Scanner in=new Scanner(s.getInputStream());
				PrintWriter out=new PrintWriter(s.getOutputStream(),true);
				System.out.println("Hello");
				Scanner kb=new Scanner(System.in);
				boolean done=false;
				while(!done){
					String rev=in.nextLine();//Nh?n
					System.out.println(rev);
					String line=kb.nextLine();
					out.println(line);
					if(rev.equals("BYE"))
						done=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				s.close();
			}
	}catch(Exception ex){
		
	}
    }
}
