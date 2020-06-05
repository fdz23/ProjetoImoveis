/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoPagamentoDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.TipoPagamento;

/**
 *
 * @author fdz
 */
public class TipoPagamentoController extends Controller<TipoPagamento> {

    public TipoPagamentoController() throws ClassNotFoundException, SQLException {
        
       dao = new TipoPagamentoDao();
        
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoPagamento> lista = dao.getAllOrderBy(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            TipoPagamento item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao()
                    });

        }

        return model;

    }
    
}