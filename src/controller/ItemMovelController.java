/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemMovelDao;
import java.sql.Connection;
import model.ItemMovel;

/**
 *
 * @author fdz
 */
public class ItemMovelController extends Controller<ItemMovel> {

    public ItemMovelController(Connection con) throws ClassNotFoundException {

        dao = new ItemMovelDao();

    }
}
