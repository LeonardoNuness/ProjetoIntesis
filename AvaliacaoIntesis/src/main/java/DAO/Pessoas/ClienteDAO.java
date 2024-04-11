/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Pessoas;

import Conexao.Conexao;
import Model.Pessoas.Cliente;
import Model.Produtos.Produto;
import Model.Vendas.Venda;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ClienteDAO {
    
    public void createCliente(Cliente c){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO clientes (nome,cpf,endereco,telefone,email) VALUES (?,?,?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setInt(2,c.getCpf());
            stmt.setString(3,c.getEndereco());
            stmt.setInt(4,c.getTel());
            stmt.setString(5,c.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    public void deleteCliente(Cliente c){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("DELETE FROM clientes WHERE idcliente = ?");
            stmt.setInt(1,c.getId());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deleta o cliente: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    public void updateCliente(Cliente c){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE clientes SET idcliente=?,nome=?,cpf=?,endereco=?,telefone=?,email=? WHERE idcliente=?");
            stmt.setInt(1,c.getId());
            stmt.setString(2,c.getNome());
            stmt.setInt(3,c.getCpf());
            stmt.setString(4,c.getEndereco());
            stmt.setInt(5,c.getTel());
            stmt.setString(6,c.getEmail());
            stmt.setInt(7,c.getId());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualiizar o cliente: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }

    public List<Cliente> readCliente(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM clientes");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("idcliente")); 
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTel(rs.getInt("telefone"));
                c.setEmail(rs.getString("email"));
                
                clientes.add(c);

                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return clientes;
    }
    
    public List<Cliente> readTabelaCliente(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM clientes ORDER BY idcliente ASC");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("idcliente")); 
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("cpf"));
                
                clientes.add(c);

                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os clientes: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return clientes;
    }
    
    public Cliente returnClienteTela(Cliente c){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM clientes WHERE idcliente = ?");
            
            stmt.setInt(1,c.getId());
            
            rs = stmt.executeQuery();

            while(rs.next()){
                cliente.setId(rs.getInt("idcliente")); 
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTel(rs.getInt("telefone"));
                cliente.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao achar o cliente: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return cliente;
    }
    
    public List<String> readTabelaClienteAtVendas(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String clienteName;
        List<String> clientesListName = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM clientes");
            
            rs = stmt.executeQuery();
           
            while(rs.next()){
                
                
                clienteName = rs.getString("nome");
                
                clientesListName.add(clienteName);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os clientes: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return clientesListName;
    }
    
}
