/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Vendas;

import Conexao.Conexao;
import Model.Produtos.Venda_Produtos;
import Model.Vendas.Venda;
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
public class Venda_ProdutoDAO {
    
     public void createVendaProdutos(List<Venda_Produtos> listVendaProdutos){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            for(Venda_Produtos vp: listVendaProdutos){
            stmt = conexao.prepareStatement("INSERT INTO vendas_produtos (idvenda,nome,preco,quant) VALUES (?,?,?,?)");
            stmt.setInt(1,vp.getIdvenda());
            stmt.setString(2,vp.getNome());
            stmt.setDouble(3,vp.getPreco());
            stmt.setInt(4,vp.getQuantidade());
            }
            
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }
     
     
    public int ultimaVenda(Venda v) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nomeCliente = null;
        
        try {
            stmt = conexao.prepareStatement("SELECT LAST vendas WHERE idcliente=?");
            stmt.setInt(1,v.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                nomeCliente = rs.getString("nome");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
       // return ultimaVenda;
         return 0;
    }
}

