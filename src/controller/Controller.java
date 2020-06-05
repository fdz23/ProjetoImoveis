/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
import java.util.Iterator;
/**
 *
 * @author fdz
 */
public abstract class Controller<T> implements IController<T> {
    
    protected Dao<T> dao;
    
    @Override
    public boolean inserirItem(T item) throws Exception {
        
        return dao.inserir(item);
        
    }

    @Override
    public boolean alterarItem(T item) throws Exception {
        
        return dao.alterar(item);
        
    }

    @Override
    public boolean deletarItem(int id) throws Exception {
        
        return dao.deletar(id);
        
    }

    @Override
    public Iterator<T> getTodosItens() throws Exception {
        
        return dao.getAll();
        
    }

    @Override
    public T getItem(int id) throws Exception {
        
        return dao.getByID(id);
        
    }
    
    
}
