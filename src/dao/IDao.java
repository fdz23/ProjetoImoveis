/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Iterator;

/**
 *
 * @author fdz
 */
public interface IDao<T> {

    public boolean inserir(T item);
    public boolean alterar(T item);
    public boolean deletar(int id);
    public Iterator<T> getAll();
    public T getByID(int id);
    
}
