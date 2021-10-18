/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Xuan040900
 */
public class Ass1{
    public static void main(String[] args){
        FileTWriter w1 = new FileTWriter("file1.txt");
        w1.start();
        FileTWriter w2 = new FileTWriter("file2.txt");
        w2.start();
        FileTWriter w3 = new FileTWriter("file3.txt");
        w3.start();
    }
}
public class extra1 extends Thread {
    private int x;
    private String name;
    public extra1(String name){
        this.name = name;
    }

    public extra1() {
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
