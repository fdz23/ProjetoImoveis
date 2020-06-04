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
import model.TipoPagamento;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoPagamentoDao extends Dao<TipoPagamento> {

    public TipoPagamentoDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("TIPO_PAGAMENTO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "tpa_descricao";
        vetorCampos = campos.split(",");

    }

    public TipoPagamento getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "tpa_descricao");

        ps.setString(1, descricao);

        return ps;
    }

    @Override
    protected void verificaExistente(TipoPagamento item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um TipoPagamento com essa descrição.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(TipoPagamento item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(TipoPagamento item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getId());

        return ps;

    }

    @Override
    protected TipoPagamento criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new TipoPagamento(
                    rs.getInt(id),
                    rs.getString("tpa_descricao")
            );

        }

        return null;

    }

}
