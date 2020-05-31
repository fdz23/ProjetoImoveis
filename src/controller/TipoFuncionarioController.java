/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoFuncionarioDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.TipoFuncionario;

/**
 *
 * @author fdz
 */
public class TipoFuncionarioController extends Controller<TipoFuncionario> {

    public TipoFuncionarioController() throws ClassNotFoundException {

        dao = new TipoFuncionarioDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoFuncionario> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            TipoFuncionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getSalario()
                    });

        }

        return model;

    }
    
}
