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
import javax.swing.JOptionPane;
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class PessoaController extends Controller<Pessoa> {
    
    public PessoaController(Connection con) {

        super(con);
        
        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("PESSOA");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "pes_nome,pes_email,pes_nascimento,pes_cpf,pes_telefone,pes_end_iden";
        vetorCampos = campos.split(",");

    }
    
    public String[] getVetorCampos() {
        return vetorCampos;
    }
    
    public Pessoa getPessoaPorCpf(String cpf) {

        try {

            ps = statementGetPessoaPorCpf(cpf);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }
    
    public PreparedStatement statementGetPessoaPorCpf(String cpf) {
        
        try {

            ps = criaStatement.selectSql(tabela, true, "cpf");
            
            ps.setString(1, cpf);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }

    @Override
    public PreparedStatement statementInserir(Pessoa item) {
        
        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getNome());
            ps.setString(2, item.getEmail());
            ps.setString(3, item.getDataNascimento());
            ps.setString(4, item.getCpf());
            ps.setString(5, item.getTelefone());
            ps.setInt(6, item.getIdEndereco());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    public PreparedStatement statementAlterar(Pessoa item) {
        
        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getNome());
            ps.setString(2, item.getEmail());
            ps.setString(3, item.getDataNascimento());
            ps.setString(4, item.getCpf());
            ps.setString(5, item.getTelefone());
            ps.setInt(6, item.getIdEndereco());
            ps.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
        
    }

    @Override
    public Pessoa criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Pessoa(
                        rs.getInt(id), 
                        rs.getString(vetorCampos[0]), 
                        rs.getString(vetorCampos[1]), 
                        rs.getString(vetorCampos[2]), 
                        rs.getString(vetorCampos[3]), 
                        rs.getString(vetorCampos[4]), 
                        rs.getInt(vetorCampos[5])
                );
                
            } else
                throw new Exception("Pessoa não encontrada");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
