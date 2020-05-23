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
        this.criaStatement = new CriaStatement(con);
        rs = null;
        
    }

    @Override
    public PreparedStatement statementInserir(Funcionario item) {
        
        try {
            
            psFuncionario = criaStatement.insertSql("funcionario", "func_salario,func_data_primeiro_salario,func_data_ultimo_salario,func_matricula,func_data_contratacao,id_tif_tipofuncionario,id_pe_pessoa");
            
            pessoaController.inserirItem(
                    new Pessoa(
                            0, 
                            item.getNome(), 
                            item.getEmail(), 
                            item.getDataNascimento(), 
                            item.getCpf(), 
                            item.getTelefone()
                    )
            );
            
            Pessoa pessoa = pessoaController.getPessoaPorCpf(item.getCpf());

            psFuncionario.setDouble(1, item.getSalario());
            psFuncionario.setString(2, item.getDataPrimeiroSalario());
            psFuncionario.setString(3, item.getDataUltimoSalario());
            psFuncionario.setString(4, item.getMatricula());
            psFuncionario.setString(5, item.getDataContratacao());
            psFuncionario.setInt(6, item.getIdTipoFuncionario());
            psFuncionario.setInt(7, pessoa.getId());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
    }

    @Override
    public PreparedStatement statementAlterar(Funcionario item) {
        
        try {

            psFuncionario = criaStatement.updateSql("funcionario", "func_salario,func_data_primeiro_salario,func_data_ultimo_salario,func_matricula,func_data_contratacao,id_tif_tipofuncionario,id_pe_pessoa");
            
            Pessoa pessoa = new Pessoa(
                    item.getIdPessoa(), 
                    item.getNome(), 
                    item.getEmail(), 
                    item.getDataNascimento(), 
                    item.getCpf(), 
                    item.getTelefone()
            );
            
            pessoaController.alterarItem(pessoa);
            
            psFuncionario.setDouble(1, item.getSalario());
            psFuncionario.setString(2, item.getDataPrimeiroSalario());
            psFuncionario.setString(3, item.getDataUltimoSalario());
            psFuncionario.setString(4, item.getMatricula());
            psFuncionario.setString(5, item.getDataContratacao());
            psFuncionario.setInt(6, item.getIdTipoFuncionario());
            psFuncionario.setInt(7, item.getIdPessoa());
            psFuncionario.setInt(8, item.getId());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psFuncionario = criaStatement.deleteSql("funcionarios");
            
            psFuncionario.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psFuncionario;
        
    }

    @Override
    public PreparedStatement statementGetTodos() {
         
        try {

            psFuncionario = criaStatement.selectSql("funcionarios", false, null);
            
            rs = psFuncionario.executeQuery();
            
            while(rs.next()) {
                
                int idPessoa = rs.getInt("id_pe_pessoas");
                
                psPessoa = criaStatement.selectSql("pessoas", true, "id");
                
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

            psFuncionario = criaStatement.selectSql("funcionarios", true, "id");
            
            rs = psFuncionario.executeQuery();
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("id_pe_pessoas");
                
                psPessoa = criaStatement.selectSql("pessoas", true, "id");
                
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
                        rs.getInt("id"), 
                        rs.getDouble("func_salario"), 
                        rs.getString("func_data_primeiro_salario"), 
                        rs.getString("func_data_ultimo_salario"), 
                        rs.getString("func_matricula"), 
                        rs.getString("func_data_contratacao"), 
                        rs.getInt("id_tif_tipofuncionario"), 
                        rs.getInt("id_pe_pessoa"), 
                        rsPessoa.getString("pe_nome"), 
                        rsPessoa.getString("pe_email"), 
                        rsPessoa.getString("pe_data_nascimento"), 
                        rsPessoa.getString("pe_cpf"), 
                        rsPessoa.getString("pe_telefone")
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
