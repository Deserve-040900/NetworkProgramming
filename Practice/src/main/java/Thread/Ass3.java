/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.io.*;
import java.util.Random;
/**
 *
 * @author Xuan040900
 */
public class Ass3{
    public static void main(String[] args){
        FileTWriter w1 = new FileTWriter("file1.txt");
        w1.start();
        FileTWriter w2 = new FileTWriter("file2.txt");
        w2.start();
        FileTWriter w3 = new FileTWriter("file3.txt");
        w3.start();
        
        FileTReader r1 = new FileTReader("file1.txt");
        r1.start();
        FileTReader r2 = new FileTReader("file2.txt");
        r2.start();
        FileTReader r3 = new FileTReader("file3.txt");
        r3.start();
    }
}

class FileTWriter extends Thread{    
    private int x;
    private String name;
    public FileTWriter (String name){
        this.name = name;
    }

    public FileTWriter() {
    }
    
    public void run(){
        try {
            FileWriter fw = new FileWriter(name);
            BufferedWriter bw = new BufferedWriter(fw);
            Random r = new Random();
            for(int i=0;i<5;i++){
                x=r.nextInt(5);                
                bw.write(x);
            }
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}