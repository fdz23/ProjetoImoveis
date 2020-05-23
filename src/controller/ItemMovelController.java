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
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(ItemMovel item) {
        
        try {

            psItemMovel = criaStatement.insertSql("item_moveis", "iti_descricao");

            psItemMovel.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psItemMovel;
        
    }

    @Override
    public PreparedStatement statementAlterar(ItemMovel item) {
        
        try {

            psItemMovel = criaStatement.updateSql("item_moveis", "iti_descricao");

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

            psItemMovel = criaStatement.deleteSql("item_moveis");

            psItemMovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psItemMovel;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psItemMovel = criaStatement.selectSql("item_moveis", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psItemMovel;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psItemMovel = criaStatement.selectSql("item_moveis", true, "id");
            
            psItemMovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psItemMovel;
    }

    @Override
    public ItemMovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new ItemMovel(
                        rs.getInt("id"), 
                        rs.getString("iti_descricao")
                );

            } else
                throw new Exception("ItemMovel não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
