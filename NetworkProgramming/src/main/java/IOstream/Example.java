/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOstream;

import java.io.*;
/**
 *
 * @author Xuan040900
 */
public class Example {
    public static void main(String[] args)
    {	
    	FileInputStream instream = null;
	FileOutputStream outstream = null;
 
    	try{
    	    File infile =new File("E:\\input.txt");
    	    File outfile =new File("E:\\output.txt");
 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();

    	    System.out.println("File copied successfully!!");
 
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
    }
}
