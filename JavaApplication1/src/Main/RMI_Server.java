/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.ComputerCRUB;
import Controller.CpuCRUB;
import Controller.KeyboardCRUB;
import Controller.MouseCRUB;
import Controller.RamCRUB;
import Controller.RegisterCRUB;
import java.rmi.registry.*;
import java.rmi.*;
/**
 *
 * @author Xuan040900
 */
public class RMI_Server {
    public static void main(String[] args) throws RemoteException{
        ComputerCRUB com = new ComputerCRUB();           
        CpuCRUB cpu = new CpuCRUB();
        RamCRUB ram = new RamCRUB();
        MouseCRUB mou = new MouseCRUB();
        KeyboardCRUB key = new KeyboardCRUB();
        RegisterCRUB reg = new RegisterCRUB();
        try {            
            Registry r = LocateRegistry.createRegistry(2000);
            r.bind("rmiComputer", com);
            r.bind("rmiCPU", cpu);
            r.bind("rmiRAM", ram);
            r.bind("rmiMouse", mou);
            r.bind("rmiKeyboard", key);
            r.bind("rmiRegister", reg);
            
            System.out.println("Server starting ...");
        } catch (AlreadyBoundException | RemoteException e) {
        }
    }
}
