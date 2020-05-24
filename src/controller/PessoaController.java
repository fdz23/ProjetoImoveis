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
        this.tabela = "pessoas";
        this.id = "pes_iden";
        this.criaStatement = new CriaStatement(con, tabela, id);

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

            psPessoas = criaStatement.selectSql(tabela, true, "cpf");
            
            psPessoas.setString(1, cpf);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psPessoas;
    }

    @Override
    public PreparedStatement statementInserir(Pessoa item) {
        
        try {

            psPessoas = criaStatement.insertSql(tabela, "pes_nome,pes_email,pes_nascimento,pes_cpf,pes_telefone,pes_end_iden");

            psPessoas.setString(1, item.getNome());
            psPessoas.setString(2, item.getEmail());
            psPessoas.setString(3, item.getDataNascimento());
            psPessoas.setString(4, item.getCpf());
            psPessoas.setString(5, item.getTelefone());
            psPessoas.setInt(6, item.getIdEndereco());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psPessoas;
        
    }

    @Override
    public PreparedStatement statementAlterar(Pessoa item) {
        
        try {

            psPessoas = criaStatement.updateSql("pes_nome,pes_email,pes_nascimento,pes_cpf,pes_telefone,pes_end_iden");

            psPessoas.setString(1, item.getNome());
            psPessoas.setString(2, item.getEmail());
            psPessoas.setString(3, item.getDataNascimento());
            psPessoas.setString(4, item.getCpf());
            psPessoas.setString(5, item.getTelefone());
            psPessoas.setInt(6, item.getIdEndereco());
            psPessoas.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psPessoas;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psPessoas = criaStatement.deleteSql();

            psPessoas.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psPessoas;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psPessoas = criaStatement.selectSql(tabela, false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psPessoas;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psPessoas = criaStatement.selectSql(tabela, true, this.id);
            
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
                        rs.getInt(id), 
                        rs.getString("pes_nome"), 
                        rs.getString("pes_email"), 
                        rs.getString("pes_nascimento"), 
                        rs.getString("pes_cpf"), 
                        rs.getString("pes_telefone"), 
                        rs.getInt("pes_end_iden")
                );
                
            } else
                throw new Exception("Pessoa não encontrada");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
