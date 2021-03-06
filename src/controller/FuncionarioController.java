/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import util.CriaDate;
import util.Login;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {

    public FuncionarioController() throws ClassNotFoundException, SQLException {

        dao = new FuncionarioDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Funcionario> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Funcionario item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getMatricula(),
                        item.getNome(),
                        item.getTipoFuncionario().getDescricao(),
                        item.getStatus().getDescricao(),
                        CriaDate.geraDataFormatadaSql(item.getDataRescisao())
                    });

        }
        
        return model;
        
    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Funcionario> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Funcionario> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Funcionario> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public Funcionario login(String email, String senha) throws Exception {
        
        Funcionario funcionario = new FuncionarioDao().verificaEmail(email);
        
        if (funcionario == null)
            throw new Exception("E-mail incorreto.");
        else {
            if(new UsuarioDao().verificaSenha(funcionario, senha)) {
                return Login.funcionario = funcionario;
            }
            else
                throw new Exception("Senha incorreta.");
        }
        
        
    }
    
    public Funcionario getItemByEmail(String email) throws Exception {
        
        return new FuncionarioDao().verificaEmail(email);
        
    }
}
