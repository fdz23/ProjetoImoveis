/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Endereco;

/**
 *
 * @author fdz
 */
public class EnderecoController extends Controller<Endereco> {

    public EnderecoController() throws ClassNotFoundException, SQLException {

        dao = new EnderecoDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Endereco> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Endereco item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getCodigoIBGE(),
                        item.getLogradouro(),
                        item.getBairro(),
                        item.getCidade(),
                        item.getEstado(),
                        item.getComplemento(),
                        item.getNumero(),
                        item.getPontoReferencia(),
                        item.getCep()
                    });

        }
        
        return model;
        
    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Endereco> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Endereco> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Endereco> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
}
