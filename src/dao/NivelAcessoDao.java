/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.fabricas.AbstractFactory;
import model.interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.NivelAcesso;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class NivelAcessoDao extends Dao<NivelAcesso> {

    public NivelAcessoDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("NIVEL_ACESSO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "nac_descricao,nac_ativado";
        vetorCampos = campos.split(",");

    }

    public NivelAcesso getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "nac_descricao");

        ps.setString(1, descricao);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(NivelAcesso item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um NivelAcesso com essa descrição.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(NivelAcesso item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null && getByDescricao(item.getDescricao()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Já existe um NivelAcesso com esse nome.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(NivelAcesso item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(NivelAcesso item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getAtivado());
        ps.setInt(3, item.getId());

        return ps;

    }

    @Override
    protected NivelAcesso criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new NivelAcesso(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    rs.getInt(vetorCampos[1])
            );

        }

        return null;

    }

}
