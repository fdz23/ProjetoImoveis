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
import model.ImovelItem;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelItemController extends Controller<ImovelItem> {
    
    public ImovelItemController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL_ITEM");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "iit_valor,iit_iti_iden,iit_imo_iden";
        vetorCampos = campos.split(",");

    }

    @Override
    public PreparedStatement statementInserir(ImovelItem item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDouble(1, item.getValor());
            ps.setInt(2, item.getIdItemMovel());
            ps.setInt(3, item.getIdImovel());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    public PreparedStatement statementAlterar(ImovelItem item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setDouble(1, item.getValor());
            ps.setInt(2, item.getIdItemMovel());
            ps.setInt(3, item.getIdImovel());
            ps.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    public ImovelItem criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new ImovelItem(
                        rs.getInt(id), 
                        rs.getDouble(vetorCampos[0]), 
                        rs.getInt(vetorCampos[1]), 
                        rs.getInt(vetorCampos[2])
                );

            } else
                throw new Exception("ImovelItem não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
