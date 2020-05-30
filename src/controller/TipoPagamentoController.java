/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoPagamentoDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.TipoPagamento;

/**
 *
 * @author fdz
 */
public class TipoPagamentoController extends Controller<TipoPagamento> {

    public TipoPagamentoController() throws ClassNotFoundException {
        
       dao = new TipoPagamentoDao();
        
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        Iterator<TipoPagamento> lista = dao.getAll();

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