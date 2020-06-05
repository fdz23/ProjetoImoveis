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
import model.ImovelItem;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelItemDao extends Dao<ImovelItem> {

    private ItemMovelDao itemMovelDao = new ItemMovelDao();
    private ImovelDao imovelDao = new ImovelDao();

    public ImovelItemDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL_ITEM");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "iit_valor,iit_iti_iden,iit_imo_iden";
        vetorCampos = campos.split(",");

    }

    public ImovelItem getByIdImovel(int idImovel) throws Exception {

        ps = statementByIdImovel(idImovel);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementByIdImovel(int idImovel) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "iit_imo_iden");

        ps.setInt(1, idImovel);

        return ps;
    }

    @Override
    protected void verificaExistenteInserir(ImovelItem item) throws Exception {

        if (getByIdImovel(item.getImovel().getId()) != null) {
            throw new Exception("Já existe um ImovelItem cadastrado para este imóvel.");
        }

    }

    @Override
    protected void verificaExistenteAlterar(ImovelItem item) throws Exception {

        if (getByIdImovel(item.getImovel().getId()) != null && getByIdImovel(item.getImovel().getId()).getId() != getByID(item.getId()).getImovel().getId()) {
            throw new Exception("Já existe um ImovelItem cadastrado para este imóvel.");
        }

    }

    @Override
    protected PreparedStatement statementInserir(ImovelItem item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setDouble(1, item.getValor());
        ps.setInt(2, item.getItemMovel().getId());
        ps.setInt(3, item.getImovel().getId());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(ImovelItem item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setDouble(1, item.getValor());
        ps.setInt(2, item.getItemMovel().getId());
        ps.setInt(3, item.getImovel().getId());
        ps.setInt(5, item.getId());

        return ps;

    }

    @Override
    protected ImovelItem criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new ImovelItem(
                    rs.getInt(id),
                    rs.getDouble(vetorCampos[0]),
                    itemMovelDao.getByID(rs.getInt(vetorCampos[1])),
                    imovelDao.getByID(rs.getInt(vetorCampos[2]))
            );

        }

        return null;

    }

}
