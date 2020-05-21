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

    private Connection con;
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement preparedStatement;

    public Controller(Connection con) {

        this.con = con;
        this.criaStatement = new CriaStatement(con);
        rs = null;

    }
    
    public abstract PreparedStatement statementInserir(T item);
    public abstract PreparedStatement statementAlterar(T item);
    public abstract PreparedStatement statementDeletar(int id);
    public abstract PreparedStatement statementGetTodos();
    public abstract PreparedStatement statementGetItem(int id);
    public abstract T criaItem(ResultSet rs);

    //comenta!
    @Override
    public boolean inserirItem(T item) {

        try {

            preparedStatement = statementInserir(item);

            preparedStatement.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean alterarItem(T item) {

        try {

            preparedStatement = statementAlterar(item);

            preparedStatement.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean deletarItem(int id) {

        try {

            preparedStatement = statementDeletar(id);

            preparedStatement.executeUpdate();

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

            preparedStatement = statementGetTodos();

            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                itens.add(getItem(rs.getInt("id")));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }

    @Override
    public T getItem(int id) {

        try {

            preparedStatement = statementGetItem(id);

            rs = preparedStatement.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

}
