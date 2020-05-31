/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {

    public FuncionarioController() throws ClassNotFoundException {

        dao = new FuncionarioDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Funcionario> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Funcionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        item.getDataNascimento(),
                        item.getCpf(),
                        item.getTelefone(),
                        item.getMatricula(),
                        item.getDataRescisao()
                    });

        }

        return model;

    }
}
