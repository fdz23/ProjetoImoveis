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

    public TipoFuncionarioDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("TIPO_FUNCIONARIO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "tfu_descricao,tfu_nac_iden,tfu_salario";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(TipoFuncionario item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getDescricao());
            ps.setInt(2, item.getIdNivelAcesso());
            ps.setDouble(3, item.getSalario());

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
            ps.setInt(2, item.getIdNivelAcesso());
            ps.setDouble(3, item.getSalario());
            ps.setInt(4, item.getId());

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
                        rs.getInt(vetorCampos[1]),
                        rs.getDouble(vetorCampos[2])
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
