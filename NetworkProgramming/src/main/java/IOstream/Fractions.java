/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOstream;

import java.io.*;
import java.util.Random;
/**
 *
 * @author Quoc
 */
public class Fractions implements Serializable{
    private static final long serialVersionUID = 1L;
    private int tuso;
    private int mauso;

    public Fractions() {
    }

    public Fractions(int tuso, int mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }

    public void setDen(int mauso) {
        this.mauso = mauso;
    }

    public void setNum(int tuso) {
        this.tuso = tuso;
    }

    public int getNum() {
        return tuso;
    }

    public int getDen() {
        return mauso;
    }
    public boolean isPrime( ){
        if (mauso <= 1) {  
           return false;  
       }  
       for (int i = 2; i < Math.sqrt(mauso)+1; i++) {  
           if (mauso % i == 0) {  
               return false;  
           }  
       }  
       return true;       
                    
    }
	@Override
	public String toString() {
            return tuso + "/"+ mauso ;
	}
}
class WriterReader {
        
	public static void main(String[] args) {
                Random rd = new Random();
		Fractions f1 = new Fractions(rd.nextInt(10),rd.nextInt(100));
		Fractions f2 = new Fractions(rd.nextInt(10),rd.nextInt(100));
                Fractions f3 = new Fractions(rd.nextInt(10),rd.nextInt(100));
		try {
			FileOutputStream f = new FileOutputStream(new File("E:\\daihoc\\Computer networks\\Network Programming\\practice\\phanso.dat"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(f1);
			o.writeObject(f2);
                        o.writeObject(f3);
			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("E:\\daihoc\\Computer networks\\Network Programming\\practice\\phanso.dat"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			Fractions pr1 = (Fractions) oi.readObject();
			Fractions pr2 = (Fractions) oi.readObject();
                        Fractions pr3 = (Fractions) oi.readObject();
                        System.out.println("Display fractions object: ");
			System.out.println(pr1.toString());
			System.out.println(pr2.toString());
                        System.out.println(pr3.toString());
                        
                        System.out.println("Display fractions object with prime denominator:");
                        if(pr1.isPrime()){                           
                            System.out.println(pr1.toString());
                        }if(pr2.isPrime()){
                           
                            System.out.println(pr2.toString());
                        }if(pr3.isPrime()){
                          System.out.println(pr3.toString());
                        }
                      
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
