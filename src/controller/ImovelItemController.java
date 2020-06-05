/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelItemDao;
import java.sql.SQLException;
import model.ImovelItem;

/**
 *
 * @author fdz
 */
public class ImovelItemController extends Controller<ImovelItem> {

    public ImovelItemController() throws ClassNotFoundException, SQLException {

        dao = new ImovelItemDao();

    }
}
