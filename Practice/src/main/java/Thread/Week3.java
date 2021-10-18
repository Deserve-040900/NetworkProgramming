/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template extra, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Quoc
 */
public class Week3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileTWriter ftw1 = new FileTWriter("extra1.txt");
        ftw1.start();
        FileTWriter ftw2 = new FileTWriter("extra2.txt");
        ftw2.start();
        FileTWriter ftw3 = new FileTWriter("extra3.txt");
        ftw3.start();
        
        Ass2 ftd1 = new Ass2("extra1.txt");
        ftd1.start();
        Ass2 ftd2 = new Ass2("extra2.txt");
        ftd2.start();
        Ass2 ftd3 = new Ass2("extra3.txt");
        ftd3.start();
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
class Ass2 extends Thread{
    String name;

    public Ass2() {
    }

    public Ass2(String name) {
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