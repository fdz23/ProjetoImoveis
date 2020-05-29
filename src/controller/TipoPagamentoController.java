/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.TipoPagamento;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoPagamentoController extends Controller<TipoPagamento> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psTipoPagamento;

    public TipoPagamentoController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("TIPO_PAGAMENTO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(TipoPagamento item) {
        
        try {

            psTipoPagamento = criaStatement.insertSql(tabela, "tpa_descricao");

            psTipoPagamento.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoPagamento;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoPagamento item) {
        
        try {

            psTipoPagamento = criaStatement.updateSql("tpa_descricao");

            psTipoPagamento.setString(1, item.getDescricao());
            psTipoPagamento.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoPagamento;
        
    }

    @Override
    public TipoPagamento criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoPagamento(
                        rs.getInt(id), 
                        rs.getString("tpa_descricao")
                );

            } else
                throw new Exception("TipoPagamento não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
