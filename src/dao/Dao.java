/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;
import util.CriaStatement;
import util.ConectaDb;

/**
 *
 * @author fdz
 */
public abstract class Dao<T> implements IDao<T> {

    protected Connection con;
    protected ResultSet rs;
    protected CriaStatement criaStatement;
    protected PreparedStatement ps;
    protected String id;
    protected String tabela;
    protected String campos;
    protected String[] vetorCampos;

    public Dao() throws ClassNotFoundException {

        this.con = ConectaDb.conectadb();
        rs = null;

    }
    
    protected abstract PreparedStatement statementInserir(T item);
    protected abstract PreparedStatement statementAlterar(T item);
    protected abstract T criaItem(ResultSet rs);
    protected abstract void verificaExistente(T item) throws Exception;
    
    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    public Iterator<T> getTodosItensOrdenadosDuplamentePor(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception {
        
        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo1 < 0 || campo1 > (vetorCampos.length - 1))
            throw new Exception("Campo1 para ser ordenado inexistente.");
        if (campo2 < 0 || campo2 > (vetorCampos.length - 1))
            throw new Exception("Campo2 para ser ordenado inexistente.");
        
        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        String coluna1 = vetorCampos[campo1];
        String coluna2 = vetorCampos[campo2];
        
        //estrutura de dados 1 : Fila de prioridade
        Queue<T> itens = new PriorityQueue<T>();

        try {

            //cria um sql que recebe todos os itens ordenados conforme duas colunas
            ps = criaStatement.selectSqlOrderDupla(tabela, coluna1, coluna2, ascOuDesc1, ascOuDesc2);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                itens.add(getByID(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }
    
    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    public Iterator<T> getTodosItensOrdenadosPor(int campo, boolean ascOuDesc) throws Exception {
        
        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length)
            throw new Exception("Campo para ser ordenado inexistente.");
        
        String coluna = "";
        
        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (campo == 0)
             coluna = id;
        else
            coluna = vetorCampos[campo - 1];
        
        //estrutura de dados 2 : Lista encadeada
        List<T> itens = new LinkedList<T>();

        try {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlOrder(tabela, coluna, ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                itens.add(getByID(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }
    
    protected PreparedStatement statementDeletar(int id) {
         
        try {

            //cria um sql para deletar um item conforme seu id
            ps = criaStatement.deleteSql();

            ps.setInt(1, id);
            
            return ps;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
            
    }
    
    protected PreparedStatement statementGetTodos() {
        
        try {

            //cria um sql para selecionar todos os itens
            ps = criaStatement.selectSql(tabela, false, null);

            return ps;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return null;
    }
    
    protected PreparedStatement statementGetItem(int id) {
        
        try {

            //cria um sql para seleciona o item que possue esse id
            ps = criaStatement.selectSql(tabela, true, this.id);
            
            ps.setInt(1, id);

            return ps;
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return null;

    }

    //comenta!
    @Override
    public boolean inserir(T item) {

        try {
            
            verificaExistente(item);

            //cria um sql para inserir o item
            ps = statementInserir(item);

            ps.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean alterar(T item) {

        try {
            
            verificaExistente(item);

            //cria um sql para alterar o item
            ps = statementAlterar(item);

            ps.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean deletar(int id) {

        try {

            //cria um sql para deletar o item
            ps = statementDeletar(id);

            ps.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public Iterator<T> getAll() {

        //estrutura de dados 3 : pilha
        List<T> itens = new Stack<T>();

        try {

            ps = statementGetTodos();

            rs = ps.executeQuery();

            while (rs.next()) {

                itens.add(getByID(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }

    @Override
    public T getByID(int id) {

        try {

            ps = statementGetItem(id);

            ResultSet rs = ps.executeQuery();
            
            T item = criaItem(rs);

            if (item == null)
                throw new Exception("Erro ao encontrar um item " + item.getClass().getName());
            
            return item;
                

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

}
