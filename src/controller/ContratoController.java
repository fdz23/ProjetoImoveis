/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContratoDao;
import java.sql.Connection;
import model.Contrato;

/**
 *
 * @author fdz
 */
public class ContratoController extends Controller<Contrato> {

    
    public ContratoController() throws ClassNotFoundException {
        
         
        dao = new ContratoDao( );
        
    }
}
