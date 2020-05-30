/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.sql.Connection;
import model.Funcionario;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {

    public FuncionarioController(Connection con) {
        
        super(con);
        dao = new FuncionarioDao(con);
        
    }
}