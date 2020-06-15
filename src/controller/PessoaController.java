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
import util.CriaDate;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {
    
    private PessoaDao daoP;

    public PessoaController() throws ClassNotFoundException, SQLException {

        daoP = new PessoaDao();
        dao = new PessoaDao();

    }

    public Pessoa getPessoaPorCpf(String cpf) throws Exception {

        return daoP.getByCpf(cpf);
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Pessoa> lista = daoP.getAllClientesOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Pessoa item = lista.next();
                
            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        CriaDate.geraDataFormatadaSql(item.getDataNascimento()),
                        item.getCpf(),
                        item.getTelefone(),
                        item.getEndereco().getCep()
                    });

        }

        return model;

    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Pessoa> lista = daoP.getAllDoubleOrderBy(campo1, campo2, true, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Pessoa item = lista.next();
                
            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        CriaDate.geraDataFormatadaSql(item.getDataNascimento()),
                        item.getCpf(),
                        item.getTelefone(),
                        item.getEndereco().getCep()
                    });

        }

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Pessoa> lista = daoP.getAllClientesDesativadosOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Pessoa item = lista.next();
                
            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getNome(),
                        item.getEmail(),
                        CriaDate.geraDataFormatadaSql(item.getDataNascimento()),
                        item.getCpf(),
                        item.getTelefone(),
                        item.getEndereco().getCep()
                    });

        }

        return model;

    }
    
    public Iterator<Pessoa> getTodosClientes() throws Exception {
        
        return daoP.getAllClientes();
        
    }
    
    public boolean removerCliente(int id) throws Exception {
        
        return daoP.removeCliente(id);
        
    }
    
}
