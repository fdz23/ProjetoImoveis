/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import model.Contrato;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public abstract class Controller<T> implements IController<T> {

    protected Connection con;
    protected ResultSet rs;
    protected CriaStatement criaStatement;
    protected PreparedStatement ps;
    protected String id;
    protected String tabela;
    protected String campos;
    protected String[] vetorCampos;

    public Controller(Connection con) {

        this.con = con;
        rs = null;

    }
    
    //campo em maísculo exatamente igual às propriedades da classe || true para ordem ascendente e false para descendente
    public Iterator<T> getTodosItensOrdenadosDuplamentePor(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception {
        
        if (campo1 < 0 || campo1 > (vetorCampos.length - 1))
            throw new Exception("Campo1 para ser ordenado inexistente.");
        if (campo2 < 0 || campo2 > (vetorCampos.length - 1))
            throw new Exception("Campo2 para ser ordenado inexistente.");
        
        String coluna1 = vetorCampos[campo1];
        String coluna2 = vetorCampos[campo2];
        
        List<T> itens = new ArrayList<T>();

        try {

            ps = criaStatement.selectSqlOrderDupla(tabela, coluna1, coluna2, ascOuDesc1, ascOuDesc2);

            rs = ps.executeQuery();

            while (rs.next()) {

                itens.add(getItem(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }
    
    //campo em maísculo exatamente igual às propriedades da classe || true para ordem ascendente e false para descendente
    public Iterator<T> getTodosItensOrdenadosPor(int campo, boolean ascOuDesc) throws Exception {
        
        if (campo < 0 || campo > (vetorCampos.length - 1))
            throw new Exception("Campo para ser ordenado inexistente.");
        
        String coluna = vetorCampos[campo];
        
        List<T> itens = new LinkedList<T>();

        try {

            ps = criaStatement.selectSqlOrder(tabela, coluna, ascOuDesc);

            rs = ps.executeQuery();

            while (rs.next()) {

                itens.add(getItem(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }

    
    public abstract PreparedStatement statementInserir(T item);
    public abstract PreparedStatement statementAlterar(T item);
    
    public PreparedStatement statementDeletar(int id) {
         
        try {

            ps = criaStatement.deleteSql();

            ps.setInt(1, id);
            
            return ps;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
            
    }
    
    public PreparedStatement statementGetTodos() {
        
        try {

            ps = criaStatement.selectSql(tabela, false, null);

            return ps;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return null;
    }
    
    public PreparedStatement statementGetItem(int id) {
        
        try {

            ps = criaStatement.selectSql(tabela, true, this.id);
            
            ps.setInt(1, id);

            return ps;
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return null;

    }
    public abstract T criaItem(ResultSet rs);

    //comenta!
    @Override
    public boolean inserirItem(T item) {

        try {

            ps = statementInserir(item);

            ps.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean alterarItem(T item) {

        try {

            ps = statementAlterar(item);

            ps.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean deletarItem(int id) {

        try {

            ps = statementDeletar(id);

            ps.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public Iterator<T> getTodosItens() {

        List<T> itens = new Stack<T>();

        try {

            ps = statementGetTodos();

            rs = ps.executeQuery();

            while (rs.next()) {

                itens.add(getItem(rs.getInt(id)));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }

    @Override
    public T getItem(int id) {

        try {

            ps = statementGetItem(id);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

}
