/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.RAM;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface RamModify extends Remote{
    public List<RAM> findAll() throws RemoteException;
    public void insert(RAM Ram) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<RAM> searchByName (String name) throws RemoteException;
}
