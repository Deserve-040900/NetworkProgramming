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
public class BS {
    public static void main(String[] args) throws IOException {
        Student A = new Student(111,"Nguyen An","CS0001","123 Truong Dinh");
        Student B = new Student(112,"Nguyen Binh","SC0002","321 Hoang Van Thu");
        try {
            FileOutputStream fo = new FileOutputStream(new File("student.txt"));
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(A);
            o.writeObject(B);
            o.close();
            fo.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e){
            System.err.println("Error initializing stream");
        }
    }
}
