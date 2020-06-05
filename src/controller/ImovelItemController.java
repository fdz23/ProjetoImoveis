/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelItemDao;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.ImovelItem;

/**
 *
 * @author fdz
 */
public class ImovelItemController extends Controller<ImovelItem> {

    public ImovelItemController() throws ClassNotFoundException, SQLException {

        dao = new ImovelItemDao();

    }
    
    @Override
    public DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception {
    
        return null;
        
    }
}
