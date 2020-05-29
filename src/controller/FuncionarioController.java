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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class FuncionarioController extends Controller<Funcionario> {
    
    private PessoaController pessoaController;
    private PreparedStatement psPessoa;
    
    public FuncionarioController(Connection con) {
        
        super(con);
        
        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("FUNCIONARIO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        pessoaController = new PessoaController(con);
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao";
        vetorCampos = campos.split(",");
        
    }

    @Override
    public PreparedStatement statementInserir(Funcionario item) {
        
        try {
            
            ps = criaStatement.insertSql(tabela, campos);
            
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

            ps.setString(1, item.getMatricula());
            ps.setInt(2, pessoa.getId());
            ps.setInt(3, item.getIdTipoFuncionario());
            ps.setInt(4, item.getIdStatus());
            ps.setString(5, item.getDataRescisao());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return ps;
    }

    @Override
    public PreparedStatement statementAlterar(Funcionario item) {
        
        try {

            ps = criaStatement.updateSql(campos);
            
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
            
            ps.setString(1, item.getMatricula());
            ps.setInt(2, item.getIdPessoa());
            ps.setInt(3, item.getIdTipoFuncionario());
            ps.setInt(4, item.getIdStatus());
            ps.setString(5, item.getDataRescisao());
            ps.setInt(6, item.getId());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return ps;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {
            
            ps = criaStatement.selectSql(tabela, true, this.id);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("fun_pes_iden");
                
                pessoaController.deletarItem(idPessoa);
                
            }
            else
                throw new Exception("Erro na remoção de um item Funcionario(parte de remoção por id pessoa para remover a pessoa)");


            ps = criaStatement.deleteSql();
            
            ps.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return ps;
        
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            ps = criaStatement.selectSql(tabela, true, this.id);
            
            rs = ps.executeQuery();
            
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
                        rs.getString(vetorCampos[0]), 
                        rs.getInt(vetorCampos[1]), 
                        rs.getInt(vetorCampos[2]), 
                        rs.getInt(vetorCampos[3]), 
                        rs.getString(vetorCampos[4])
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
