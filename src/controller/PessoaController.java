/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PessoaDao;
import java.sql.Connection;
import model.Pessoa;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {

    public PessoaController(Connection con) {
        
        super(con);
        dao = new PessoaDao(con);
        
    }
    
    public Pessoa getPessoaPorCpf(String cpf) {
        
        return new PessoaDao(con).getByCpf(cpf);
    }
}