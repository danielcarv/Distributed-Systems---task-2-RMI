package task2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Communication extends UnicastRemoteObject implements Functions{

    public Communication() throws RemoteException{
        super();
    }
    
    @Override
    public String calculateImc(ArrayList data) throws RemoteException {
        
        ArrayList<User> users = new ArrayList<>();
        UserDAO udao = new UserDAO();

        String cpf = (String) data.get(0);
        String height = (String) data.get(1);
        String weight = (String) data.get(2);
        String ip = (String) data.get(3);
        double imc = Double.parseDouble(weight) / (Double.parseDouble(height) * Double.parseDouble(height));
        
        User u = new User(imc, ip, cpf);
        
        users = udao.retornaTodos();
        int test=0;
        

        udao.adiciona(u);

        
        users.clear();
        
        return ""+imc;
        
    }

    @Override
    public String ultimoIMC(ArrayList d) {
     
        
        String cpf = (String) d.get(0);
        double imc = Double.parseDouble((String) d.get(4));
        String reply="";
        int test=0;
        double firstImc=0;
        
        ArrayList<User> users = new ArrayList<>();
        UserDAO udao = new UserDAO();
        users = udao.retornaTodos();
        
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getCpf().equals(cpf)){
                System.out.println(cpf+" - "+users.get(i).getCpf());
                test=1;
                firstImc = users.get(i).getImc();
            }
        }
        
        if(test == 1){
            
            if(firstImc > imc){
                reply = "O usuário perdeu "+ (firstImc-imc) +" de IMC";
            } else if(firstImc < imc){
                reply = "O usuário ganhou "+ (imc-firstImc) +" de IMC";
            }
            
            test=0;
        } 
        return reply;
        
    }

}
