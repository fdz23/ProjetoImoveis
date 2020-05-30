/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelDao;
import java.sql.Connection;
import model.Imovel;

/**
 *
 * @author fdz
 */
public class ImovelController extends Controller<Imovel> {

    public ImovelController(Connection con) {
        
        super(con);
        dao = new ImovelDao(con);
        
    }
}