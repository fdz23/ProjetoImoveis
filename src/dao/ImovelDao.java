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
import model.Imovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelDao extends Dao<Imovel> {

    public ImovelDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "imo_data_inclusao,imo_preco,imo_tamanho,imo_observacao,imo_baixa_data,imo_baixa_motivo,"
                + "imo_quantidade_parcelas,imo_valor_comissao,imo_fun_iden,imo_pes_iden,imo_tim_iden,imo_end_iden";
        vetorCampos = campos.split(",");

    }

    @Override
    protected PreparedStatement statementInserir(Imovel item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDate(1, item.getDataInclusao());
            ps.setDouble(2, item.getPreco());
            ps.setDouble(3, item.getTamanho());
            ps.setString(4, item.getObservacao());
            ps.setDate(5, item.getBaixaData());
            ps.setString(6, item.getBaixaMotivo());
            ps.setInt(7, item.getQuantidadeParcelas());
            ps.setDouble(8, item.getValorComissao());
            ps.setInt(9, item.getIdFuncionario());
            ps.setInt(10, item.getIdPessoa());
            ps.setInt(11, item.getIdTipoImovel());
            ps.setInt(12, item.getIdEndereco());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Imovel item) {

        try {

            ps = criaStatement.updateSql(campos);

            ps.setDate(1, item.getDataInclusao());
            ps.setDouble(2, item.getPreco());
            ps.setDouble(3, item.getTamanho());
            ps.setString(4, item.getObservacao());
            ps.setDate(5, item.getBaixaData());
            ps.setString(6, item.getBaixaMotivo());
            ps.setInt(7, item.getQuantidadeParcelas());
            ps.setDouble(8, item.getValorComissao());
            ps.setInt(9, item.getIdFuncionario());
            ps.setInt(10, item.getIdPessoa());
            ps.setInt(11, item.getIdTipoImovel());
            ps.setInt(12, item.getIdEndereco());
            ps.setInt(13, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected Imovel criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new Imovel(
                        rs.getInt(vetorCampos[0]),
                        rs.getDate(vetorCampos[1]),
                        rs.getDouble(vetorCampos[2]),
                        rs.getDouble(vetorCampos[3]),
                        rs.getString(vetorCampos[4]),
                        rs.getDate(vetorCampos[5]),
                        rs.getString(vetorCampos[6]),
                        rs.getInt(vetorCampos[7]),
                        rs.getDouble(vetorCampos[8]),
                        rs.getInt(vetorCampos[9]),
                        rs.getInt(vetorCampos[10]),
                        rs.getInt(vetorCampos[11]),
                        rs.getInt(vetorCampos[12])
                );

            } else {
                throw new Exception("Imovel não encontrado");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
