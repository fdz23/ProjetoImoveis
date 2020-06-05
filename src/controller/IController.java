package controller;

import java.util.Iterator;

public interface IController<T> {

    public boolean inserirItem(T item) throws Exception;
    public boolean alterarItem(T item) throws Exception;
    public boolean deletarItem(int id) throws Exception;
    public Iterator<T> getTodosItens() throws Exception;
    public T getItem(int id) throws Exception;
    public Iterator<T> getTodosItensOrdenadosDuplamentePor(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception;
    public Iterator<T> getTodosItensOrdenadosPor(int campo, boolean ascOuDesc) throws Exception;
    
}