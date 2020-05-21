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

            psContrato = criaStatement.insertSql("contrato", "idorcamento,status");

            psContrato.setInt(1, item.getIdOrcamento());
            psContrato.setString(2, item.getStatus());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementAlterar(Contrato item) {
        
        try {

            psContrato = criaStatement.updateSql("contrato", "idorcamento,status");

            psContrato.setInt(1, item.getIdOrcamento());
            psContrato.setString(2, item.getStatus());
            psContrato.setInt(3, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psContrato = criaStatement.deleteSql("contrato");

            psContrato.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psContrato;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psContrato = criaStatement.selectSql("contrato", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psContrato;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psContrato = criaStatement.selectSql("contrato", true, "id");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psContrato;
    }

    @Override
    public Contrato criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Contrato(rs.getInt("id"), rs.getInt("idorcamento"), rs.getString("status"));

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
