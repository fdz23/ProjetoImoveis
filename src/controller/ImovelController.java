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

/**
 *
 * @author fdz
 */
public class ImovelController extends Controller<Imovel> {

    public ImovelController() throws ClassNotFoundException, SQLException {

        dao = new ImovelDao();

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Imovel> lista = dao.getAllOrderBy(campo, true);

        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Imovel item = lista.next();

            model.addRow(
                    new Object[]{
                        item.getId(),
                        item.getDescricao(),
                        item.getPreco(),
                        item.getTamanho(),
                        item.getBaixaData(),
                        item.getBaixaMotivo(),
                        item.getQuantidadeParcelas(),
                        item.getValorComissao(),
                        item.getPessoa().getNome(),
                        item.getAtivado()
                    });

        }

        return model;

    }
}
