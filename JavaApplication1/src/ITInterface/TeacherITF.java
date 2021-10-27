/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITInterface;


import ITObject.TeacherObj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TeacherITF extends Remote{
    public void Insert(TeacherObj t) throws RemoteException;
    public void Delete(TeacherObj t) throws RemoteException;
    public void Update(TeacherObj t) throws RemoteException;
    public List<TeacherObj> display() throws RemoteException;
}
