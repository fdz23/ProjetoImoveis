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
import model.TipoImovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoImovelDao extends Dao<TipoImovel> {

    public TipoImovelDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("TIPO_IMOVEL");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "tim_nome";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(TipoImovel item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(TipoImovel item) {

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
    protected TipoImovel criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new TipoImovel(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0])
                );

            } else {
                throw new Exception("TipoImovel não encontrado");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
