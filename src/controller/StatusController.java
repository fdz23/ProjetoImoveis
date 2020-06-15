/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Status;

/**
 *
 * @author fdz
 */
public class StatusController extends Controller<Status> {

    public StatusController() throws ClassNotFoundException, SQLException {

        dao = new StatusDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Status> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {

            Status item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),});

        }
        
        return model;
        
    }

    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        Iterator<Status> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);
        
        return model;

    }

    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        Iterator<Status> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);
        
        return model;

    }

    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        Iterator<Status> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);
        
        return model;

    }
}
