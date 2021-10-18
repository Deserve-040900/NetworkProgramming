/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.File;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 *
 * @author Xuan040900
 */
public class Fraction implements Serializable{
    private int tuso;
    private int mauso;

    public Fraction() {
    }

    public Fraction(int tuso, int mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }

    public int getTuso() {
        return tuso;
    }

    public void setTuso(int tuso) {
        this.tuso = tuso;
    }

    public int getMauso() {
        return mauso;
    }

    public void setMauso(int mauso) {
        this.mauso = mauso;
    }
    
    public boolean isPrime(){
        if(mauso <= 1){
            return false;
        }
        for(int i=2; i<Math.sqrt(mauso)+1; i++){
            if(mauso % i == 0){
                return false;
            }
        }return true;
    }

    @Override
    public String toString() {
        return tuso + "/" + mauso; //To change body of generated methods, choose Tools | Templates.
    }
}
    
class WriterReader{
    public static void main(String[] args) {
        Random ran = new Random();
        Fraction f1 = new Fraction(ran.nextInt(10),ran.nextInt(100));
        Fraction f2 = new Fraction(ran.nextInt(10),ran.nextInt(100));
        Fraction f3 = new Fraction(ran.nextInt(10),ran.nextInt(100));
        
        try {
            FileOutputStream fo = new FileOutputStream(new File("E:\\NetworkProgramming\\Practice\\Fraction\\phanso.dat"));
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(f1);
            oo.writeObject(f2);
            oo.writeObject(f3);
            oo.close();
            fo.close();
            
            FileInputStream fi = new FileInputStream(new File("E:\\NetworkProgramming\\Practice\\Fraction\\phanso.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
        } catch (Exception e) {
        }
        
        System.out.println();
    }
}
