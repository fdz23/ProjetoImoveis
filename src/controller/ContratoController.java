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
import javax.swing.JOptionPane;
import model.Contrato;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ContratoController implements IController<Contrato> {

    private Connection con;
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psContrato;

    public ContratoController(Connection con) {

        this.con = con;
        this.criaStatement = new CriaStatement(con);
        rs = null;

    }

    //comenta!
    @Override
    public boolean inserirItem(Contrato item) {

        try {

            psContrato = criaStatement.insertSql("contrato", "idorcamento,status");

            psContrato.setInt(1, item.getIdOrcamento());
            psContrato.setString(2, item.getStatus());

            psContrato.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean alterarItem(Contrato item) {

        try {

            psContrato = criaStatement.updateSql("contrato", "idorcamento,status");

            psContrato.setInt(1, item.getIdOrcamento());
            psContrato.setString(2, item.getStatus());
            psContrato.setInt(3, item.getId());

            psContrato.executeUpdate();

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public boolean deletarItem(int id) {

        try {

            psContrato = criaStatement.deleteSql("contrato");

            psContrato.setInt(1, id);

            psContrato.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }

        return true;

    }

    @Override
    public Iterator<Contrato> getTodosItens() {

        List<Contrato> contratos = new ArrayList<Contrato>();

        try {

            psContrato = criaStatement.selectSql("cliente", false, null);

            rs = psContrato.executeQuery();

            while (rs.next()) {

                contratos.add(getItem(rs.getInt("id")));

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return contratos.iterator();

    }

    @Override
    public Contrato getItem(int id) {

        Contrato contrato = new Contrato();

        try {

            psContrato = criaStatement.selectSql("contrato", true, "id");

            rs = psContrato.executeQuery();

            if (rs.next()) {

                contrato = new Contrato(rs.getInt("id"), rs.getInt("idorcamento"), rs.getString("status"));

            } else
                throw new Exception("Contrato não encontrado");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return contrato;

    }

}
