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
import model.NivelAcesso;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class NivelAcessoController extends Controller<NivelAcesso> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psNivelAcesso;

    public NivelAcessoController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("NIVEL_ACESSO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(NivelAcesso item) {
        
        try {

            psNivelAcesso = criaStatement.insertSql(tabela, "nac_descricao");

            psNivelAcesso.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psNivelAcesso;
        
    }

    @Override
    public PreparedStatement statementAlterar(NivelAcesso item) {
        
        try {

            psNivelAcesso = criaStatement.updateSql("nac_descricao");

            psNivelAcesso.setString(1, item.getDescricao());
            psNivelAcesso.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psNivelAcesso;
        
    }

    @Override
    public NivelAcesso criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new NivelAcesso(
                        rs.getInt(id), 
                        rs.getString("nac_descricao")
                );

            } else
                throw new Exception("NivelAcesso não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
