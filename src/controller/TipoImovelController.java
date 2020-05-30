/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoImovelDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.TipoImovel;

/**
 *
 * @author fdz
 */
public class TipoImovelController extends Controller<TipoImovel> {

    public TipoImovelController() throws ClassNotFoundException {

        dao = new TipoImovelDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        Iterator<TipoImovel> lista = dao.getAll();

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            TipoImovel item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao()
                    });

        }

        return model;

    }
    
}
