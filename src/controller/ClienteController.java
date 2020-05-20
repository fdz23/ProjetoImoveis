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
import model.Cliente;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ClienteController implements IController<Cliente> {
    
    private Connection con;
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psPessoa;
    private PreparedStatement psCliente;
    
    public ClienteController(Connection con) {
        
        this.con = con;
        this.criaStatement = new CriaStatement(con);
        rs = null;
        
    }

    //comenta!
    @Override
    public boolean inserirItem(Cliente item) {
        
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

            psCliente.executeUpdate();

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
            
        }
        
        return true;
        
    }

    @Override
    public boolean alterarItem(Cliente item) {
        
        try {

            psPessoa = criaStatement.updateSql("pessoa", "nome,email,data_nascimento,cpf,telefone");
            
            psPessoa.setString(1, item.getNome());
            psPessoa.setString(2, item.getEmail());
            psPessoa.setString(3, item.getDataNascimento());
            psPessoa.setString(4, item.getCpf());
            psPessoa.setString(5, item.getTelefone());
            psPessoa.setInt(6, item.getIdPessoa());
            
            psPessoa.executeUpdate();

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            return false;
            
        }
        
        return true;
        
    }

    @Override
    public boolean deletarItem(int id) {
        
        try {

            psCliente = criaStatement.deleteSql("cliente");
            
            psCliente.setInt(1, id);
            
            psCliente.executeUpdate();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;

        }
        
        return true;
        
    }

    @Override
    public Iterator<Cliente> getTodosItens() {
        
        List<Cliente> clientes = new ArrayList<Cliente>();
         
        try {

            psCliente = criaStatement.selectSql("cliente", false, null);
            
            rs = psCliente.executeQuery();
            
            ResultSet rsPessoa = null;
            
            while(rs.next()) {
                
                int idPessoa = rs.getInt("id_pessoa");
                int idCliente = rs.getInt("id");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
            
                rsPessoa = psPessoa.executeQuery();
                
                if (rsPessoa.next())
                    clientes.add(new Cliente(idCliente, idPessoa, rsPessoa.getString("nome"), rsPessoa.getString("email"), rsPessoa.getString("data_nascimento"), rsPessoa.getString("cpf"), rsPessoa.getString("telefone")));
                else 
                    throw new Exception("Erro na pesquisa de todos os itens Cliente(parte de pesquisa por id pessoa para pegar as informações)");
                
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return clientes.iterator();
        
    }

    @Override
    public Cliente getItem(int id) {
        
        Cliente cliente = new Cliente();
        
        try {

            psCliente = criaStatement.selectSql("cliente", true, "id");
            
            rs = psCliente.executeQuery();
            
            ResultSet rsPessoa = null;
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("id_pessoa");
                
                psPessoa = criaStatement.selectSql("pessoa", true, "id");
                
                psPessoa.setInt(1, idPessoa);
            
                rsPessoa = psPessoa.executeQuery();
                
                if (rsPessoa.next())
                    cliente = new Cliente(id, idPessoa, rsPessoa.getString("nome"), rsPessoa.getString("email"), rsPessoa.getString("data_nascimento"), rsPessoa.getString("cpf"), rsPessoa.getString("telefone"));
                else 
                    throw new Exception("Erro na pesquisa de um item Cliente(parte de pesquisa por id pessoa para pegar as informações)");
                
            }
            else
                throw new Exception("Erro na pesquisa de um item Cliente(parte de pesquisa por id cliente para pegar o id pessoa)");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return cliente;
        
    }
    
}
