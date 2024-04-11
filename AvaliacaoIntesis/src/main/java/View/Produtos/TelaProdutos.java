/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.Produtos.ProdutoDAO;
import Model.Produtos.Produto;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Leonardo
 */
public class TelaProdutos extends javax.swing.JFrame {

    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        tblProdutos.setRowSorter(new TableRowSorter (model));
        
        fillTable();
    }
    
    public void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setNumRows(0);
        ProdutoDAO pDAO = new ProdutoDAO();
        
        for(Produto p: pDAO.readTabelaProduto()){
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
            });
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnCadastroProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        btnAtualizaProduto = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        lblProdutos = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Preco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setMinWidth(50);
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProdutos.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProdutos.getColumnModel().getColumn(2).setMinWidth(100);
            tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblProdutos.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        btnCadastroProduto.setText("Cadastrar");
        btnCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        btnAtualizaProduto.setText("Atualizar");
        btnAtualizaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaProdutoActionPerformed(evt);
            }
        });

        lblCategoria.setText("Categoria");

        lblDescricao.setText("Descricao");

        txtId.setEnabled(false);

        lblId.setText("Id");

        lblNome.setText("Nome");

        lblPreco.setText("Preco");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblProdutos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblProdutos.setText("Produtos");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirProduto)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescricao)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblId)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnVoltar)
                                                .addGap(10, 10, 10)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblNome)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(179, 179, 179)
                                                .addComponent(lblProdutos)))))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblDescricao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPreco)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(lblProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNome)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastroProduto)
                            .addComponent(btnExcluirProduto)
                            .addComponent(btnAtualizaProduto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnLimpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clean(){
        txtId.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtCategoria.setText("");
        txtPreco.setText("");
        btnAtualizaProduto.setText("Atualizar");
        btnCadastroProduto.setText("Cadastrar");
    }
    
    private void btnCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutoActionPerformed
        // TODO add your handling code here:
        String txtButton = btnCadastroProduto.getText();
        int textid = 0;
        try{
        textid = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException ex){}
        
        if(txtButton=="Cadastrar" && textid!=0){
        JOptionPane.showMessageDialog(null,"Nao é possivel cadastrar um produto existente");
        }
        else{
        if(txtButton=="Cadastrar")
        {
        save();
        }
        else
        {
        update();
        }  
        }
    }//GEN-LAST:event_btnCadastroProdutoActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        // TODO add your handling code here:
        String textId = txtId.getText();
        if(textId.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um produto para fazer a exclusao");
        }
        else
        {
        delete();
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        // TODO add your handling code here:
        int linha = tblProdutos.getSelectedRow();
        
        int idBuscado = Integer.parseInt(tblProdutos.getValueAt(linha, 0).toString());
        
        Produto produtoSearch = new Produto();
        Produto produtoResult = new Produto();
        ProdutoDAO pDAO = new ProdutoDAO();
        
        produtoSearch.setId(idBuscado);
        
        produtoResult = pDAO.returnProdutoTela(produtoSearch);
        
        txtId.setText(String.valueOf(produtoResult.getId()));
        txtNome.setText(produtoResult.getNome());
        txtDescricao.setText(produtoResult.getDescricao());
        txtCategoria.setText(produtoResult.getCategoria());
        txtPreco.setText(String.valueOf(produtoResult.getPreco()));
        
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void btnAtualizaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaProdutoActionPerformed
        // TODO add your handling code here:
        String txtButton = btnCadastroProduto.getText();
        String textId = txtId.getText();
        if(textId.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um produto para fazer as alterações");
        }
        else
        {
        if(txtButton=="Cadastrar"){
        btnAtualizaProduto.setText("Atualizando...");
        btnCadastroProduto.setText("Atualizar");
        }
        else{
            btnAtualizaProduto.setText("Atualizar");
            btnCadastroProduto.setText("Cadastrar");
        }
        }
        
    }//GEN-LAST:event_btnAtualizaProdutoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        TelaInicio tela = new TelaInicio();
        tela.show();
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void save(){
        Produto p = new Produto();
        ProdutoDAO pDAO = new ProdutoDAO();
        
        try{
        p.setNome(txtNome.getText());
        p.setDescricao(txtDescricao.getText());
        p.setCategoria(txtCategoria.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        }
        catch(NumberFormatException ex){}
        
        if(verificacaoCamposVazios(p)==false){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
        else
        {
        pDAO.createProduto(p);
        
        fillTable();
        
        clean();
        }
    }
    
    public boolean verificacaoCamposVazios(Produto p){
        if(p.getNome().isEmpty()||
           p.getDescricao().isEmpty()||
           p.getCategoria().isEmpty()||
           p.getPreco()==0.0)
        {
            return false;
        }
        return true;
        
    }
    
    private void delete(){
        Produto p = new Produto();
        ProdutoDAO pDAO = new ProdutoDAO();
        int linha = tblProdutos.getSelectedRow();
        String nome = tblProdutos.getValueAt(linha, 1).toString();
        
        p.setId(Integer.parseInt(txtId.getText()));      
        int result = JOptionPane.showConfirmDialog(null, "Deseja excluir o produto: " + nome,
                "Alerta de exclusao",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(result == JOptionPane.OK_OPTION){
            pDAO.deleteProduto(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "A exclusao do produto foi cancelada");
        }
        
        fillTable();
        
        clean();
    }
    
    private void update(){
        Produto p = new Produto();
        ProdutoDAO pDAO = new ProdutoDAO();
        int linha = tblProdutos.getSelectedRow();
        String nome = tblProdutos.getValueAt(linha, 1).toString();
        
        try {
        p.setId(Integer.parseInt(txtId.getText()));
        p.setNome(txtNome.getText());
        p.setDescricao(txtDescricao.getText());
        p.setCategoria(txtCategoria.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado");
        }
        
        int result = JOptionPane.showConfirmDialog(null, "Deseja atualizar o produto: " + nome,
                "Alerta de altualização",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(result == JOptionPane.OK_OPTION){
            pDAO.updateProduto(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "A atualização do produto foi cancelada");
        }
        
        fillTable();
        
        clean();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizaProduto;
    private javax.swing.JButton btnCadastroProduto;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblProdutos;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
