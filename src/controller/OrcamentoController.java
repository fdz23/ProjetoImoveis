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
import model.Orcamento;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class OrcamentoController extends Controller<Orcamento> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psOrcamento;

    public OrcamentoController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(Orcamento item) {
        
        try {

            psOrcamento = criaStatement.insertSql("orcamentos", "orc_data_orcamento,orc_valor_orcamento,orc_descricao,orc_quantidade_parcelas,id_tip_tipo_pagamentos,id_pe_pessoa,id_fun_funcionario,id_im_imoveis");

            psOrcamento.setString(1, item.getDataOrcamento());
            psOrcamento.setDouble(2, item.getValorOrcamento());
            psOrcamento.setString(3, item.getDescricao());
            psOrcamento.setInt(4, item.getQuantidadeParcelas());
            psOrcamento.setInt(5, item.getIdTipoPagamento());
            psOrcamento.setInt(6, item.getIdPessoa());
            psOrcamento.setInt(7, item.getIdFuncionario());
            psOrcamento.setInt(8, item.getIdImovel());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psOrcamento;
        
    }

    @Override
    public PreparedStatement statementAlterar(Orcamento item) {
        
        try {

            psOrcamento = criaStatement.updateSql("orcamentos", "orc_data_orcamento,orc_valor_orcamento,orc_descricao,orc_quantidade_parcelas,id_tip_tipo_pagamentos,id_pe_pessoa,id_fun_funcionario,id_im_imoveis");

            psOrcamento.setString(1, item.getDataOrcamento());
            psOrcamento.setDouble(2, item.getValorOrcamento());
            psOrcamento.setString(3, item.getDescricao());
            psOrcamento.setInt(4, item.getQuantidadeParcelas());
            psOrcamento.setInt(5, item.getIdTipoPagamento());
            psOrcamento.setInt(6, item.getIdPessoa());
            psOrcamento.setInt(7, item.getIdFuncionario());
            psOrcamento.setInt(8, item.getIdImovel());
            psOrcamento.setInt(10, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psOrcamento;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psOrcamento = criaStatement.deleteSql("orcamentos");

            psOrcamento.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psOrcamento;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psOrcamento = criaStatement.selectSql("orcamentos", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psOrcamento;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psOrcamento = criaStatement.selectSql("orcamentos", true, "id");
            
            psOrcamento.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psOrcamento;
    }

    @Override
    public Orcamento criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Orcamento(
                        rs.getInt("id"), 
                        rs.getString("orc_data_orcamento"), 
                        rs.getDouble("orc_valor_orcamento"), 
                        rs.getString("orc_descricao"), 
                        rs.getInt("orc_quantidade_parcelas"),
                        rs.getInt("id_tip_tipo_pagamentos"),
                        rs.getInt("id_pe_pessoa"),
                        rs.getInt("id_fun_funcionario"), 
                        rs.getInt("id_im_imoveis")
                );

            } else
                throw new Exception("Orcamento não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
