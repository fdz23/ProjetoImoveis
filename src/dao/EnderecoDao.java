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
import model.Endereco;
import util.CriaStatement;

/**
 *
 * @author rapha
 */
public class EnderecoDao extends Dao<Endereco> {

    public EnderecoDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("ENDERECO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "end_codigo_ibge,end_logradouro,end_bairro,end_cidade,end_estado,end_complemento,end_numero,end_ponto_referencia,end_cep,end_ativado";
        vetorCampos = campos.split(",");

    }

    @Override
    protected void verificaExistenteInserir(Endereco item) {
    }
    
    @Override
    protected void verificaExistenteAlterar(Endereco item) throws Exception {
    }


    @Override
    protected PreparedStatement statementInserir(Endereco item) throws Exception {

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
        ps.setInt(10, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Endereco item) throws Exception {

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
        ps.setInt(10, item.getAtivado());
        ps.setInt(11, item.getId());

        return ps;

    }

    @Override
    protected Endereco criaItem(ResultSet rs) throws Exception {

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
                    rs.getString(vetorCampos[8]),
                    rs.getInt(vetorCampos[9])
            );

        }

        return null;

    }

}
