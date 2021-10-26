/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Keyboard;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface KeyboardModify extends Remote{
    public List<Keyboard> findAll() throws RemoteException;
    public void insert(Keyboard Key) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<Keyboard> searchByName (String name) throws RemoteException;
}
