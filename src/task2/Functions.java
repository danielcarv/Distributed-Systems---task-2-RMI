package task2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Functions extends Remote{
    
    public String calculateImc(ArrayList data) throws RemoteException;
    
    public String ultimoIMC(ArrayList d) throws RemoteException;
    
}
