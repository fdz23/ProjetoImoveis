/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import model.Contrato;
import model.Imovel;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class ImovelController extends Controller<Imovel> {
    
    private ResultSet rs;
    private CriaStatement criaStatement;
    private PreparedStatement psImovel;

    public ImovelController(Connection con) {

        super(con);
        this.criaStatement = new CriaStatement(con);
        rs = null;

    }
    
    @Override
    public PreparedStatement statementInserir(Imovel item) {
        
        try {

            psImovel = criaStatement.insertSql("imovel", "data_cadastro,nome,preco,altura,comprimento,largura,quantidade_quartos,"
                                            + "quantidade_suite,banheira,quantidade_parcelas,endereco,valor_comissao,status_imovel,"
                                            + "baixa_imovel,baixa_motivo,idtipoimovel");

            psImovel.setString(1, item.getDataCadastro());
            psImovel.setString(2, item.getNome());
            psImovel.setDouble(3, item.getPreco());
            psImovel.setDouble(4, item.getAltura());
            psImovel.setDouble(5, item.getComprimento());
            psImovel.setDouble(6, item.getLargura());
            psImovel.setInt(7, item.getQuantidadeQuartos());
            psImovel.setInt(8, item.getQuantidadeSuites());
            psImovel.setBoolean(9, item.isBanheira());
            psImovel.setDouble(10, item.getValorComissao());
            psImovel.setInt(11, item.getStatusImovel());
            psImovel.setString(12, item.getBaixaImovel());
            psImovel.setString(13, item.getBaixaMotivo());
            psImovel.setInt(14, item.getIdTipoImovel());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementAlterar(Imovel item) {
        
        try {

            psImovel = criaStatement.updateSql("imovel", "data_cadastro,nome,preco,altura,comprimento,largura,quantidade_quartos,"
                                            + "quantidade_suite,banheira,quantidade_parcelas,endereco,valor_comissao,status_imovel,"
                                            + "baixa_imovel,baixa_motivo,idtipoimovel");

            psImovel.setString(1, item.getDataCadastro());
            psImovel.setString(2, item.getNome());
            psImovel.setDouble(3, item.getPreco());
            psImovel.setDouble(4, item.getAltura());
            psImovel.setDouble(5, item.getComprimento());
            psImovel.setDouble(6, item.getLargura());
            psImovel.setInt(7, item.getQuantidadeQuartos());
            psImovel.setInt(8, item.getQuantidadeSuites());
            psImovel.setBoolean(9, item.isBanheira());
            psImovel.setDouble(10, item.getValorComissao());
            psImovel.setInt(11, item.getStatusImovel());
            psImovel.setString(12, item.getBaixaImovel());
            psImovel.setString(13, item.getBaixaMotivo());
            psImovel.setInt(14, item.getIdTipoImovel());
            psImovel.setInt(15, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psImovel = criaStatement.deleteSql("imovel");

            psImovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psImovel = criaStatement.selectSql("imovel", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psImovel;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psImovel = criaStatement.selectSql("imovel", true, "id");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psImovel;
    }

    @Override
    public Imovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Imovel(rs.getInt("id"), rs.getString("data_cadastro"), rs.getString("nome"), rs.getDouble("preco"), rs.getDouble("altura"), rs.getDouble("comprimento"),
                                    rs.getDouble("largura"), rs.getInt("quantidade_quartos"), rs.getInt("quantidade_suite"), rs.getBoolean("banheira"), rs.getInt("quantidade_parcelas"),
                                    rs.getString("endereco"), rs.getDouble("valor_comissao"), rs.getInt("status_imovel"), rs.getString("baixa_imovel"), rs.getString("baixa_motivo"), rs.getInt("idtipoimovel"));

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
