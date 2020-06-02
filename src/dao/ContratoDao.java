/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Contrato;
import model.Orcamento;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ContratoDao extends Dao<Contrato> {

    public ContratoDao() throws ClassNotFoundException {

        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("CONTRATO");
        
        id = obj.getNomeId();
        tabela = obj.getNomeTabela();
        criaStatement = new CriaStatement(con, tabela, id);
        campos = "con_data,con_data_alteracao,con_sit_iden,con_orc_iden";
        vetorCampos = campos.split(",");

    }
    
    private SituacaoDao situacaoDao = new SituacaoDao();
    private OrcamentoDao orcamentoDao = new OrcamentoDao();
    
    @Override
    protected void verificaExistente(Contrato item) throws Exception {
        
        if (getByIdOrcamento(item.getOrcamento().getId()) != null)
            throw new Exception("Já existe um contrato para este orçamento.");
        
    }
    
    public Contrato getByIdOrcamento(int idOrcamento) {

        try {

            ps = statementByIdOrcamento(idOrcamento);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByIdOrcamento(int idOrcamento) {

        try {

            ps = criaStatement.selectSql(tabela, true, "con_orc_iden");

            ps.setInt(1, idOrcamento);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    @Override
    protected PreparedStatement statementInserir(Contrato item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDate(1, item.getData());
            ps.setDate(2, item.getDataAlteracao());
            ps.setInt(3, item.getSituacao().getId());
            ps.setInt(4, item.getOrcamento().getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected PreparedStatement statementAlterar(Contrato item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setDate(1, item.getData());
            ps.setDate(2, item.getDataAlteracao());
            ps.setInt(3, item.getSituacao().getId());
            ps.setInt(4, item.getOrcamento().getId());
            ps.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected Contrato criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Contrato(
                        rs.getInt(id), 
                        rs.getDate(vetorCampos[0]), 
                        rs.getDate(vetorCampos[1]), 
                        situacaoDao.getByID(rs.getInt(vetorCampos[2])), 
                        orcamentoDao.getByID(rs.getInt(vetorCampos[3]))
                );

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
