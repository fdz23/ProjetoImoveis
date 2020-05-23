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

            psImovel = criaStatement.insertSql("imoveis", "im_data_cadastro,im_nome,im_preco,im_itens,im_descricao,im_quantidade_parcelas,im_valor_comissao,"
                                            + "im_status_imovel,im_baixa_imovel,id_tip_tipo_imovel,id_end_enderecos,id_sta_status");

            psImovel.setString(1, item.getDataCadastro());
            psImovel.setString(2, item.getNome());
            psImovel.setDouble(3, item.getPreco());
            psImovel.setString(4, item.getItens());
            psImovel.setString(5, item.getDescricao());
            psImovel.setInt(6, item.getQuantidadeParcelas());
            psImovel.setDouble(7, item.getValorComissao());
            psImovel.setInt(8, item.getStatusImovel());
            psImovel.setString(9, item.getBaixaImovel());
            psImovel.setInt(10, item.getIdTipoImovel());
            psImovel.setInt(11, item.getIdEndereco());
            psImovel.setInt(12, item.getIdStatus());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementAlterar(Imovel item) {
        
        try {

            psImovel = criaStatement.updateSql("imoveis", "im_data_cadastro,im_nome,im_preco,im_itens,im_descricao,im_quantidade_parcelas,im_valor_comissao,"
                                            + "im_status_imovel,im_baixa_imovel,id_tip_tipo_imovel,id_end_enderecos,id_sta_status");

            psImovel.setString(1, item.getDataCadastro());
            psImovel.setString(2, item.getNome());
            psImovel.setDouble(3, item.getPreco());
            psImovel.setString(4, item.getItens());
            psImovel.setString(5, item.getDescricao());
            psImovel.setInt(6, item.getQuantidadeParcelas());
            psImovel.setDouble(7, item.getValorComissao());
            psImovel.setInt(8, item.getStatusImovel());
            psImovel.setString(9, item.getBaixaImovel());
            psImovel.setInt(10, item.getIdTipoImovel());
            psImovel.setInt(11, item.getIdEndereco());
            psImovel.setInt(12, item.getIdStatus());
            psImovel.setInt(15, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementDeletar(int id) {
        
        try {

            psImovel = criaStatement.deleteSql("imoveis");

            psImovel.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementGetTodos() {
        
        try {

            psImovel = criaStatement.selectSql("imoveis", false, null);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        
        return psImovel;
    }

    @Override
    public PreparedStatement statementGetItem(int id) {
        
        try {

            psImovel = criaStatement.selectSql("imoveis", true, "id");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psImovel;
    }

    @Override
    public Imovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Imovel(
                        rs.getInt("id"), 
                        rs.getString("im_data_cadastro"), 
                        rs.getString("im_nome"), 
                        rs.getDouble("im_preco"), 
                        rs.getString("im_itens"), 
                        rs.getString("im_descricao"),
                        rs.getInt("im_quantidade_parcelas"), 
                        rs.getDouble("im_valor_comissao"), 
                        rs.getInt("im_status_imovel"), 
                        rs.getString("im_baixa_imovel"), 
                        rs.getInt("id_tip_tipo_imovel"),
                        rs.getInt("id_end_enderecos"), 
                        rs.getInt("id_sta_status")
                );

            } else
                throw new Exception("Contrato não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
