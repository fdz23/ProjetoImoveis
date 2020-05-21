package controller;

import java.util.Iterator;

public interface IController<T> {

    public boolean inserirItem(T item);
    public boolean alterarItem(T item);
    public boolean deletarItem(int id);
    public Iterator<T> getTodosItens();
    public T getItem(int id);
    
}