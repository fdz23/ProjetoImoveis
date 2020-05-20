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
import model.Funcionario;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class FuncionarioController implements IController<Funcionario> {
    
    private Connection con;
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psPessoa;
    private PreparedStatement psFuncionario;
    
    public FuncionarioController(Connection con) {
        
        this.con = con;
        this.criaStatement = new CriaStatement(con);
        rs = null;
        
    }

    //comenta!
    @Override
    public boolean inserirItem(Funcionario item) {
        
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

            psFuncionario.executeUpdate();

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
            
        }
        
        return true;
        
    }

    @Override
    public boolean alterarItem(Funcionario item) {
        
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
            
            psFuncionario.executeUpdate();

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
            
        }
        
        return true;
        
    }

    @Override
    public boolean deletarItem(int id) {
        
        try {

            psFuncionario = criaStatement.deleteSql("funcionario");
            
            psFuncionario.setInt(1, id);
            
            psFuncionario.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }
        
        return true;
        
    }

    @Override
    public Iterator<Funcionario> getTodosItens() {
        
        List<Funcionario> clientes = new ArrayList<Funcionario>();
         
        try {

            psFuncionario = criaStatement.selectSql("funcionario", false, null);
            
            rs = psFuncionario.executeQuery();
            
            ResultSet rsPessoa = null;
            
            while(rs.next()) {
                
                int idPessoa = rs.getInt("idtipopessoa");
                int idFuncionario = rs.getInt("id");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
            
                rsPessoa = psPessoa.executeQuery();
                
                if (rsPessoa.next())
                    clientes.add(new Funcionario(idFuncionario, idPessoa, rsPessoa.getString("nome"), rsPessoa.getString("email"), rsPessoa.getString("data_nascimento"), rsPessoa.getString("cpf"), rsPessoa.getString("telefone"), rs.getInt("idtipofuncionario"), rs.getDouble("salario"), rs.getString("senha")));
                else 
                    throw new Exception("Erro na pesquisa de todos os itens Funcionario(parte de pesquisa por id pessoa para pegar as informações)");
                
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return clientes.iterator();
        
    }

    @Override
    public Funcionario getItem(int id) {
        
        Funcionario cliente = new Funcionario();
        
        try {

            psFuncionario = criaStatement.selectSql("funcionario", true, "id");
            
            rs = psFuncionario.executeQuery();
            
            ResultSet rsPessoa = null;
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("idtipopessoa");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
            
                rsPessoa = psPessoa.executeQuery();
                
                if (rsPessoa.next())
                    cliente = new Funcionario(id, idPessoa, rsPessoa.getString("nome"), rsPessoa.getString("email"), rsPessoa.getString("data_nascimento"), rsPessoa.getString("cpf"), rsPessoa.getString("telefone"), rs.getInt("idtipofuncionario"), rs.getDouble("salario"), rs.getString("senha"));
                else 
                    throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id pessoa para pegar as informações)");
                
            }
            else
                throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id funcionario para pegar o id pessoa)");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return cliente;
        
    }
    
}
