/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RelatoriosDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fdz
 */
public class RelatoriosController {
    
    private RelatoriosDao dao;
    
    public RelatoriosController() throws SQLException {
        
        dao = new RelatoriosDao();
        
    }
    
    public DefaultTableModel populaImoveisByFuncionario(DefaultTableModel model, int idFuncionario) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Object[]> lista = dao.getImoveisByFuncionario(idFuncionario);

        model.setNumRows(0);

        while (lista.hasNext()) {
                
            model.addRow(lista.next());

        }

        return model;

    }
}
