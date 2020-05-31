/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContratoDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Contrato;

/**
 *
 * @author fdz
 */
public class ContratoController extends Controller<Contrato> {

    
    public ContratoController() throws ClassNotFoundException {
        
        dao = new ContratoDao( );
        
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Contrato> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Contrato item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getData(),
                        item.getDataAlteracao(),
                        item.getIdSituacao(),
                        item.getIdOrcamento()
                    });

        }

        return model;

    }
}
