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
        
        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("TIPO_IMOVEL");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(TipoImovel item) {
        
        try {

            psTipoImovel = criaStatement.insertSql(tabela, "tim_nome");

            psTipoImovel.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoImovel;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoImovel item) {
        
        try {

            psTipoImovel = criaStatement.updateSql("tim_nome");

            psTipoImovel.setString(1, item.getDescricao());
            psTipoImovel.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoImovel;
        
    }

    @Override
    public TipoImovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoImovel(
                        rs.getInt(id), 
                        rs.getString("tim_nome")
                );

            } else
                throw new Exception("TipoImovel não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
