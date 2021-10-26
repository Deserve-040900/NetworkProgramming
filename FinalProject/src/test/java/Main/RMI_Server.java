/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Main.*;
import ComputerShop.PTypeCRUD;
import ComputerShop.ProductCRUD;
import ComputerShop.RegisterCRUD;
import java.rmi.registry.*;
import java.rmi.*;
/**
 *
 * @author Xuan040900
 */
public class RMI_Server {
    public static void main(String[] args) throws RemoteException{
        PTypeCRUD typ = new PTypeCRUD();
        RegisterCRUD reg = new RegisterCRUD();
        ProductCRUD pro = new ProductCRUD();
        
        try {            
            Registry r = LocateRegistry.createRegistry(2000);
            r.bind("rmiPType", typ);
            r.bind("rmiRegister", reg);
            r.bind("rmiProduct", pro);
            
            System.out.println("Server starting ...");
        } catch (AlreadyBoundException | RemoteException e) {
        }
    }
}
