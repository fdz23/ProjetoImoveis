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
import model.TipoImovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoImovelController extends Controller<TipoImovel> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psTipoImovel;

    public TipoImovelController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(TipoImovel item) {
        
        try {

            psTipoImovel = criaStatement.insertSql("tipo_imoveis", "descricao");

            psTipoImovel.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoImovel;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoImovel item) {
        
        try {

            psTipoImovel = criaStatement.updateSql("tipo_imoveis", "descricao");

            psTipoImovel.setString(1, item.getDescricao());
            psTipoImovel.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoImovel;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psTipoImovel = criaStatement.deleteSql("tipo_imoveis");

            psTipoImovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psTipoImovel;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psTipoImovel = criaStatement.selectSql("tipo_imoveis", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psTipoImovel;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psTipoImovel = criaStatement.selectSql("tipo_imoveis", true, "id");
            
            psTipoImovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psTipoImovel;
    }

    @Override
    public TipoImovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoImovel(
                        rs.getInt("id"), 
                        rs.getString("descricao")
                );

            } else
                throw new Exception("TipoImovel não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
