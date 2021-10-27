/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITInterface;

import ITObject.CourseObj;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CourseITF extends Remote{
    public void Insert(CourseObj c) throws RemoteException;;
    public void Delete(CourseObj c) throws RemoteException;;
    public void Update(CourseObj c) throws RemoteException;;
    public List<CourseObj> display() throws RemoteException;
}
