/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.TipoFuncionario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class TipoFuncionarioController extends Controller<TipoFuncionario> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psTipoFuncionario;

    public TipoFuncionarioController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }

    @Override
    public PreparedStatement statementInserir(TipoFuncionario item) {
        
        try {

            psTipoFuncionario = criaStatement.insertSql("tipo_funcionarios", "tfu_cargo,id_nia_nivel_acessos,tfu_salario,tfu_descricao");

            psTipoFuncionario.setString(1, item.getCargo());
            psTipoFuncionario.setInt(2, item.getIdNivelAcesso());
            psTipoFuncionario.setDouble(3, item.getSalario());
            psTipoFuncionario.setString(4, item.getDescricao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoFuncionario;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoFuncionario item) {
        
        try {

            psTipoFuncionario = criaStatement.updateSql("tipo_funcionarios", "tfu_cargo,id_nia_nivel_acessos,tfu_salario,tfu_descricao");

            psTipoFuncionario.setString(1, item.getCargo());
            psTipoFuncionario.setInt(2, item.getIdNivelAcesso());
            psTipoFuncionario.setDouble(3, item.getSalario());
            psTipoFuncionario.setString(4, item.getDescricao());
            psTipoFuncionario.setInt(5, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoFuncionario;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psTipoFuncionario = criaStatement.deleteSql("tipo_funcionarios");

            psTipoFuncionario.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psTipoFuncionario;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psTipoFuncionario = criaStatement.selectSql("tipo_funcionarios", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psTipoFuncionario;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psTipoFuncionario = criaStatement.selectSql("tipo_funcionarios", true, "id");
            
            psTipoFuncionario.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psTipoFuncionario;
    }

    @Override
    public TipoFuncionario criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoFuncionario(
                        rs.getInt("id"), 
                        rs.getString("tfu_cargo"), 
                        rs.getInt("id_nia_nivel_acessos"), 
                        rs.getDouble("tfu_salario"), 
                        rs.getString("tfu_descricao")
                );

            } else
                throw new Exception("TipoFuncionario não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
