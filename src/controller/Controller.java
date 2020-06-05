/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author fdz
 */
public abstract class Controller<T> implements IController<T> {
    
    protected Dao<T> dao;
    
    public Iterator<T> getTodosItensOrdenadosDuplamentePor(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception {
        
        return dao.getAllDoubleOrderBy(campo1, campo2, ascOuDesc1, ascOuDesc2);
        
    }
    
    public Iterator<T> getTodosItensOrdenadosPor(int campo, boolean ascOuDesc) throws Exception {
        
        return dao.getAllOrderBy(campo, ascOuDesc);
        
    }
    
    @Override
    public boolean inserirItem(T item) throws Exception {
        
        return dao.insert(item);
        
    }

    @Override
    public boolean alterarItem(T item) throws Exception {
        
        return dao.update(item);
        
    }

    @Override
    public boolean deletarItem(int id) throws Exception {
        
        return dao.delete(id);
        
    }

    @Override
    public Iterator<T> getTodosItens() throws Exception {
        
        return dao.getAll();
        
    }

    @Override
    public T getItem(int id) throws Exception {
        
        return dao.getByID(id);
        
    }
    
    public abstract DefaultTableModel populaJTable(DefaultTableModel model, int campo) throws Exception;
    
}
