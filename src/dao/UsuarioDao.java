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
import model.Funcionario;
import model.Usuario;
import util.CriaStatement;
import util.GeradorPasswords;

/**
 *
 * @author rapha
 */
public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("USUARIO");

        id = obj.getNomeId();
        tabela = obj.getNomeTabela();
        criaStatement = new CriaStatement(con, tabela, id);
        campos = "usu_fun_iden,usu_senha,usu_ativado,usu_token_redefinicao";
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

        ps.setInt(1, item.getFuncionario().getId());
        ps.setString(2, item.getSenha());
        ps.setInt(3, item.getAtivado());
        ps.setString(4, item.getToken());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Usuario item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setInt(1, item.getFuncionario().getId());
        ps.setString(2, item.getSenha());
        ps.setInt(3, item.getAtivado());
        ps.setString(4, item.getToken());
        ps.setInt(5, item.getId());

        return ps;

    }

    @Override
    protected Usuario criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Usuario(
                    rs.getInt(id),
                    funcionarioDao.getByID(rs.getInt(vetorCampos[0])),
                    rs.getString(vetorCampos[1]),
                    rs.getInt(vetorCampos[2]),
                    rs.getString(vetorCampos[3])
            );

        }

        return null;

    }

    public boolean verificaSenha(Funcionario funcionario, String senha) throws Exception {

        Usuario usuario = getByIDFun(funcionario.getId());

        if (usuario == null) {
            return false;
        } else {
            if (GeradorPasswords.verifyUserPassword(senha, usuario.getSenha(), "Pacoca")) {
                return true;
            }
        }

        return false;
    }

    public Usuario getByIDFun(int idFuncionario) throws Exception {

        String sql = "SELECT * FROM usuarios"
                + " WHERE usu_fun_iden = ?";

        ps = con.prepareStatement(sql);

        ps.setInt(1, idFuncionario);

        ResultSet rs = ps.executeQuery();

        return criaItem(rs);

    }

    public Usuario getUsuarioComLoginPorEmail(String email) throws SQLException, Exception {

        ps = criaStatement.selectSqlEmailFuncionarioUsuario();

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        Usuario usuario = null;

        if (rs.next()) {
            usuario = new Usuario(
                    rs.getInt(id),
                    funcionarioDao.getByID(rs.getInt(vetorCampos[0])),
                    rs.getString(vetorCampos[1]),
                    rs.getInt(vetorCampos[2]),
                    rs.getString(vetorCampos[3])
            );
        }

        return usuario;

    }
    
    public Usuario getByToken(String token) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "usu_token_redefinicao");
        
        ps.setString(1, token);

        ResultSet rs = ps.executeQuery();

        Usuario item = criaItem(rs);

        return item;

    }

}
