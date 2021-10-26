/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.PType;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface PTypeModify extends Remote{
    public List<PType> findAll() throws RemoteException;
    public void insert(PType pt) throws RemoteException;
    public void delete(int id) throws RemoteException;
}
