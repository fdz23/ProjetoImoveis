/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContratoDao;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Contrato;
import util.CriaDate;

/**
 *
 * @author fdz
 */
public class ContratoController extends Controller<Contrato> {

    
    public ContratoController() throws ClassNotFoundException, SQLException {
        
        dao = new ContratoDao( );
        
    }
    
    private DefaultTableModel setModel(DefaultTableModel model, Iterator<Contrato> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
            
            Contrato item = lista.next();
            
            String pago = "";
            
            if(item.getPago() == 0)
                pago = "Aguardando pagamento";
            else if(item.getPago() == 1)
                pago = "Pago";
            else
                pago = "Financiado";

            model.addRow(
                    new Object[]{
                        item.getId(),
                        CriaDate.geraDataFormatadaSql(item.getData()),
                        CriaDate.geraDataFormatadaSql(item.getDataAlteracao()),
                        pago,
                        item.getOrcamento().getDescricao()
                    });

        }
        
        return model;
        
    }
    
    public DefaultTableModel populaJTableDupla(DefaultTableModel model, int campo1, int campo2) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Contrato> lista = dao.getAllDoubleOrderBy(campo1, campo2, true, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Contrato> lista = dao.getAllOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
    
    public DefaultTableModel populaJTableDesativados(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Contrato> lista = dao.getAllDeactivatedOrderBy(campo, true);

        setModel(model, lista);

        return model;

    }
}
