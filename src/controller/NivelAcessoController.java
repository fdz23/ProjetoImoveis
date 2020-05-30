/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelAcessoDao;
import java.sql.Connection;
import model.NivelAcesso;

/**
 *
 * @author fdz
 */
public class NivelAcessoController extends Controller<NivelAcesso> {

    public NivelAcessoController() throws ClassNotFoundException {

        dao = new NivelAcessoDao();

    }
}
