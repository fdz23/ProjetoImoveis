/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.ConectaDb;
import util.CriaDate;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class RelatoriosDao {
    
    private Connection con;
    private CriaStatement criaStatement;
    private PreparedStatement ps;
    
    public RelatoriosDao() throws SQLException {
        
        this.con = ConectaDb.getInstance().getConnection();
        criaStatement = new CriaStatement(con, null, null);
        
    }
    
    public Iterator<Object[]> getImoveisByFuncionario(int idFuncionario) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisByFuncionario(idFuncionario);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("pes_nome"),
                        rs.getString("imo_descricao"),
                        rs.getDouble("imo_valor_comissao"),
                        rs.getDouble("imo_preco")
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> getImoveisFinanciadosByData(int mes, int ano) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisFinanciadosByData(mes, ano);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("imo_descricao"),
                        rs.getDouble("imo_preco"),
                        rs.getDouble("imo_valor_comissao"),
                        rs.getString("funcionario"),
                        rs.getString("cliente"),
                        rs.getString("proprietário"),
                        rs.getString("tpa_descricao"),
                        CriaDate.geraDataFormatada(rs.getDate("con_data"))
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> getImoveisByCidadePeriodoTipoImovel(String cidade, int mes, int ano, int idTipoImovel) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisByCidadePeriodoTipoImovel(cidade, mes, ano, idTipoImovel);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("imo_descricao"),
                        rs.getString("proprietário"),
                        rs.getString("tim_nome"),
                        rs.getString("end_cidade")
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> selectSqlImoveisBaixadosByBaixa(String baixa) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisBaixadosByBaixa(baixa);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("imo_descricao"),
                        CriaDate.geraDataFormatada(rs.getDate("imo_baixa_data")),
                        rs.getString("imo_baixa_motivo"),
                        CriaDate.geraDataFormatada(rs.getDate("imo_baixa_data"))
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> getImoveisByCpf(String cpf) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisByCpf(cpf);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("pes_nome"),
                        rs.getString("imo_descricao"),
                        rs.getDouble("imo_preco"),
                        rs.getString("end_cidade")
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> getCalculoComissaoPorImovel() throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlCalculoComissaoPorImovel();
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("pes_nome"),
                        rs.getDouble("valor_comissao")
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
    
    public Iterator<Object[]> getImoveisPorVendaAnual(int ano) throws SQLException {
        
        List<Object[]> itens = new ArrayList<Object[]>();
        
        ps = criaStatement.selectSqlImoveisPorVendaAnual(ano);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            
            itens.add(
                    new Object[]{
                        rs.getString("imo_descricao"),
                        rs.getDouble("imo_valor_comissao"),
                        rs.getDouble("imo_preco")
                    }
            );
            
        }
        
        return itens.iterator();
        
    }
}
