/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrcamentoDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Orcamento;
import util.CriaDate;

/**
 *
 * @author fdz
 */
public class OrcamentoController extends Controller<Orcamento> {

    public OrcamentoController() throws ClassNotFoundException, SQLException {

        dao = new OrcamentoDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Orcamento> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Orcamento item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        CriaDate.geraDataFormatadaSql(item.getData()),
                        item.getDescricao(),
                        item.getFuncionario().getNome(),
                        item.getPessoa().getNome(),
                        item.getImovel().getDescricao(),
                        item.getTipoPagamento().getDescricao()
                    });

        }
        
        return model;
        
    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Orcamento> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Orcamento> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Orcamento> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
}
