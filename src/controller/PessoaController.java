/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {

    public PessoaController() throws ClassNotFoundException {

        dao = new PessoaDao();

    }

    public Pessoa getPessoaPorCpf(String cpf) throws ClassNotFoundException {

        return new PessoaDao().getByCpf(cpf);
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Pessoa> lista = dao.getTodosItensOrdenadosPor(0, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Pessoa item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        item.getDataNascimento(),
                        item.getCpf(),
                        item.getTelefone()
                    });

        }

        return model;

    }
    
}
