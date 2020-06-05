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
import model.TipoFuncionario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoFuncionarioDao extends Dao<TipoFuncionario> {

    private NivelAcessoDao nivelAcessoDao = new NivelAcessoDao();

    public TipoFuncionarioDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("TIPO_FUNCIONARIO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "tfu_descricao,tfu_nac_iden,tfu_salario,tfu_login";
        vetorCampos = campos.split(",");

    }

    public TipoFuncionario getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "tfu_descricao");

        ps.setString(1, descricao);

        return ps;
    }

    public TipoFuncionario getByLogin(int login) throws Exception {

        ps = statementByLogin(login);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByLogin(int login) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "tfu_login");

        ps.setInt(1, login);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(TipoFuncionario item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um TipoFuncionario com essa descrição.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(TipoFuncionario item) throws Exception {

        if (getByDescricao(item.getDescricao()) != null && getByDescricao(item.getDescricao()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Já existe um TipoFuncionario com essa descrição.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(TipoFuncionario item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getNivelAcesso().getId());
        ps.setDouble(3, item.getSalario());
        ps.setInt(4, item.getLogin());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(TipoFuncionario item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getDescricao());
        ps.setInt(2, item.getNivelAcesso().getId());
        ps.setDouble(3, item.getSalario());
        ps.setInt(4, item.getId());
        ps.setInt(5, item.getLogin());

        return ps;

    }

    @Override
    protected TipoFuncionario criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new TipoFuncionario(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    nivelAcessoDao.getByID(rs.getInt(vetorCampos[1])),
                    rs.getDouble(vetorCampos[2]),
                    rs.getInt(vetorCampos[3])
            );

        }

        return null;

    }

}
