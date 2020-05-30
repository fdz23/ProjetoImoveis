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
import model.NivelAcesso;
import util.CriaStatement;
import util.ConectaDb;

/**
 *
 * @author fdz
 */
public class NivelAcessoDao extends Dao<NivelAcesso> {

    public NivelAcessoDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("NIVEL_ACESSO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(ConectaDb.conectadb(), tabela, id);
        campos = "nac_descricao";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(NivelAcesso item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(NivelAcesso item) {

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
    protected NivelAcesso criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new NivelAcesso(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0])
                );

            } else {
                throw new Exception("NivelAcesso não encontrado");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
