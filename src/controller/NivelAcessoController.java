/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelAcessoDao;
import java.sql.Connection;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;

/**
 *
 * @author fdz
 */
public class NivelAcessoController extends Controller<NivelAcesso> {

    public NivelAcessoController() throws ClassNotFoundException {

        dao = new NivelAcessoDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<NivelAcesso> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            NivelAcesso item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao()
                    });

        }

        return model;

    }
    
}
