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
import model.Funcionario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {
    
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psPessoa;
    private PreparedStatement psFuncionario;
    private int idPessoa;
    private int idFuncionario;
    
    public FuncionarioController(Connection con) {
        
        super(con);
        this.criaStatement = new CriaStatement(con);
        rs = null;
        
    }

    @Override
    public PreparedStatement statementInserir(Funcionario item) {
        
        try {
            
            psPessoa = criaStatement.insertSql("pessoa", "nome,email,data_nascimento,cpf,telefone");
            psFuncionario = criaStatement.insertSql("funcionario", "id,idtipofuncionario,idtipopessoa,salario,senha");
            PreparedStatement psPessoa2 = criaStatement.selectSql("pessoa", true, "cpf");
            
            psPessoa.setString(1, item.getNome());
            psPessoa.setString(2, item.getEmail());
            psPessoa.setString(3, item.getDataNascimento());
            psPessoa.setString(4, item.getCpf());
            psPessoa.setString(5, item.getTelefone());
            
            psPessoa.executeUpdate();
            
            psPessoa.setString(1, item.getCpf());

            rs = psPessoa2.executeQuery();

            if (rs.next()) {

                item.setIdPessoa(rs.getInt("id"));

            } else {

                throw new Exception("Erro na inserção do item Funcionario(parte de pesquisa por cpf para pegar id)");

            }

            psFuncionario.setInt(1, item.getId());
            psFuncionario.setInt(2, item.getIdTipoFuncionario());
            psFuncionario.setInt(3, item.getIdPessoa());
            psFuncionario.setDouble(4, item.getSalario());
            psFuncionario.setString(5, item.getSenha());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
    }

    @Override
    public PreparedStatement statementAlterar(Funcionario item) {
        
        try {

            psPessoa = criaStatement.updateSql("pessoa", "nome,email,data_nascimento,cpf,telefone");
            psFuncionario = criaStatement.updateSql("funcionario", "idtipofuncionario,salario,senha");
            
            psPessoa.setString(1, item.getNome());
            psPessoa.setString(2, item.getEmail());
            psPessoa.setString(3, item.getDataNascimento());
            psPessoa.setString(4, item.getCpf());
            psPessoa.setString(5, item.getTelefone());
            psPessoa.setInt(6, item.getIdPessoa());
            
            psPessoa.executeUpdate();
            
            psFuncionario.setInt(1, item.getIdTipoFuncionario());
            psFuncionario.setDouble(2, item.getSalario());
            psFuncionario.setString(3, item.getSenha());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psFuncionario = criaStatement.deleteSql("funcionario");
            
            psFuncionario.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementGetTodos() {
         
        try {

            psFuncionario = criaStatement.selectSql("funcionario", false, null);
            
            rs = psFuncionario.executeQuery();
            
            while(rs.next()) {
                
                idPessoa = rs.getInt("idtipopessoa");
                idFuncionario = rs.getInt("id");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
                
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psPessoa;
        
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psFuncionario = criaStatement.selectSql("funcionario", true, "id");
            
            rs = psFuncionario.executeQuery();
            
            if(rs.next()) {
                
                idPessoa = rs.getInt("idtipopessoa");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
                
            }
            else
                throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id funcionario para pegar o id pessoa)");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psPessoa;
        
    }

    @Override
    public Funcionario criaItem(ResultSet rsPessoa) {
        
        try {
            
            if (rsPessoa.next())
                    return new Funcionario(idFuncionario, idPessoa, rsPessoa.getString("nome"), rsPessoa.getString("email"), rsPessoa.getString("data_nascimento"), rsPessoa.getString("cpf"), rsPessoa.getString("telefone"), rs.getInt("idtipofuncionario"), rs.getDouble("salario"), rs.getString("senha"));
                else 
                    throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id pessoa para pegar as informações)");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }
    
}
