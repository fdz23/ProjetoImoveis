/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrcamentoDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Orcamento;

/**
 *
 * @author fdz
 */
public class OrcamentoController extends Controller<Orcamento> {

    public OrcamentoController() throws ClassNotFoundException, SQLException {

        dao = new OrcamentoDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Orcamento> lista = dao.getAllOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Orcamento item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getData(),
                        item.getDescricao()
                    });

        }

        return model;

    }
    
}
