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
        
        Tabela obj = AbstractFactory.getInstance("MATERIAL").getTabela("IMOVEL");
        
        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        rs = null;

    }
    
    @Override
    public PreparedStatement statementInserir(Imovel item) {
        
        try {

            psImovel = criaStatement.insertSql(tabela, "imo_data_inclusao,imo_preco,imo_tamanho,imo_observacao,imo_baixa_data,imo_baixa_motivo,"
                                                     + "imo_quantidade_parcelas,imo_valor_comissao,imo_fun_iden,imo_pes_iden,imo_tim_iden,imo_end_iden");

            psImovel.setString(1, item.getDataInclusao());
            psImovel.setDouble(2, item.getPreco());
            psImovel.setDouble(3, item.getTamanho());
            psImovel.setString(4, item.getObservacao());
            psImovel.setString(5, item.getBaixaData());
            psImovel.setString(6, item.getBaixaMotivo());
            psImovel.setInt(7, item.getQuantidadeParcelas());
            psImovel.setDouble(8, item.getValorComissao());
            psImovel.setInt(9, item.getIdFuncionario());
            psImovel.setInt(10, item.getIdPessoa());
            psImovel.setInt(11, item.getIdTipoImovel());
            psImovel.setInt(12, item.getIdEndereco());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }

    @Override
    public PreparedStatement statementAlterar(Imovel item) {
        
        try {

            psImovel = criaStatement.updateSql("imo_data_inclusao,imo_preco,imo_tamanho,imo_observacao,imo_baixa_data,imo_baixa_motivo,"
                                             + "imo_quantidade_parcelas,imo_valor_comissao,imo_fun_iden,imo_pes_iden,imo_tim_iden,imo_end_iden");

            psImovel.setString(1, item.getDataInclusao());
            psImovel.setDouble(2, item.getPreco());
            psImovel.setDouble(3, item.getTamanho());
            psImovel.setString(4, item.getObservacao());
            psImovel.setString(5, item.getBaixaData());
            psImovel.setString(6, item.getBaixaMotivo());
            psImovel.setInt(7, item.getQuantidadeParcelas());
            psImovel.setDouble(8, item.getValorComissao());
            psImovel.setInt(9, item.getIdFuncionario());
            psImovel.setInt(10, item.getIdPessoa());
            psImovel.setInt(11, item.getIdTipoImovel());
            psImovel.setInt(12, item.getIdEndereco());
            psImovel.setInt(13, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return psImovel;

    }
    
    @Override
    public Imovel criaItem(ResultSet rs) {
        
        try {
            
            if (rs.next()) {

                return new Imovel(
                        rs.getInt("imo_iden"), 
                        rs.getString("imo_data_inclusao"), 
                        rs.getDouble("imo_preco"), 
                        rs.getDouble("imo_tamanho"), 
                        rs.getString("imo_observacao"), 
                        rs.getString("imo_baixa_data"),
                        rs.getString("imo_baixa_motivo"), 
                        rs.getInt("imo_quantidade_parcelas"), 
                        rs.getDouble("imo_valor_comissao"), 
                        rs.getInt("imo_fun_iden"), 
                        rs.getInt("imo_pes_iden"),
                        rs.getInt("imo_tim_iden"), 
                        rs.getInt("imo_end_iden")
                );
                
            } else
                throw new Exception("Imovel não encontrado");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return null;
        
    }

}
