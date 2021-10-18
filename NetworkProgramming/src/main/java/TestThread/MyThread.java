/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestThread;

/**
 *
 * @author Xuan040900
 */
public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("Current: "+ Thread.currentThread().getName());
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Thread 1");
        MyThread m2 = new MyThread("Thread 2");
        m1.start();
        m2.start();
        System.out.println("test");
    }
}
