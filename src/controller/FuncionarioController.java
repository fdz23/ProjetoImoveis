/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {

    public FuncionarioController() throws ClassNotFoundException, SQLException {

        dao = new FuncionarioDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Funcionario> lista = dao.getAllOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Funcionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getMatricula(),
                        item.getTipoFuncionario().getDescricao(),
                        item.getStatus().getDescricao(),
                        item.getDataRescisao()
                    });

        }

        return model;

    }
}
