/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class UserDAO {
    
    ConectaBanco c = new ConectaBanco();
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();

    public void adiciona(User u){
        
        try {
            PreparedStatement pst = cn.prepareStatement("insert into users (imc, ip, password) values (?, ?, ?)");
            pst.setDouble(1, u.getImc());
            pst.setString(2, u.getIp());
            pst.setString(3, u.getPassword());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        }

    }
    
    public ArrayList<User> retornaTodos(){
        ArrayList<User> results = new ArrayList<>();
        
        String cmd = "select * from users";
        Statement stmt;
        ResultSet dados=null;
        c.conexao();
        try {
            stmt = c.conn.prepareStatement(cmd);
            dados = stmt.executeQuery(cmd);
            while(dados.next()){
                int id = dados.getInt(1);
                double imc = dados.getDouble(2);
                String ip = dados.getString(3);
                String password = dados.getString(4);
                
                User u = new User(imc, ip, password);
                
                results.add(u);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        
        return results;
    }        
        
}
