/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrcamentoDao;
import java.sql.Connection;
import model.Orcamento;

/**
 *
 * @author fdz
 */
public class OrcamentoController extends Controller<Orcamento> {

    public OrcamentoController(Connection con) {
        
        super(con);
        dao = new OrcamentoDao(con);
        
    }
}