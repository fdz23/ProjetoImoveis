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
import model.Orcamento;
import util.CriaStatement;

/**
 *
 * @author rapha
 */
public class OrcamentoDao extends Dao<Orcamento> {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private PessoaDao pessoaDao = new PessoaDao();
    private ImovelDao imovelDao = new ImovelDao();
    private TipoPagamentoDao tipoPagamentoDao = new TipoPagamentoDao();

    public OrcamentoDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("ORCAMENTO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "orc_data,orc_descricao,orc_func_iden,orc_pes_iden,orc_imo_iden,orc_tpa_iden,orc_ativado";
        vetorCampos = campos.split(",");

    }

    public Orcamento getByIdImovel(int idImovel) throws Exception {

        ps = statementByIdImovel(idImovel);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByIdImovel(int idImovel) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "orc_imo_iden");

        ps.setInt(1, idImovel);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(Orcamento item) throws Exception {

        if (getByIdImovel(item.getImovel().getId()) != null) {
            throw new Exception("Já existe um Orçamento sobre este imóvel.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(Orcamento item) throws Exception {

        if (getByIdImovel(item.getImovel().getId()) != null && getByIdImovel(item.getImovel().getId()).getId() != getByID(item.getId()).getImovel().getId()) {
            throw new Exception("Já existe um Orçamento sobre este imóvel.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(Orcamento item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setDate(1, item.getData());
        ps.setString(2, item.getDescricao());
        ps.setInt(3, item.getFuncionario().getId());
        ps.setInt(4, item.getPessoa().getId());
        ps.setInt(5, item.getImovel().getId());
        ps.setInt(6, item.getTipoPagamento().getId());
        ps.setInt(7, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Orcamento item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setDate(1, item.getData());
        ps.setString(2, item.getDescricao());
        ps.setInt(3, item.getFuncionario().getId());
        ps.setInt(4, item.getPessoa().getId());
        ps.setInt(5, item.getImovel().getId());
        ps.setInt(6, item.getTipoPagamento().getId());
        ps.setInt(7, item.getAtivado());
        ps.setInt(8, item.getId());

        return ps;

    }

    @Override
    protected Orcamento criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Orcamento(
                    rs.getInt(id),
                    rs.getDate(vetorCampos[0]),
                    rs.getString(vetorCampos[1]),
                    funcionarioDao.getByID(rs.getInt(vetorCampos[2])),
                    pessoaDao.getByID(rs.getInt(vetorCampos[3])),
                    imovelDao.getByID(rs.getInt(vetorCampos[4])),
                    tipoPagamentoDao.getByID(rs.getInt(vetorCampos[5])),
                    rs.getInt(vetorCampos[6])
            );

        }

        return null;

    }

}
