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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.ImovelItem;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelItemDao extends Dao<ImovelItem> {

    public ImovelItemDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL_ITEM");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "iit_valor,iit_descricao,iit_imo_iden,iit_ativado";
        vetorCampos = campos.split(",");

    }

    public Iterator<ImovelItem> getByIdImovel(int idImovel) throws Exception {

        List<ImovelItem> itens = new ArrayList<ImovelItem>();
        
        ps = statementByIdImovel(idImovel);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            itens.add(getByID(rs.getInt(id)));

        }

        return itens.iterator();

    }

    public Iterator<ImovelItem> getByIdImovelDesativado(int idImovel) throws Exception {

        List<ImovelItem> itens = new ArrayList<ImovelItem>();
        
        ps = statementByIdImovel(idImovel);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            itens.add(getByID(rs.getInt(id)));

        }

        return itens.iterator();

    }

    protected PreparedStatement statementByIdImovelDesativado(int idImovel) throws Exception {

        ps = criaStatement.selectSqlDesativado(tabela, true, "iit_imo_iden");

        ps.setInt(1, idImovel);

        return ps;
    }

    protected PreparedStatement statementByIdImovel(int idImovel) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "iit_imo_iden");

        ps.setInt(1, idImovel);

        return ps;
    }

    @Override
    protected PreparedStatement statementInserir(ImovelItem item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setDouble(1, item.getValor());
        ps.setString(2, item.getDescricao());
        ps.setInt(3, item.getImovel());
        ps.setInt(4, item.getAtivado());

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(ImovelItem item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setDouble(1, item.getValor());
        ps.setString(2, item.getDescricao());
        ps.setInt(3, item.getImovel());
        ps.setInt(4, item.getAtivado());
        ps.setInt(5, item.getId());

        return ps;

    }

    @Override
    protected ImovelItem criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new ImovelItem(
                    rs.getInt(id),
                    rs.getDouble(vetorCampos[0]),
                    rs.getString(vetorCampos[1]),
                    rs.getInt(vetorCampos[2]),
                    rs.getInt(vetorCampos[3])
            );

        }

        return null;

    }

    @Override
    protected void verificaExistenteInserir(ImovelItem item) throws Exception {
    }

    @Override
    protected void verificaExistenteAlterar(ImovelItem item) throws Exception {
    }

}
