package task2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Functions extends Remote{
    
    public String send(ArrayList data) throws RemoteException;
    
}
