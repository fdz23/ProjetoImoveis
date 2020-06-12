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
    private DefaultTableModel model;
    
    public RelatoriosController(DefaultTableModel model) throws SQLException {
        
        dao = new RelatoriosDao();
        this.model = model;
        
    }
    
    public DefaultTableModel populaImoveisPorFuncionario(int idFuncionario) throws Exception {

        return populaJTable(dao.getImoveisByFuncionario(idFuncionario));

    }
    
    public DefaultTableModel populaJTable(Iterator<Object[]> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
                
            model.addRow(lista.next());

        }

        return model;
        
    }
}
