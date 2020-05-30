/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoFuncionarioDao;
import java.sql.Connection;
import model.TipoFuncionario;

/**
 *
 * @author fdz
 */
public class TipoFuncionarioController extends Controller<TipoFuncionario> {

    public TipoFuncionarioController(Connection con) {
        
        super(con);
        dao = new TipoFuncionarioDao(con);
        
    }
}