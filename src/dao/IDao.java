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

    public boolean insert(T item) throws Exception;
    public boolean update(T item) throws Exception;
    public boolean deactivate(int id) throws Exception;
    public boolean activate(int id) throws Exception;
    public Iterator<T> getAll() throws Exception;
    public Iterator<T> getAllDoubleOrderBy(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception;
    public Iterator<T> getAllOrderBy(int campo, boolean ascOuDesc) throws Exception;
    public Iterator<T> getAllDeactivatedOrderBy(int campo, boolean ascOuDesc) throws Exception;
    public T getByID(int id) throws Exception;
    
}
