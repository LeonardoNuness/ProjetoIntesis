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
    
    public boolean login(String user, String pass){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE user=? and pass=?");
            stmt.setString(1,user);
            stmt.setString(2,pass);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;              
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return check;
    }
    
}
