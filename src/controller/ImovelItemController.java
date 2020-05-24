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
import model.ImovelItem;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelItemController extends Controller<ImovelItem> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psContrato;

    public ImovelItemController(Connection con) {

        super(con);
        this.id = "iit_iden";
        this.tabela = "imoveis_itens";
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(ImovelItem item) {
        
        try {

            psContrato = criaStatement.insertSql(tabela, "iit_valor,iit_iti_iden,iit_imo_iden");

            psContrato.setDouble(1, item.getValor());
            psContrato.setInt(2, item.getIdItemMovel());
            psContrato.setInt(3, item.getIdImovel());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementAlterar(ImovelItem item) {
        
        try {

            psContrato = criaStatement.updateSql("iit_valor,iit_iti_iden,iit_imo_iden");

            psContrato.setDouble(1, item.getValor());
            psContrato.setInt(2, item.getIdItemMovel());
            psContrato.setInt(3, item.getIdImovel());
            psContrato.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psContrato;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psContrato = criaStatement.deleteSql();

            psContrato.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psContrato;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psContrato = criaStatement.selectSql(tabela, false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psContrato;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psContrato = criaStatement.selectSql(tabela, true, this.id);
            
            psContrato.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psContrato;
    }

    @Override
    public ImovelItem criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new ImovelItem(
                        rs.getInt(id), 
                        rs.getDouble("iit_valor"), 
                        rs.getInt("iit_iti_iden"), 
                        rs.getInt("iit_imo_iden")
                );

            } else
                throw new Exception("ImovelItem não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
