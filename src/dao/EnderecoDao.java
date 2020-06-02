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
import javax.swing.JOptionPane;
import model.Endereco;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class EnderecoDao extends Dao<Endereco> {

    public EnderecoDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("ENDERECO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, id, tabela);
        campos = "end_codigo_ibge,end_logradouro,end_bairro,end_cidade,end_estado,end_complemento,end_numero,end_ponto_referencia,end_cep";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(Endereco item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getCodigoIBGE());
            ps.setString(2, item.getLogradouro());
            ps.setString(3, item.getBairro());
            ps.setString(4, item.getCidade());
            ps.setString(5, item.getEstado());
            ps.setString(6, item.getComplemento());
            ps.setString(7, item.getNumero());
            ps.setString(8, item.getPontoReferencia());
            ps.setString(9, item.getCep());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Endereco item) {

        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getCodigoIBGE());
            ps.setString(2, item.getLogradouro());
            ps.setString(3, item.getBairro());
            ps.setString(4, item.getCidade());
            ps.setString(5, item.getEstado());
            ps.setString(6, item.getComplemento());
            ps.setString(7, item.getNumero());
            ps.setString(8, item.getPontoReferencia());
            ps.setString(9, item.getCep());
            ps.setInt(10, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected Endereco criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new Endereco(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0]),
                        rs.getString(vetorCampos[1]),
                        rs.getString(vetorCampos[2]),
                        rs.getString(vetorCampos[3]),
                        rs.getString(vetorCampos[4]),
                        rs.getString(vetorCampos[5]),
                        rs.getString(vetorCampos[6]),
                        rs.getString(vetorCampos[7]),
                        rs.getString(vetorCampos[8])
                );

            } else {
                throw new Exception("Endereco não encontrado");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
