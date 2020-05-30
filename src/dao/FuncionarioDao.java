/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
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
public class FuncionarioDao extends Dao<Funcionario> {
    
    private PessoaDao pessoaDao;
    private PreparedStatement psPessoa;
    private String[] vetorCamposPessoa;
    
    public FuncionarioDao(Connection con) {
        
        super(con);
        
        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("FUNCIONARIO");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        pessoaDao = new PessoaDao(con);
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao";
        vetorCampos = campos.split(",");
        vetorCamposPessoa = pessoaDao.getVetorCampos();
        
    }

    @Override
    protected PreparedStatement statementInserir(Funcionario item) {
        
        try {
            
            ps = criaStatement.insertSql(tabela, campos);
            
            pessoaDao.inserir(
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
            
            Pessoa pessoa = pessoaDao.getByCpf(item.getCpf());

            ps.setString(1, item.getMatricula());
            ps.setInt(2, pessoa.getId());
            ps.setInt(3, item.getIdTipoFuncionario());
            ps.setInt(4, item.getIdStatus());
            ps.setDate(5, item.getDataRescisao());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return ps;
    }

    @Override
    protected PreparedStatement statementAlterar(Funcionario item) {
        
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
            
            pessoaDao.alterar(pessoa);
            
            ps.setString(1, item.getMatricula());
            ps.setInt(2, item.getIdPessoa());
            ps.setInt(3, item.getIdTipoFuncionario());
            ps.setInt(4, item.getIdStatus());
            ps.setDate(5, item.getDataRescisao());
            ps.setInt(6, item.getId());

        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        }
        
        return ps;
        
    }

    @Override
    protected PreparedStatement statementDeletar(int id) {
        
        try {
            
            ps = criaStatement.selectSql(tabela, true, this.id);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                
                int idPessoa = rs.getInt("fun_pes_iden");
                
                pessoaDao.deletar(idPessoa);
                
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
    protected PreparedStatement statementGetItem(int id) {
        
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
    protected Funcionario criaItem(ResultSet rsPessoa) {
        
        try {
            
            if (rsPessoa.next()) {
                return new Funcionario( 
                        rsPessoa.getString(vetorCamposPessoa[0]), 
                        rsPessoa.getString(vetorCamposPessoa[1]), 
                        rsPessoa.getDate(vetorCamposPessoa[2]), 
                        rsPessoa.getString(vetorCamposPessoa[3]), 
                        rsPessoa.getString(vetorCamposPessoa[4]),
                        rsPessoa.getInt(vetorCamposPessoa[5]),
                        rs.getInt(id), 
                        rs.getString(vetorCampos[0]), 
                        rs.getInt(vetorCampos[1]), 
                        rs.getInt(vetorCampos[2]), 
                        rs.getInt(vetorCampos[3]), 
                        rs.getDate(vetorCampos[4])
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
