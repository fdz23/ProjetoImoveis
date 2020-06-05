/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SituacaoDao;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Situacao;

/**
 *
 * @author fdz
 */
public class SituacaoController extends Controller<Situacao> {

    public SituacaoController() throws ClassNotFoundException, SQLException {

        dao = new SituacaoDao();

    }
    
    @Override
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {
    
        return null;
        
    }
}
