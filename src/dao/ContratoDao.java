/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Contrato;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ContratoDao extends Dao<Contrato> {

    public ContratoDao(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("CONTRATO");
        
        id = obj.getNomeId();
        tabela = obj.getNomeTabela();
        criaStatement = new CriaStatement(con, tabela, id);
        campos = "con_data,con_data_alteracao,id_sit_iden,id_orc_iden";
        vetorCampos = campos.split(",");

    }
    
    @Override
    protected PreparedStatement statementInserir(Contrato item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDate(1, item.getData());
            ps.setDate(2, item.getDataAlteracao());
            ps.setInt(3, item.getIdSituacao());
            ps.setInt(4, item.getIdOrcamento());

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
            ps.setInt(3, item.getIdSituacao());
            ps.setInt(4, item.getIdOrcamento());
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
                        rs.getInt(vetorCampos[2]), 
                        rs.getInt(vetorCampos[3])
                );

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
