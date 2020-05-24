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
import model.Endereco;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class EnderecoController extends Controller<Endereco> {
    
    private CriaStatement criaStatement;
    private PreparedStatement psEndereco;

    public EnderecoController(Connection con) {

        super(con);
        this.id = "end_iden";
        this.tabela = "enderecos";
        this.criaStatement = new CriaStatement(con, id, tabela);

    }

    @Override
    public PreparedStatement statementInserir(Endereco item) {
        
        try {

            psEndereco = criaStatement.insertSql(tabela, "end_codigo_ibge,end_logradouro,end_bairro,end_cidade,end_estado,end_complemento,end_numero,end_ponto_referencia,end_cep");

            psEndereco.setString(1, item.getCodigoIBGE());
            psEndereco.setString(2, item.getLogradouro());
            psEndereco.setString(3, item.getBairro());
            psEndereco.setString(4, item.getCidade());
            psEndereco.setString(5, item.getEstado());
            psEndereco.setString(6, item.getComplemento());
            psEndereco.setString(7, item.getNumero());
            psEndereco.setString(8, item.getPontoReferencia());
            psEndereco.setString(9, item.getCep());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psEndereco;
        
    }

    @Override
    public PreparedStatement statementAlterar(Endereco item) {
        
        try {

            psEndereco = criaStatement.updateSql("end_codigo_ibge,end_logradouro,end_bairro,end_cidade,end_estado,end_complemento,end_numero,end_ponto_referencia,end_cep");

            psEndereco.setString(1, item.getCodigoIBGE());
            psEndereco.setString(2, item.getLogradouro());
            psEndereco.setString(3, item.getBairro());
            psEndereco.setString(4, item.getCidade());
            psEndereco.setString(5, item.getEstado());
            psEndereco.setString(6, item.getComplemento());
            psEndereco.setString(7, item.getNumero());
            psEndereco.setString(8, item.getPontoReferencia());
            psEndereco.setString(9, item.getCep());
            psEndereco.setInt(10, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psEndereco;
        
    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psEndereco = criaStatement.deleteSql();

            psEndereco.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return psEndereco;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psEndereco = criaStatement.selectSql(tabela, false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psEndereco;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psEndereco = criaStatement.selectSql(tabela, true, this.id);
            
            psEndereco.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psEndereco;
    }

    @Override
    public Endereco criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Endereco(
                        rs.getInt(id), 
                        rs.getString("end_codigo_ibge"), 
                        rs.getString("end_logradouro"), 
                        rs.getString("end_bairro"), 
                        rs.getString("end_cidade"), 
                        rs.getString("end_estado"),
                        rs.getString("end_complemento"),
                        rs.getString("end_numero"), 
                        rs.getString("end_ponto_referencia"), 
                        rs.getString("end_cep")
                );

            } else
                throw new Exception("Endereco não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
