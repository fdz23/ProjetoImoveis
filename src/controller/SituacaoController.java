/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SituacaoDao;
import model.Situacao;

/**
 *
 * @author fdz
 */
public class SituacaoController extends Controller<Situacao> {

    public SituacaoController() throws ClassNotFoundException {

        dao = new SituacaoDao();

    }
}
