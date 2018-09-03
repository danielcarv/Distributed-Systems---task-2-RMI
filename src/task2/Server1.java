/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Server1 extends UnicastRemoteObject implements Functions {

    public Server1() throws RemoteException{
        super();
    }
    
    @Override
    public String send(ArrayList data) throws RemoteException {
        
        String ip = (String) data.get(1);
        Server s = new Server();
        s.setIp(ip);
        
        String reply="Testando";
        
        reply = (String) data.get(1);
        
        return reply;

    }
    
    public void iniciar() throws NotBoundException{
        
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("h1_server", new Server1());
            System.out.println("Server is running...");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex.getMessage());
        }
        
    }
    
}
