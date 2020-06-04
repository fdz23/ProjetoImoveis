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

    public TipoImovel getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "tim_nome");

        ps.setString(1, descricao);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(TipoImovel item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um TipoImovel com esse nome.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(TipoImovel item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null && getByDescricao(item.getDescricao()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Já existe um TipoImovel com esse nome.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(TipoImovel item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(TipoImovel item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getId());

        return ps;

    }

    @Override
    protected TipoImovel criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new TipoImovel(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0])
            );

        }

        return null;

    }

}
