/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelAcessoDao;
import dao.TipoFuncionarioDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.NivelAcesso;
import model.TipoFuncionario;

public class TipoFuncionarioController extends Controller<TipoFuncionario> {

    public TipoFuncionarioController() throws ClassNotFoundException, SQLException {

        dao = new TipoFuncionarioDao();

    }

    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoFuncionario> lista = dao.getAllOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {

            TipoFuncionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getNivelAcesso().getDescricao(),
                        item.getSalario()
                    });

        }

        return model;

    }

    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<TipoFuncionario> lista = dao.getAllDeactivatedOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {

            TipoFuncionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getNivelAcesso().getDescricao(),
                        item.getSalario()
                    });

        }

        return model;

    }

}
