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
import model.Usuario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("USUARIO");

        id = obj.getNomeId();
        tabela = obj.getNomeTabela();
        criaStatement = new CriaStatement(con, tabela, id);
        campos = "usu_senha,usu_fun_iden,usu_ativado";
        vetorCampos = campos.split(",");

    }

    private FuncionarioDao funcionarioDao = new FuncionarioDao();

    @Override
    protected void verificaExistenteInserir(Usuario item) throws Exception {

        if (getByIdFuncionario(item.getFuncionario().getId()) != null) {
            throw new Exception("Já existe um usuario para esse funcionario.");
        }

    }
    
    @Override
    protected void verificaExistenteAlterar(Usuario item) throws Exception {

        if (getByIdFuncionario(item.getFuncionario().getId()) != null && getByIdFuncionario(item.getFuncionario().getId()).getFuncionario().getId() != getByID(item.getId()).getFuncionario().getId()) {
            throw new Exception("Já existe um usuario para esse funcionario.");
        }

    }

    public Usuario getByIdFuncionario(int idFuncionario) throws Exception {

        ps = statementByIdFuncionario(idFuncionario);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByIdFuncionario(int idFuncionario) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "usu_fun_iden");

        ps.setInt(1, idFuncionario);

        return ps;
    }

    @Override
    protected PreparedStatement statementInserir(Usuario item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getSenha());
        ps.setInt(2, item.getFuncionario().getId());
        ps.setInt(3, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Usuario item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getSenha());
        ps.setInt(2, item.getFuncionario().getId());
        ps.setInt(3, item.getAtivado());
        ps.setInt(4, item.getId());

        return ps;

    }

    @Override
    protected Usuario criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Usuario(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    funcionarioDao.getByID(rs.getInt(vetorCampos[1])),
                    rs.getInt(vetorCampos[2])
            );

        }

        return null;

    }

}
