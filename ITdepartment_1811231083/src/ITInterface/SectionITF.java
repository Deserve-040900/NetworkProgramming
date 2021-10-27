/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITInterface;

import ITObject.SectionObj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SectionITF extends Remote{
    public void Insert(SectionObj s)throws RemoteException;
    public void Delete(SectionObj s)throws RemoteException;
    public void Update(SectionObj s)throws RemoteException;
    public List<SectionObj> display() throws RemoteException;
}
