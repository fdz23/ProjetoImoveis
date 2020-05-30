/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDao;
import java.sql.Connection;
import model.Endereco;

/**
 *
 * @author fdz
 */
public class EnderecoController extends Controller<Endereco> {

    public EnderecoController(Connection con) {
        
        super(con);
        dao = new EnderecoDao(con);
        
    }
}