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
    
    public OrcamentoController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("ORCAMENTO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "orc_data,orc_descricao,orc_func_iden,orc_pes_iden,orc_imo_iden,orc_tpa_iden";
        vetorCampos = campos.split(",");

    }

    @Override
    public PreparedStatement statementInserir(Orcamento item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getData());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getIdFuncionario());
            ps.setInt(4, item.getIdPessoa());
            ps.setInt(5, item.getIdImovel());
            ps.setInt(6, item.getIdTipoPagamento());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    public PreparedStatement statementAlterar(Orcamento item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getData());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getIdFuncionario());
            ps.setInt(4, item.getIdPessoa());
            ps.setInt(5, item.getIdImovel());
            ps.setInt(6, item.getIdTipoPagamento());
            ps.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }
    
    @Override
    public Orcamento criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Orcamento(
                        rs.getInt(id), 
                        rs.getString(vetorCampos[0]), 
                        rs.getString(vetorCampos[1]), 
                        rs.getInt(vetorCampos[2]),
                        rs.getInt(vetorCampos[3]),
                        rs.getInt(vetorCampos[4]),
                        rs.getInt(vetorCampos[5])
                );

            } else
                throw new Exception("Orcamento não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
