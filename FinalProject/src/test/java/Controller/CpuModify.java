/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CPU;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public interface CpuModify extends Remote{
    public List<CPU> findAll() throws RemoteException;
    public void insert(CPU Cpu) throws RemoteException;
    public void delete(int id) throws RemoteException;
    public List<CPU> searchByName (String name) throws RemoteException;
}
