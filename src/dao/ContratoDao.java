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
import model.Contrato;
import util.CriaStatement;

/**
 *
 * @author rapha
 */
public class ContratoDao extends Dao<Contrato> {

    public ContratoDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("CONTRATO");

        id = obj.getNomeId();
        tabela = obj.getNomeTabela();
        criaStatement = new CriaStatement(con, tabela, id);
        campos = "con_data,con_data_alteracao,con_pago,con_orc_iden,con_ativado";
        vetorCampos = campos.split(",");

    }

    private OrcamentoDao orcamentoDao = new OrcamentoDao();

    @Override
    protected void verificaExistenteInserir(Contrato item) throws Exception {

        if (getByIdOrcamento(item.getOrcamento().getId()) != null) {
            throw new Exception("Já existe um contrato para este orçamento.");
        }

    }
    
    @Override
    protected void verificaExistenteAlterar(Contrato item) throws Exception {

        if (getByIdOrcamento(item.getOrcamento().getId()) != null && getByIdOrcamento(item.getOrcamento().getId()).getOrcamento().getId() != getByID(item.getId()).getOrcamento().getId()) {
            throw new Exception("Já existe um contrato para este orçamento.");
        }

    }

    public Contrato getByIdOrcamento(int idOrcamento) throws Exception {

        ps = statementByIdOrcamento(idOrcamento);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByIdOrcamento(int idOrcamento) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "con_orc_iden");

        ps.setInt(1, idOrcamento);

        return ps;
    }

    @Override
    protected PreparedStatement statementInserir(Contrato item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setDate(1, item.getData());
        ps.setDate(2, item.getDataAlteracao());
        ps.setInt(3, item.getPago());
        ps.setInt(4, item.getOrcamento().getId());
        ps.setInt(5, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Contrato item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setDate(1, item.getData());
        ps.setDate(2, item.getDataAlteracao());
        ps.setInt(3, item.getPago());
        ps.setInt(4, item.getOrcamento().getId());
        ps.setInt(5, item.getAtivado());
        ps.setInt(6, item.getId());

        return ps;

    }

    @Override
    protected Contrato criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Contrato(
                    rs.getInt(id),
                    rs.getDate(vetorCampos[0]),
                    rs.getDate(vetorCampos[1]),
                    rs.getInt(vetorCampos[2]),
                    orcamentoDao.getByID(rs.getInt(vetorCampos[3])),
                    rs.getInt(vetorCampos[4])
            );

        }

        return null;

    }

}
