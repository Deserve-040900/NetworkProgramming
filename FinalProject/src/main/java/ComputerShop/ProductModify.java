/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.Product;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface ProductModify extends Remote{
    public List<Product> findAll() throws RemoteException;
    public void insert(Product pr) throws RemoteException;
    public void update(Product p) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<Product> searchByProducer () throws RemoteException;
    public List<Product> searchByID () throws RemoteException;
}
