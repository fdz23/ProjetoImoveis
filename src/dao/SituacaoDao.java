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
import model.Situacao;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class SituacaoDao extends Dao<Situacao> {

    public SituacaoDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("SITUACAO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "sit_descricao";
        vetorCampos = campos.split(",");

    }
    
    public Situacao getByDescricao(String descricao) {

        try {

            ps = statementByDescricao(descricao);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByDescricao(String descricao) {

        try {

            ps = criaStatement.selectSql(tabela, true, "sit_descricao");

            ps.setString(1, descricao);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    @Override
    protected void verificaExistente(Situacao item) throws Exception {
    
        if (getByDescricao(item.getDescricao()) != null)
            throw new Exception("Já existe um NivelAcesso com essa descrição.");
    
    }

    @Override
    protected PreparedStatement statementInserir(Situacao item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Situacao item) {

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
    protected Situacao criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new Situacao(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0])
                );

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
