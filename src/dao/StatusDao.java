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
import java.sql.SQLException;
import model.Status;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class StatusDao extends Dao<Status> {

    public StatusDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("STATUS");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "sta_descricao";
        vetorCampos = campos.split(",");

    }

    public Status getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "sta_descricao");

        ps.setString(1, descricao);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(Status item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um NivelAcesso com essa descrição.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(Status item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null && getByDescricao(item.getDescricao()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Já existe um NivelAcesso com essa descrição.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(Status item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Status item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getId());

        return ps;

    }

    @Override
    protected Status criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Status(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0])
            );

        }

        return null;

    }

}
