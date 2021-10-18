/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Xuan040900
 */
public class Ball1 {
    private JPanel box;
    private static final int Xsize=10;
    private static final int Ysize=10;
    private int x=0;
    private int y=0;
    private int dx=2;
    private int dy=2;
    
    public Ball1(JPanel p){
        box = p;
    }
    public void draw(){
        Graphics g = box.getGraphics();
        g.fillOval(x, y, Xsize, Ysize);
        g.dispose();
    }
    public void move(){
        // xóa = cách vẽ đè lên
        Graphics g = box.getGraphics();
        g.setXORMode(Color.CYAN);
        g.fillOval(x, y, Xsize, Ysize);
        x += dx;
        y += dy;
        Dimension d = box.getSize();
        // kiểm tra có đúng các cạnh
        if(x < 0){
            x = 0;
            dx =- dx;
        }else if(x + Xsize >= d.getWidth()){
            x = d.width - Xsize;
            dx =- dx;
        }else if(y < 0){
            y = 0;
            dy =- dy;
        }else if(y + Ysize >= d.getHeight()){
            y = d.height - Ysize;
            dy =- dy;
        }else {
            g.fillOval(x, y, dx, Xsize);
            g.dispose();
        }
    }
    public void bounce(){
        draw();
        for(int i=0; i<1000; i++){
            move();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
