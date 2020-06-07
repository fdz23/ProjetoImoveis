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

/**
 *
 * @author fdz
 */
public class ContratoController extends Controller<Contrato> {

    
    public ContratoController() throws ClassNotFoundException, SQLException {
        
        dao = new ContratoDao( );
        
    }
    
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {

        //Pega o item ordenando por id em ordem crescente
        Iterator<Contrato> lista = dao.getAllOrderBy(campo, true);

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
                        item.getData(),
                        item.getDataAlteracao(),
                        pago,
                        item.getOrcamento().getDescricao()
                    });

        }

        return model;

    }
}
