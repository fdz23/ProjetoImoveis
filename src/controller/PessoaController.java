/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {

    public PessoaController() throws ClassNotFoundException, SQLException {

        dao = new PessoaDao();

    }

    public Pessoa getPessoaPorCpf(String cpf) throws Exception {

        return new PessoaDao().getByCpf(cpf);
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Pessoa> lista = getTodosClientes();

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
    
    public Iterator<Pessoa> getTodosClientes() throws Exception {
        
        return new PessoaDao().getAllClientes();
        
    }
    
    public boolean removerCliente(int id) throws Exception {
        
        return new PessoaDao().removeCliente(id);
        
    }
    
}
