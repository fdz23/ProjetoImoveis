/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Status;

/**
 *
 * @author fdz
 */
public class StatusController extends Controller<Status> {

    public StatusController() throws ClassNotFoundException {

        dao = new StatusDao();

    }

    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        Iterator<Status> lista = dao.getAll();

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
}
