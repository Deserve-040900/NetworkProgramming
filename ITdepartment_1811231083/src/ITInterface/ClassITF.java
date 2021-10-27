/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITInterface;

import ITObject.ClassObj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ClassITF extends Remote{
    public void Insert(ClassObj cl) throws RemoteException;;
    public void Delete(ClassObj cl) throws RemoteException;;
    public void Update(ClassObj cl) throws RemoteException;;
    public List<ClassObj> display() throws RemoteException;
}
