/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ItemMovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ItemMovelDao extends Dao<ItemMovel> {

    public ItemMovelDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("ITEM_MOVEL");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "iti_nome";
        vetorCampos = campos.split(",");

    }

    public ItemMovel getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "iti_nome");

        ps.setString(1, descricao);

        return ps;
    }

    @Override
    protected void verificaExistente(ItemMovel item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um ItemMovel com esse nome.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(ItemMovel item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(ItemMovel item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getId());

        return ps;

    }

    @Override
    protected ItemMovel criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new ItemMovel(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0])
            );

        }

        return null;

    }

}
