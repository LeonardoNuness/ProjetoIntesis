/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Pessoas;

import Conexao.Conexao;
import Model.Pessoas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class UsuarioDAO {
    
    public boolean login(String login, String pass){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        
        try {
            stmt = conexao.prepareStatement("SELECT login,pass FROM usuarios WHERE login= '" + login + "' and pass= '" + pass + "'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                check = true;              
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return check;
    }
    
}
