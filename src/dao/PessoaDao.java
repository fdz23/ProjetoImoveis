/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class PessoaDao extends Dao<Pessoa> {
    
    private EnderecoDao enderecoDao = new EnderecoDao();

    public PessoaDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("PESSOA");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "pes_nome,pes_email,pes_nascimento,pes_cpf,pes_telefone,pes_end_iden";
        vetorCampos = campos.split(",");

    }

    protected String[] getVetorCampos() {
        return vetorCampos;
    }
    
    public void verificaExistente(Pessoa item) throws Exception {
        
        if (getByCpf(item.getCpf()) != null) throw new Exception("Cpf já cadastrado.");
        else
            if (getByEmail(item.getEmail()) != null) throw new Exception("Email já cadastrado.");
        
    }

    public Pessoa getByCpf(String cpf) {

        try {

            ps = statementGetPessoaPorCpf(cpf);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }
    
    public Pessoa getByEmail(String email) {

        try {

            ps = statementGetPessoaPorEmail(email);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementGetPessoaPorCpf(String cpf) {

        try {

            ps = criaStatement.selectSql(tabela, true, "pes_cpf");

            ps.setString(1, cpf);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }

    protected PreparedStatement statementGetPessoaPorEmail(String email) {

        try {

            ps = criaStatement.selectSql(tabela, true, "pes_email");

            ps.setString(1, email);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }

    @Override
    protected PreparedStatement statementInserir(Pessoa item) {

        try {
            
            verificaExistente(item);

            ps = criaStatement.insertSql(tabela, campos);

            ps.setString(1, item.getNome());
            ps.setString(2, item.getEmail());
            ps.setDate(3, item.getDataNascimento());
            ps.setString(4, item.getCpf());
            ps.setString(5, item.getTelefone());
            ps.setInt(6, item.getEndereco().getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Pessoa item) {

        try {

            ps = criaStatement.updateSql(campos);

            ps.setString(1, item.getNome());
            ps.setString(2, item.getEmail());
            ps.setDate(3, item.getDataNascimento());
            ps.setString(4, item.getCpf());
            ps.setString(5, item.getTelefone());
            ps.setInt(6, item.getEndereco().getId());
            ps.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected Pessoa criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new Pessoa(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0]),
                        rs.getString(vetorCampos[1]),
                        rs.getDate(vetorCampos[2]),
                        rs.getString(vetorCampos[3]),
                        rs.getString(vetorCampos[4]),
                        enderecoDao.getByID(rs.getInt(vetorCampos[5]))
                );

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
