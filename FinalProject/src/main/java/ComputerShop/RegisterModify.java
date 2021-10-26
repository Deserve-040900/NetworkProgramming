/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.Register;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface RegisterModify extends Remote{
    public void insert(Register Re) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<Register> findAll() throws RemoteException;
    public List<Register> searchUsername (String name) throws RemoteException;
}
