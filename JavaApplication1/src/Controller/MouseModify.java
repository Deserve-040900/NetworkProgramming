/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Mouse;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface MouseModify extends Remote{
    public List<Mouse> findAll() throws RemoteException;
    public void insert(Mouse Mou) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<Mouse> searchByName (String name) throws RemoteException;
}
