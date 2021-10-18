/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.io.*;

/**
 *
 * @author Xuan040900
 */
public class Ass2{
    public static void main(String[] args){
        FileTReader r1 = new FileTReader("file1.txt");
        r1.start();
        FileTReader r2 = new FileTReader("file2.txt");
        r2.start();
        FileTReader r3 = new FileTReader("file3.txt");
        r3.start();
    }
}
class FileTReader extends Thread{
    String name;

    public FileTReader() {
    }

    public FileTReader(String name) {
        this.name = name;
    }
    
    public synchronized void run(){
        try {
            FileReader fd = new FileReader(name);
            BufferedReader bd = new BufferedReader(fd);
            int ch;
            while((ch = bd.read())!= -1){
                System.out.println(this.name + " "+ch);
            }            
            bd.close();
            fd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}