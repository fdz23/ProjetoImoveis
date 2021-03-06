/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelAcessoDao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;

/**
 *
 * @author fdz
 */
public class NivelAcessoController extends Controller<NivelAcesso> {

    public NivelAcessoController() throws ClassNotFoundException, SQLException {

        dao = new NivelAcessoDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<NivelAcesso> lista) {
        
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

    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<NivelAcesso> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }

    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<NivelAcesso> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }

    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<NivelAcesso> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public Array getArrayInt(Integer[] array) throws SQLException, ClassNotFoundException {
        return new NivelAcessoDao().getArrayFromInt(array);
    }

}
