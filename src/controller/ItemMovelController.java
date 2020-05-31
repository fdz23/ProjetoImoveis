/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemMovelDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.ItemMovel;

/**
 *
 * @author fdz
 */
public class ItemMovelController extends Controller<ItemMovel> {

    public ItemMovelController() throws ClassNotFoundException {

        dao = new ItemMovelDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<ItemMovel> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            ItemMovel item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao()
                    });

        }

        return model;

    }
    
}
