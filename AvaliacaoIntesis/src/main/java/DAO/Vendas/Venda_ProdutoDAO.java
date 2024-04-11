/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Vendas;

import Conexao.Conexao;
import Model.Produtos.Produto;
import Model.Produtos.Venda_Produtos;
import Model.Vendas.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Venda_ProdutoDAO {
    
    public void createVendaProdutos(Venda_Produtos vp){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            
            stmt = conexao.prepareStatement("INSERT INTO vendas_produtos (idvendaproduto,produto,preco,quantidade) VALUES (?,?,?,?)");
            stmt.setInt(1,vp.getIdvenda());
            stmt.setString(2,vp.getNome());
            stmt.setDouble(3,vp.getPreco());
            stmt.setInt(4,vp.getQuantidade());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }
    
    public void deleteProdutos(int idVenda){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("DELETE FROM vendas_produtos WHERE idvendaproduto = ?");
            stmt.setInt(1,idVenda);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }
    
    
    public void updateProdutos(){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("UPDATE TABLE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }
    
    
    public List<Venda_Produtos> readProdutos(int idVenda){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Venda_Produtos> listProdutos = new ArrayList<>();
        Venda_Produtos vp = new Venda_Produtos();
        
        try{
            stmt = conexao.prepareStatement("SELECT * FROM vendas_produtos where idvendaproduto = ?");
            stmt.setInt(1,idVenda);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                vp.setIdvenda(idVenda);
                vp.setNome(rs.getString("produto"));
                vp.setPreco(rs.getDouble("preco"));
                vp.setQuantidade(rs.getInt("quantidade"));
                listProdutos.add(vp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
        return listProdutos;
    }
     
     
    public int ultimaVenda() {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int ultimaVenda = 0;
        
        try {
            stmt = conexao.prepareStatement("SELECT idvenda FROM vendas ORDER BY idvenda DESC LIMIT 1;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ultimaVenda = rs.getInt("idvenda");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return ultimaVenda;
    }
}

