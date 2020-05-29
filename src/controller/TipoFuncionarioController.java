/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fabricas.AbstractFactory;
import interfaces.Tabela;
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
        
        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("TIPO_FUNCIONARIO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);

    }

    @Override
    public PreparedStatement statementInserir(TipoFuncionario item) {
        
        try {

            psTipoFuncionario = criaStatement.insertSql(tabela, "tfu_descricao,tfu_nac_iden,tfu_salario");

            psTipoFuncionario.setString(1, item.getDescricao());
            psTipoFuncionario.setInt(2, item.getIdNivelAcesso());
            psTipoFuncionario.setDouble(3, item.getSalario());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoFuncionario;
        
    }

    @Override
    public PreparedStatement statementAlterar(TipoFuncionario item) {
        
        try {

            psTipoFuncionario = criaStatement.updateSql("tfu_descricao,tfu_nac_iden,tfu_salario");

            psTipoFuncionario.setString(1, item.getDescricao());
            psTipoFuncionario.setInt(2, item.getIdNivelAcesso());
            psTipoFuncionario.setDouble(3, item.getSalario());
            psTipoFuncionario.setInt(4, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psTipoFuncionario;
        
    }

    @Override
    public TipoFuncionario criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new TipoFuncionario(
                        rs.getInt(id),
                        rs.getString("tfu_descricao"),
                        rs.getInt("tfu_nac_iden"), 
                        rs.getDouble("tfu_salario")
                );

            } else
                throw new Exception("TipoFuncionario não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
