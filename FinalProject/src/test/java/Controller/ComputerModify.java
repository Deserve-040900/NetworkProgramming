/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Computer;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Xuan040900
 */
public interface ComputerModify extends Remote{
    public List<Computer> findAll() throws RemoteException;
    public void insert(Computer com) throws RemoteException;
    public void update(Computer com) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<Computer> searchByProducer (String producer) throws RemoteException;
    public List<Computer> searchByID (String id) throws RemoteException;
}
