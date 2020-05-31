/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDao;
import model.Status;

/**
 *
 * @author fdz
 */
public class StatusController extends Controller<Status> {

    public StatusController() throws ClassNotFoundException {

        dao = new StatusDao();

    }
}
