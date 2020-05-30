/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoImovelDao;
import java.sql.Connection;
import model.TipoImovel;

/**
 *
 * @author fdz
 */
public class TipoImovelController extends Controller<TipoImovel> {

    public TipoImovelController() throws ClassNotFoundException {

        dao = new TipoImovelDao();

    }
}
