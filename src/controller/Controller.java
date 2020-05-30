/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IDao;
import java.sql.Connection;
import java.util.Iterator;
import util.ConectaDb;
/**
 *
 * @author fdz
 */
public abstract class Controller<T> implements IController<T> {
    
    protected Connection con;
    protected IDao<T> dao;

    protected Controller() throws ClassNotFoundException {
        
        this.con = ConectaDb.conectadb();
        
    }

    @Override
    public boolean inserirItem(T item) {
        
        return dao.inserir(item);
        
    }

    @Override
    public boolean alterarItem(T item) {
        
        return dao.alterar(item);
        
    }

    @Override
    public boolean deletarItem(int id) {
        
        return dao.deletar(id);
        
    }

    @Override
    public Iterator<T> getTodosItens() {
        
        return dao.getAll();
        
    }

    @Override
    public T getItem(int id) {
        
        return dao.getByID(id);
        
    }
    
    
}
