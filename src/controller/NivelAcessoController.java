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
import model.NivelAcesso;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class NivelAcessoController extends Controller<NivelAcesso> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psItemMovel;

    public NivelAcessoController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(NivelAcesso item) {
        
        try {

            psItemMovel = criaStatement.insertSql("nivel_acessos", "nia_descricao");

            psItemMovel.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psItemMovel;
        
    }

    @Override
    public PreparedStatement statementAlterar(NivelAcesso item) {
        
        try {

            psItemMovel = criaStatement.updateSql("nivel_acessos", "nia_descricao");

            psItemMovel.setString(1, item.getDescricao());
            psItemMovel.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psItemMovel;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psItemMovel = criaStatement.deleteSql("nivel_acessos");

            psItemMovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psItemMovel;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psItemMovel = criaStatement.selectSql("nivel_acessos", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psItemMovel;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psItemMovel = criaStatement.selectSql("nivel_acessos", true, "id");
            
            psItemMovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psItemMovel;
    }

    @Override
    public NivelAcesso criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new NivelAcesso(
                        rs.getInt("id"), 
                        rs.getString("nia_descricao")
                );

            } else
                throw new Exception("NivelAcesso não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
