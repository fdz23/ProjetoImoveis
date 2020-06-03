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
import model.ImovelItem;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelItemDao extends Dao<ImovelItem> {
    
    private ItemMovelDao itemMovelDao = new ItemMovelDao();
    private ImovelDao imovelDao = new ImovelDao();
    
    public ImovelItemDao() throws ClassNotFoundException {

         Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL_ITEM");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "iit_valor,iit_iti_iden,iit_imo_iden";
        vetorCampos = campos.split(",");

    }
    
    public ImovelItem getByIdImovel(int idImovel) {

        try {

            ps = statementByIdImovel(idImovel);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByIdImovel(int idImovel) {

        try {

            ps = criaStatement.selectSql(tabela, true, "iit_imo_iden");

            ps.setInt(1, idImovel);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    @Override
    protected void verificaExistente(ImovelItem item) throws Exception {
    
        if (getByIdImovel(item.getImovel().getId()) != null)
            throw new Exception("Já existe um ImovelItem cadastrado para este imóvel.");
    
    }

    @Override
    protected PreparedStatement statementInserir(ImovelItem item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDouble(1, item.getValor());
            ps.setInt(2, item.getItemMovel().getId());
            ps.setInt(3, item.getImovel().getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected PreparedStatement statementAlterar(ImovelItem item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setDouble(1, item.getValor());
            ps.setInt(2, item.getItemMovel().getId());
            ps.setInt(3, item.getImovel().getId());
            ps.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    protected ImovelItem criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new ImovelItem(
                        rs.getInt(id), 
                        rs.getDouble(vetorCampos[0]), 
                        itemMovelDao.getByID(rs.getInt(vetorCampos[1])), 
                        imovelDao.getByID(rs.getInt(vetorCampos[2]))
                );

            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
