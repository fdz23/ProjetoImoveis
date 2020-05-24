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
import model.Situacao;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class SituacaoController extends Controller<Situacao> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psSituacao;

    public SituacaoController(Connection con) {

        super(con);
        this.id = "sit_iden";
        this.tabela = "situacoes";
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(Situacao item) {
        
        try {

            psSituacao = criaStatement.insertSql(tabela, "sit_descricao");

            psSituacao.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psSituacao;
        
    }

    @Override
    public PreparedStatement statementAlterar(Situacao item) {
        
        try {

            psSituacao = criaStatement.updateSql("sit_descricao");

            psSituacao.setString(1, item.getDescricao());
            psSituacao.setInt(2, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psSituacao;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psSituacao = criaStatement.deleteSql();

            psSituacao.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psSituacao;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psSituacao = criaStatement.selectSql(tabela, false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psSituacao;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psSituacao = criaStatement.selectSql(tabela, true, this.id);
            
            psSituacao.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psSituacao;
    }

    @Override
    public Situacao criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Situacao(
                        rs.getInt(id), 
                        rs.getString("sit_descricao")
                );

            } else
                throw new Exception("Situacao não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
