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
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {
    
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PessoaController pessoaController;
    private PreparedStatement psFuncionario;
    private PreparedStatement psPessoa;
    
    public FuncionarioController(Connection con) {
        
        super(con);
        pessoaController = new PessoaController(con);
        this.tabela = "funcionario";
        this.id = "fun_iden";
        this.criaStatement = new CriaStatement(con, tabela, id);
        rs = null;
        
    }

    @Override
    public PreparedStatement statementInserir(Funcionario item) {
        
        try {
            
            psFuncionario = criaStatement.insertSql(tabela, "fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao");
            
            pessoaController.inserirItem(
                    new Pessoa(
                            0, 
                            item.getNome(), 
                            item.getEmail(), 
                            item.getDataNascimento(), 
                            item.getCpf(), 
                            item.getTelefone(),
                            item.getIdEndereco()
                    )
            );
            
            Pessoa pessoa = pessoaController.getPessoaPorCpf(item.getCpf());

            psFuncionario.setString(1, item.getMatricula());
            psFuncionario.setInt(2, pessoa.getId());
            psFuncionario.setInt(3, item.getIdTipoFuncionario());
            psFuncionario.setInt(4, item.getIdStatus());
            psFuncionario.setString(5, item.getDataRescisao());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
    }

    @Override
    public PreparedStatement statementAlterar(Funcionario item) {
        
        try {

            psFuncionario = criaStatement.updateSql("fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao");
            
            Pessoa pessoa = new Pessoa(
                    item.getIdPessoa(), 
                    item.getNome(), 
                    item.getEmail(), 
                    item.getDataNascimento(), 
                    item.getCpf(), 
                    item.getTelefone(),
                    item.getIdEndereco()
            );
            
            pessoaController.alterarItem(pessoa);
            
            psFuncionario.setString(1, item.getMatricula());
            psFuncionario.setInt(2, item.getIdPessoa());
            psFuncionario.setInt(3, item.getIdTipoFuncionario());
            psFuncionario.setInt(4, item.getIdStatus());
            psFuncionario.setString(5, item.getDataRescisao());
            psFuncionario.setInt(6, item.getId());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psFuncionario = criaStatement.deleteSql();
            
            psFuncionario.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementGetTodos() {
         
        try {

            psFuncionario = criaStatement.selectSql(tabela, false, null);
            
            rs = psFuncionario.executeQuery();
            
            while(rs.next()) {
                
                int idPessoa = rs.getInt("fun_pes_iden");
                
                psPessoa = criaStatement.selectSql("pessoas", true, id);
                
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

            psFuncionario = criaStatement.selectSql(tabela, true, this.id);
            
            rs = psFuncionario.executeQuery();
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("fun_pes_iden");
                
                psPessoa = criaStatement.selectSql("pessoas", true, "pes_iden");
                
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
            
            if (rsPessoa.next()) {
                return new Funcionario( 
                        rsPessoa.getString("pes_nome"), 
                        rsPessoa.getString("pes_email"), 
                        rsPessoa.getString("pes_nascimento"), 
                        rsPessoa.getString("pes_cpf"), 
                        rsPessoa.getString("pes_telefone"),
                        rsPessoa.getInt("pes_end_iden"),
                        rs.getInt(id), 
                        rs.getString("fun_matricula"), 
                        rs.getInt("fun_pes_iden"), 
                        rs.getInt("fun_tfu_iden"), 
                        rs.getInt("fun_sta_iden"), 
                        rs.getString("fun_data_rescisao")
                );
            }
            else 
                throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id pessoa para pegar as informações)");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }
    
}
