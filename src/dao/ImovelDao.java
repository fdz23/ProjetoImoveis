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
import model.Imovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelDao extends Dao<Imovel> {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private PessoaDao pessoaDao = new PessoaDao();
    private TipoImovelDao tipoImovelDao = new TipoImovelDao();
    private EnderecoDao enderecoDao = new EnderecoDao();
    private ImovelItemDao imovelItemDao = new ImovelItemDao();

    public ImovelDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "imo_data_inclusao,imo_preco,imo_tamanho,imo_situacao,imo_baixa_data,imo_baixa_motivo,"
                + "imo_quantidade_parcelas,imo_valor_comissao,imo_fun_iden,imo_pes_iden,imo_tim_iden,imo_end_iden,"
                + "imo_ativado,imo_descricao";
        vetorCampos = campos.split(",");

    }

    public Imovel getByDescricao(String descricao) throws Exception {

        ps = statementByDescricao(descricao);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByDescricao(String descricao) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "imo_descricao");

        ps.setString(1, descricao);

        return ps;
    }

    public Imovel getByIdEndereco(int idEndereco) throws Exception {

        ps = statementByIdEndereco(idEndereco);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByIdEndereco(int idEndereco) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "imo_end_iden");

        ps.setInt(1, idEndereco);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(Imovel item) throws Exception {

        if (getByIdEndereco(item.getEndereco().getId()) != null) {
            throw new Exception("Endereço já cadastrado.");
        }
        if (getByDescricao(item.getDescricao()) != null) {
            throw new Exception("Já existe um Imovel com essa descrição.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(Imovel item) throws Exception {

        if (getByIdEndereco(item.getEndereco().getId()) != null && getByIdEndereco(item.getEndereco().getId()).getId() != item.getId()) {
            throw new Exception("Endereço já cadastrado.");
        }
        if (getByDescricao(item.getDescricao()) != null && getByDescricao(item.getDescricao()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Já existe um Imovel com esse nome.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(Imovel item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setDate(1, item.getDataInclusao());
        ps.setDouble(2, item.getPreco());
        ps.setDouble(3, item.getTamanho());
        ps.setString(4, item.getSituacao());
        ps.setDate(5, item.getBaixaData());
        ps.setString(6, item.getBaixaMotivo());
        ps.setInt(7, item.getQuantidadeParcelas());
        ps.setDouble(8, item.getValorComissao());
        ps.setInt(9, item.getFuncionario().getId());
        ps.setInt(10, item.getPessoa().getId());
        ps.setInt(11, item.getTipoImovel().getId());
        ps.setInt(12, item.getEndereco().getId());
        ps.setInt(13, item.getAtivado());
        ps.setString(14, item.getDescricao());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Imovel item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setDate(1, item.getDataInclusao());
        ps.setDouble(2, item.getPreco());
        ps.setDouble(3, item.getTamanho());
        ps.setString(4, item.getSituacao());
        ps.setDate(5, item.getBaixaData());
        ps.setString(6, item.getBaixaMotivo());
        ps.setInt(7, item.getQuantidadeParcelas());
        ps.setDouble(8, item.getValorComissao());
        ps.setInt(9, item.getFuncionario().getId());
        ps.setInt(10, item.getPessoa().getId());
        ps.setInt(11, item.getTipoImovel().getId());
        ps.setInt(12, item.getEndereco().getId());
        ps.setInt(13, item.getAtivado());
        ps.setString(14, item.getDescricao());
        ps.setInt(15, item.getId());

        return ps;

    }

    @Override
    protected Imovel criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            int idImovel = rs.getInt(id);
            return new Imovel(
                    idImovel,
                    rs.getDate(vetorCampos[0]),
                    rs.getDouble(vetorCampos[1]),
                    rs.getDouble(vetorCampos[2]),
                    rs.getString(vetorCampos[3]),
                    rs.getDate(vetorCampos[4]),
                    rs.getString(vetorCampos[5]),
                    rs.getInt(vetorCampos[6]),
                    rs.getDouble(vetorCampos[7]),
                    funcionarioDao.getByID(rs.getInt(vetorCampos[8])),
                    pessoaDao.getByID(rs.getInt(vetorCampos[9])),
                    tipoImovelDao.getByID(rs.getInt(vetorCampos[10])),
                    enderecoDao.getByID(rs.getInt(vetorCampos[11])),
                    rs.getInt(vetorCampos[12]),
                    rs.getString(vetorCampos[13]),
                    imovelItemDao.getByIdImovel(idImovel)
            );

        }

        return null;

    }

}
