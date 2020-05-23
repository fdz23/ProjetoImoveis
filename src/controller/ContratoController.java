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
import model.Contrato;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ContratoController extends Controller<Contrato> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psContrato;

    public ContratoController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(Contrato item) {
        
        try {

            psContrato = criaStatement.insertSql("contratos", "con_data_orcamento,con_data_alteracao,id_sit_situacao,id_orc_orcamento");

            psContrato.setString(1, item.getDataOrcamento());
            psContrato.setString(2, item.getDataAlteracao());
            psContrato.setInt(3, item.getIdSituacao());
            psContrato.setInt(4, item.getIdOrcamento());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementAlterar(Contrato item) {
        
        try {

            psContrato = criaStatement.updateSql("contratos", "con_data_orcamento,con_data_alteracao,id_sit_situacao,id_orc_orcamento");

            psContrato.setString(1, item.getDataOrcamento());
            psContrato.setString(2, item.getDataAlteracao());
            psContrato.setInt(3, item.getIdSituacao());
            psContrato.setInt(4, item.getIdOrcamento());
            psContrato.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psContrato = criaStatement.deleteSql("contratos");

            psContrato.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psContrato;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psContrato = criaStatement.selectSql("contratos", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psContrato;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psContrato = criaStatement.selectSql("contratos", true, "id");
            
            psContrato.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psContrato;
    }

    @Override
    public Contrato criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Contrato(
                        rs.getInt("id"), 
                        rs.getString("con_data_orcamento"), 
                        rs.getString("con_data_alteracao"), 
                        rs.getInt("id_sit_situacao"), 
                        rs.getInt("id_orc_orcamento")
                );

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
