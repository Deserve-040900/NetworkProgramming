/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Xuan040900
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginDialog login = new LoginDialog(null, true);
        login.setTitle("Đăng nhập hệ thống");
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }    
}
