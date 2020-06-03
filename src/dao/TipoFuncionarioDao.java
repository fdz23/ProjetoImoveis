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
import model.TipoFuncionario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoFuncionarioDao extends Dao<TipoFuncionario> {
    
    private NivelAcessoDao nivelAcessoDao = new NivelAcessoDao();

    public TipoFuncionarioDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("TIPO_FUNCIONARIO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "tfu_descricao,tfu_nac_iden,tfu_salario,tfu_login";
        vetorCampos = campos.split(",");

    }
    
    public TipoFuncionario getByDescricao(String descricao) {

        try {

            ps = statementByDescricao(descricao);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByDescricao(String descricao) {

        try {

            ps = criaStatement.selectSql(tabela, true, "tfu_descricao");

            ps.setString(1, descricao);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    public TipoFuncionario getByLogin(int login) {

        try {

            ps = statementByLogin(login);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByLogin(int login) {

        try {

            ps = criaStatement.selectSql(tabela, true, "tfu_login");

            ps.setInt(1, login);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    @Override
    protected void verificaExistente(TipoFuncionario item) throws Exception {
    
        if (getByDescricao(item.getDescricao()) != null)
            throw new Exception("Já existe um TipoFuncionario com essa descrição.");
        else if (getByLogin(item.getLogin()) != null)
            throw new Exception("Já existe um TipoFuncionario com esse login.");
    
    }

    @Override
    protected PreparedStatement statementInserir(TipoFuncionario item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());
            ps.setInt(2, item.getNivelAcesso().getId());
            ps.setDouble(3, item.getSalario());
            ps.setInt(4, item.getLogin());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(TipoFuncionario item) {

        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getDescricao());
            ps.setInt(2, item.getNivelAcesso().getId());
            ps.setDouble(3, item.getSalario());
            ps.setInt(4, item.getId());
            ps.setInt(5, item.getLogin());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected TipoFuncionario criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new TipoFuncionario(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0]),
                        nivelAcessoDao.getByID(rs.getInt(vetorCampos[1])),
                        rs.getDouble(vetorCampos[2]),
                        rs.getInt(vetorCampos[3])
                );

            } else {
                throw new Exception("TipoFuncionario não encontrado");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
