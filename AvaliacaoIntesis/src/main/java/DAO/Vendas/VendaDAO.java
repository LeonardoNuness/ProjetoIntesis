/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Vendas;

import Conexao.Conexao;
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
public class VendaDAO {
    
    public void createVenda(Venda v){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
         java.util.Date dateJava = v.getDataVenda();
         java.sql.Date dateSQL = v.dateJavaParaSQL(dateJava);
        
        try{           
            stmt = conexao.prepareStatement("INSERT INTO vendas (valorTotal,datavenda,formapagamento,cliente) VALUES (?,?,?,?)");
            
            stmt.setDouble(1,v.getTotalVenda());
            stmt.setDate(2, dateSQL);
            stmt.setString(3,v.getFormaPagamento());
            stmt.setInt(4,v.getCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Venda executada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }
    
    public void deleteVenda(int idvenda){
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try{           
            stmt = conexao.prepareStatement("DELETE FROM vendas WHERE idvenda = ?");
            stmt.setInt(1,idvenda);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "A venda foi excluida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a venda: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt);
        }
        
    }

    public List<Venda> readTabelaVenda() {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM vendas ORDER BY idvenda ASC");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Venda v = new Venda();
                
                v.setId(rs.getInt("idvenda")); 
                v.setCliente(rs.getInt("cliente"));
                v.setTotalVenda(rs.getDouble("valortotal"));
                v.setDataVenda(rs.getDate("datavenda"));
                v.setFormaPagamento(rs.getString("formapagamento"));
                
                vendas.add(v);

                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return vendas;
    }
    
    public String clienteForId(Venda v) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nomeCliente = null;
        
        try {
            stmt = conexao.prepareStatement("SELECT nome FROM clientes WHERE idcliente=?");
            stmt.setInt(1,v.getCliente());
            rs = stmt.executeQuery();
            while(rs.next()){
                nomeCliente = rs.getString("nome");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os produtos: \n" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return nomeCliente;
    }
    
    
    
    
}
