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
import model.Cliente;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ClienteController extends Controller<Cliente> {
    
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psPessoa;
    private PreparedStatement psCliente;
    private int idPessoa;
    private int idCliente;
    
    public ClienteController(Connection con) {
        
        super(con);
        this.criaStatement = new CriaStatement(con);
        rs = null;
        
    }

    @Override
    public PreparedStatement statementInserir(Cliente item) {
        
        try {
            
            psPessoa = criaStatement.insertSql("pessoa", "nome,email,data_nascimento,cpf,telefone");
            psCliente = criaStatement.insertSql("cliente", "id,idpessoa");
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

                throw new Exception("Erro na inserção do item Cliente(parte de pesquisa por cpf para pegar id)");

            }

            psCliente.setInt(1, item.getId());
            psCliente.setInt(2, item.getIdPessoa());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return psCliente;
    }

    @Override
    public PreparedStatement statementAlterar(Cliente item) {
        
        try {

            psPessoa = criaStatement.updateSql("pessoa", "nome,email,data_nascimento,cpf,telefone");
            
            psPessoa.setString(1, item.getNome());
            psPessoa.setString(2, item.getEmail());
            psPessoa.setString(3, item.getDataNascimento());
            psPessoa.setString(4, item.getCpf());
            psPessoa.setString(5, item.getTelefone());
            psPessoa.setInt(6, item.getIdPessoa());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psPessoa;
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psCliente = criaStatement.deleteSql("cliente");
            
            psCliente.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psCliente;
    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psCliente = criaStatement.selectSql("cliente", false, null);
            
            rs = psCliente.executeQuery();
            
            while(rs.next()) {
                
                idPessoa = rs.getInt("id_pessoa");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return psPessoa;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psCliente = criaStatement.selectSql("cliente", true, "id");
            
            rs = psCliente.executeQuery();
            
            if(rs.next()) {
                
                idPessoa = rs.getInt("id_pessoa");
                idCliente = rs.getInt("id");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
                
            }
            
            else
                throw new Exception("Erro na pesquisa de um item Cliente(parte de pesquisa por id cliente para pegar o id pessoa)");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psPessoa;
    }

    @Override
    public Cliente criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next())
                    return new Cliente(idCliente, idPessoa, rs.getString("nome"), rs.getString("email"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("telefone"));
                else 
                    throw new Exception("Erro na pesquisa de um item Cliente(parte de pesquisa por id pessoa para pegar as informações)");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }
    
}
