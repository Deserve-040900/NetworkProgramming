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
public class Homework {
    public static void main(String[] args){
        ThreadDemo demo = new ThreadDemo();
        
        ThreadGroup tg1 = new ThreadGroup("Thread group 1");
        Thread thread1 = new Thread(tg1, demo, "This is thread 1");
        Thread thread2 = new Thread(tg1, demo, "This is thread 2");
        
        thread1.setPriority(10);
        thread1.start();
        
        thread1.setPriority(4);
        thread2.start();
        
        System.out.println("=========Numeber of active threads in group 1: " +tg1.activeCount());
        
        ThreadGroup tg2 = new ThreadGroup("Thread group 2");
        Thread thread3 = new Thread(tg2, demo, "This is thread 3");
        Thread thread4 = new Thread(tg2, demo, "This is thread 4");
        Thread thread5 = new Thread(tg2, demo, "This is thread 5");
        
        thread3.setPriority(6);
        thread3.start();
        
        thread4.setPriority(5);
        thread4.start();
        
        thread5.setPriority(1);
        thread5.start();
        
        System.out.println("=========Numeber of active threads in group 1: " +tg2.activeCount());
    }
}
class ThreadDemo implements Runnable{
        public void run(){
            System.out.println("" + Thread.currentThread().getName()+ ", Priority: " +Thread.currentThread().getPriority());
        }
    }
