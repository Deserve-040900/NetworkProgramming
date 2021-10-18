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
public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("E:\\input.txt");
        FileOutputStream fo = new FileOutputStream("E:\\output.txt");
        BufferedInputStream bi = new BufferedInputStream(fi);
        BufferedOutputStream bo = new BufferedOutputStream(fo);
        try {            
            int ch;
            while ((ch = bi.read()) != -1) {                
                bo.write((char)ch);
            }
            bo.flush();
        } catch (IOException e){
            System.err.println("Error IO file");
        }
        fi.close();
        bi.close();
        fo.close();
        bo.close();
    }
}
