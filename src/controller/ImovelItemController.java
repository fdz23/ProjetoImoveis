/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelItemDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.ImovelItem;

/**
 *
 * @author fdz
 */
public class ImovelItemController extends Controller<ImovelItem> {

    public ImovelItemController() throws ClassNotFoundException, SQLException {

        dao = new ImovelItemDao();

    }
    
    @Override
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {
        //Pega o item ordenando por id em ordem crescente
        Iterator<ImovelItem> lista = dao.getAllOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            ImovelItem item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getValor()
                    });

        }

        return model;
        
    }
    
    public DefaultTableModel populaJTablePorIdImovel(DefaultTableModel model, int campo, int idImovel) throws ClassNotFoundException, SQLException, Exception {
        
        
        
        //Pega o item ordenando por id em ordem crescente
        Iterator<ImovelItem> lista = new ImovelItemDao().getByIdImovel(idImovel);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            ImovelItem item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getValor()
                    });

        }

        return model;
        
    }
}
