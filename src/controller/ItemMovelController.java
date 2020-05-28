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
import model.ItemMovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ItemMovelController extends Controller<ItemMovel> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psItemMovel;

    public ItemMovelController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("ITEM_MOVEL");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(ItemMovel item) {
        
        try {

            psItemMovel = criaStatement.insertSql(tabela, "iti_nome");

            psItemMovel.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psItemMovel;
        
    }

    @Override
    public PreparedStatement statementAlterar(ItemMovel item) {
        
        try {

            psItemMovel = criaStatement.updateSql("iti_nome");

            psItemMovel.setString(1, item.getDescricao());
            psItemMovel.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psItemMovel;
        
    }

    @Override
    public ItemMovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new ItemMovel(
                        rs.getInt(id), 
                        rs.getString("iti_nome")
                );

            } else
                throw new Exception("ItemMovel não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
