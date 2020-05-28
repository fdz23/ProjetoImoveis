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
import model.Status;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class StatusController extends Controller<Status> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psStatus;

    public StatusController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("STATUS");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(Status item) {
        
        try {

            psStatus = criaStatement.insertSql(tabela, "sta_descricao");

            psStatus.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psStatus;
        
    }

    @Override
    public PreparedStatement statementAlterar(Status item) {
        
        try {

            psStatus = criaStatement.updateSql("sta_descricao");

            psStatus.setString(1, item.getDescricao());
            psStatus.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psStatus;
        
    }

    @Override
    public Status criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Status(
                        rs.getInt(id), 
                        rs.getString("sta_descricao")
                );

            } else
                throw new Exception("Status não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
