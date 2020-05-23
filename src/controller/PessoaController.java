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
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psPessoas;

    public PessoaController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);

    }
    
    public Pessoa getPessoaPorCpf(String cpf) {

        try {

            preparedStatement = statementGetPessoaPorCpf(cpf);

            rs = preparedStatement.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }
    
    public PreparedStatement statementGetPessoaPorCpf(String cpf) {
        
        try {

            psPessoas = criaStatement.selectSql("pessoas", true, "cpf");
            
            psPessoas.setString(1, cpf);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psPessoas;
    }

    @Override
    public PreparedStatement statementInserir(Pessoa item) {
        
        try {

            psPessoas = criaStatement.insertSql("pessoas", "pe_nome,pe_email,pe_data_nascimento,pe_cpf,pe_telefone");

            psPessoas.setString(1, item.getNome());
            psPessoas.setString(2, item.getEmail());
            psPessoas.setString(3, item.getDataNascimento());
            psPessoas.setString(4, item.getCpf());
            psPessoas.setString(5, item.getTelefone());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psPessoas;
        
    }

    @Override
    public PreparedStatement statementAlterar(Pessoa item) {
        
        try {

            psPessoas = criaStatement.updateSql("pessoas", "pe_nome,pe_email,pe_data_nascimento,pe_cpf,pe_telefone");

            psPessoas.setString(1, item.getNome());
            psPessoas.setString(2, item.getEmail());
            psPessoas.setString(3, item.getDataNascimento());
            psPessoas.setString(4, item.getCpf());
            psPessoas.setString(5, item.getTelefone());
            psPessoas.setInt(6, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psPessoas;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psPessoas = criaStatement.deleteSql("pessoas");

            psPessoas.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psPessoas;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psPessoas = criaStatement.selectSql("pessoas", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psPessoas;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psPessoas = criaStatement.selectSql("pessoas", true, "id");
            
            psPessoas.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psPessoas;
    }

    @Override
    public Pessoa criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Pessoa(
                        rs.getInt("id"), 
                        rs.getString("pe_nome"), 
                        rs.getString("pe_email"), 
                        rs.getString("pe_data_nascimento"), 
                        rs.getString("pe_cpf"), 
                        rs.getString("pe_telefone")
                );

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
