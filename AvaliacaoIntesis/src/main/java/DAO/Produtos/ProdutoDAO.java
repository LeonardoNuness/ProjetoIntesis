/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Produtos;

import Conexao.Conexao;
import Model.Produtos.Produto;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ProdutoDAO {
    
    public void createProduto(Produto p){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO produtos (nome,descricao,categoria,preco) VALUES (?,?,?,?)");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getDescricao());
            stmt.setString(3,p.getCategoria());
            stmt.setDouble(4,p.getPreco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    public void deleteProduto(Produto p){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("DELETE FROM produtos WHERE idproduto = ?");
            stmt.setInt(1,p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deleta o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    public void updateProduto(Produto p){
        
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE produtos SET idproduto=?, nome=?, descricao=?, categoria=?, preco=? "
                                            + "WHERE idproduto=?");
            
            stmt.setInt(1,p.getId());
            stmt.setString(2,p.getNome());
            stmt.setString(3,p.getDescricao());
            stmt.setString(4,p.getCategoria());
            stmt.setDouble(5,p.getPreco());
            stmt.setInt(6,p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualiizar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    public List<Produto> readProduto(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("idproduto")); 
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getString("categora"));
                p.setPreco(rs.getDouble("preco"));
                
                produtos.add(p);

                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return produtos;
    }
    
    public List<Produto> readTabelaProduto(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM produtos ORDER BY idproduto ASC");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("idproduto")); 
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                
                produtos.add(p);

                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return produtos;
    }
    
    public Produto returnProdutoTela(Produto p){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = new Produto();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE idproduto = ?");
            
            stmt.setInt(1,p.getId());
            
            rs = stmt.executeQuery();

            while(rs.next()){
                produto.setId(rs.getInt("idproduto")); 
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao achar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return produto;
    }
    
    public List<Produto> readTabelaProdutoAtVendas(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto p = new Produto();
                
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                
                produtos.add(p);

            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return produtos;
    }
    
    
}
