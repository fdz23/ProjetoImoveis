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
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<TipoPagamento> lista) {
        
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
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoPagamento> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoPagamento> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoPagamento> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
}