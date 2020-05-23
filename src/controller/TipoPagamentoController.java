/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(TipoPagamento item) {
        
        try {

            psTipoPagamento = criaStatement.insertSql("tipo_pagamentos", "descricao");

            psTipoPagamento.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoPagamento;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoPagamento item) {
        
        try {

            psTipoPagamento = criaStatement.updateSql("tipo_pagamentos", "descricao");

            psTipoPagamento.setString(1, item.getDescricao());
            psTipoPagamento.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoPagamento;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psTipoPagamento = criaStatement.deleteSql("tipo_pagamentos");

            psTipoPagamento.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psTipoPagamento;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psTipoPagamento = criaStatement.selectSql("tipo_pagamentos", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psTipoPagamento;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psTipoPagamento = criaStatement.selectSql("tipo_pagamentos", true, "id");
            
            psTipoPagamento.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psTipoPagamento;
    }

    @Override
    public TipoPagamento criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoPagamento(
                        rs.getInt("id"), 
                        rs.getString("descricao")
                );

            } else
                throw new Exception("TipoPagamento não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
