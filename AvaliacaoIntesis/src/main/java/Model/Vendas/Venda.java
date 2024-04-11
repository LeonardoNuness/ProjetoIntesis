/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vendas;
;

import DAO.Vendas.Venda_ProdutoDAO;
import Model.Produtos.Venda_Produtos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import Model.Produtos.Venda_Produtos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.util.Date;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Venda {
    
    private int id;
    private int cliente;
    private Double totalVenda;
    private Date dataVenda;
    private String formaPagamento;
    private int quantidadeDeProduto;
    private List<Venda_Produtos> listVP = new ArrayList<>();


    
    public java.sql.Date dateJavaParaSQL(java.util.Date dataJava){
        java.util.Date date = dataJava;
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        return dateSQL;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the totalVenda
     */
    public Double getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the quantidadeDeProduto
     */
    public int getQuantidadeDeProduto() {
        return quantidadeDeProduto;
    }

    /**
     * @param quantidadeDeProduto the quantidadeDeProduto to set
     */
    public void setQuantidadeDeProduto(int quantidadeDeProduto) {
        this.quantidadeDeProduto = quantidadeDeProduto;
    }

    /**
     * @return the listVP
     */
    public List<Venda_Produtos> getListVP() {
        return listVP;
    }

    /**
     * @param listVP the listVP to set
     */
    public void setListVP(List<Venda_Produtos> listVP) {
        this.listVP = listVP;
    }
    
    
}
