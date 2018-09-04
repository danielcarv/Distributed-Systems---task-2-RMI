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
        
        String password = (String) data.get(2);
        double imc = Double.parseDouble((String) data.get(0));
        String reply="";
        int test=0;
        double firstImc=0;
        
        ArrayList<User> users = new ArrayList<>();
        UserDAO udao = new UserDAO();
        users = udao.retornaTodos();
        
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getPassword().equals(password)){
                System.out.println(password+" - "+users.get(i).getPassword());
                test=1;
                firstImc = users.get(i).getImc();
            }
        }
        
        if(test == 1){
            
            if(firstImc > imc){
                reply = "O usuário perdeu "+ (firstImc-imc) +" de IMC";
            } else if(firstImc < imc){
                reply = "O usuário ganhou "+ (imc-firstImc) +" de IMC";
            } else{
                reply = "O usuário está com o mesmo IMC";
            }
            
            test=0;
        } else{
            reply = "Primeiro registro!";
        }
        
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
