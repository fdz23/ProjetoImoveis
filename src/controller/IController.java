package controller;

import java.util.Iterator;

public interface IController<T> {

    public boolean inserirItem(T item) throws Exception;
    public boolean alterarItem(T item) throws Exception;
    public boolean deletarItem(int id) throws Exception;
    public Iterator<T> getTodosItens() throws Exception;
    public T getItem(int id) throws Exception;
    
}