/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThread;

import java.util.Random;
import java.math.*;
/**
 *
 * @author Xuan040900
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ThreadA a1 = new ThreadA("Thread 1");
        ThreadA a2 = new ThreadA("Thread 2");
        ThreadA a3 = new ThreadA("Thread 3");
        a1.start();        
        a2.start();        
        a3.start();
    }
}
class ThreadA extends Thread {
    public ThreadA(String name){
        super(name);
    }
    public void run() {
        if(Thread.currentThread().getName() == "Thread 1"){
            for(int i=0; i<=5; i++){
                Random r = new Random();
                int a = r.nextInt(100);
                System.out.println("Random number: " + a);
            }
        }
        else{
            if(Thread.currentThread().getName() == "Thread 2"){
                Random r = new Random();
                int ch = r.nextInt((90 - 65) + 1) + 65;
    //            String a = "qwertyuiopasdfghjklzxcvbnm!@#$%^&*()";
    //            char b = a.charAt(n);
                System.out.println("Random character: " + (char)ch);
            }else{
                if(Thread.currentThread().getName() == "Thread 3"){
                    Random r = new Random();
                    int n = r.nextInt(50);
        //            String a = "abcdefghxyz-/0";
        //            char c = a.charAt(n);
                    int ch = r.nextInt((90 - 65) + 1) + 65;
                    System.out.println("Random number & character: " + n + (char)ch);
                }
            }
        }
    }
}
