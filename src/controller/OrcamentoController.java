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
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("ORCAMENTO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(Orcamento item) {
        
        try {

            psOrcamento = criaStatement.insertSql(tabela, "orc_data,orc_descricao,orc_func_iden,orc_pes_iden,orc_imo_iden,orc_tpa_iden");

            psOrcamento.setString(1, item.getData());
            psOrcamento.setString(2, item.getDescricao());
            psOrcamento.setInt(3, item.getIdFuncionario());
            psOrcamento.setInt(4, item.getIdPessoa());
            psOrcamento.setInt(5, item.getIdImovel());
            psOrcamento.setInt(6, item.getIdTipoPagamento());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psOrcamento;
        
    }

    @Override
    public PreparedStatement statementAlterar(Orcamento item) {
        
        try {

            psOrcamento = criaStatement.updateSql("orc_data,orc_descricao,orc_func_iden,orc_pes_iden,orc_imo_iden,orc_tpa_iden");

            psOrcamento.setString(1, item.getData());
            psOrcamento.setString(2, item.getDescricao());
            psOrcamento.setInt(3, item.getIdFuncionario());
            psOrcamento.setInt(4, item.getIdPessoa());
            psOrcamento.setInt(5, item.getIdImovel());
            psOrcamento.setInt(6, item.getIdTipoPagamento());
            psOrcamento.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psOrcamento;
        
    }
    
    @Override
    public Orcamento criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Orcamento(
                        rs.getInt(id), 
                        rs.getString("orc_data"), 
                        rs.getString("orc_descricao"), 
                        rs.getInt("orc_func_iden"),
                        rs.getInt("orc_pes_iden"),
                        rs.getInt("orc_imo_iden"),
                        rs.getInt("orc_tpa_iden")
                );

            } else
                throw new Exception("Orcamento não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
