/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Imovel;
import util.CriaDate;

/**
 *
 * @author fdz
 */
public class ImovelController extends Controller<Imovel> {

    public ImovelController() throws ClassNotFoundException, SQLException {

        dao = new ImovelDao();

    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Imovel> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Imovel item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDataInclusao(),
                        item.getPreco(),
                        item.getTamanho(),
                        item.getSituacao(),
                        CriaDate.geraDataFormatadaSql(item.getBaixaData()),
                        item.getBaixaMotivo(),
                        item.getQuantidadeParcelas(),
                        item.getValorComissao(),
                        item.getFuncionario().getNome(),
                        item.getPessoa().getNome(),
                        item.getTipoImovel().getDescricao(),
                        item.getEndereco().getCep(),
                        item.getDescricao()
                    });

        }
        
        return model;
        
    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Imovel> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Imovel> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Imovel> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
}
