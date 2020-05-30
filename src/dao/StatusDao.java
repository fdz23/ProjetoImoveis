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
import model.Status;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class StatusDao extends Dao<Status> {
    
    public StatusDao(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("STATUS");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "sta_descricao";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(Status item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected PreparedStatement statementAlterar(Status item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getDescricao());
            ps.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected Status criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Status(
                        rs.getInt(id), 
                        rs.getString(vetorCampos[0])
                );

            } else
                throw new Exception("Status não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
