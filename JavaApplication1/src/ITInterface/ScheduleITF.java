/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITInterface;

import ITObject.ScheduleObj;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ScheduleITF extends Remote{
    public void Insert(ScheduleObj sch) throws RemoteException;
    public void Delete(ScheduleObj sch) throws RemoteException;
    public void Update(ScheduleObj sch) throws RemoteException;
    public List display() throws RemoteException;
    public List<ScheduleObj> displaySchedule() throws RemoteException;
}
