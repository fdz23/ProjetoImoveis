/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author fdz
 */
public class CriaStatement {
    
    private Connection con = null;
    private String tabela;
    private String id;
    
    public CriaStatement(Connection con, String tabela, String id) {
        this.con = con;
        this.tabela = tabela;
        this.id = id;
    }
    
    //cria um PreparedStatement de inserção genericamente
    //recebe o nome da tabela(conforme ao banco)
    //recebe o nome da coluna(conforme ao banco)
    //Para mais de uma coluna/valores utilize "," entre cada um deles(sem espaço)
    public PreparedStatement insertSql(String tabela, String colunas) throws Exception {
        
        
        
        String sql = "INSERT INTO " + tabela + "(" + colunas + ")" + " values(?";
        
        for (int i = 1; i < colunas.split(",").length; i++) {
            sql += ",?";
        }
        
        sql += ")";
        
        return con.prepareStatement(sql);
    }
    
    //cria um PreparedStatement de seleção genericamente
    //recebe o nome da tabela(conforme ao banco)
    //especificacao true para pesquisar uma coluna especifica e false para a tabela inteira
    //recebe o nome da coluna(conforme ao banco)
    //Para mais de uma coluna/valores utilize "," entre cada um deles(sem espaço)
    public PreparedStatement selectSql(String tabela, boolean especificacao, String coluna) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String sql = "SELECT * FROM " + tabela + " WHERE " + colunaAtivado + " = 1";
        
        if(especificacao)
            sql += " AND " + coluna + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectSqlPessoaClienteIdFunc(String coluna) throws Exception {
        
        String sql = "SELECT * FROM pessoas"
                   + " WHERE pes_ativado = 1"
                   + " AND pes_cliente = 0"
                   + " AND pes_iden = ?";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectAllSql(String tabela, boolean especificacao, String coluna) throws Exception {
        
        String sql = "SELECT * FROM " + tabela;
        
        if(especificacao)
            sql += " WHERE " + coluna + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    //cria um PreparedStatement de desativação genericamente o nome da tabela e o id foram definidos previamente
    public PreparedStatement deactivateSql() throws Exception {
        
        String coluna = id.split("_")[0] + "_ativado";
        
        String sql = "UPDATE " + tabela + " SET " + coluna + " = 0 WHERE " + id + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    //cria um PreparedStatement de ativação genericamente o nome da tabela e o id foram definidos previamente
    public PreparedStatement activateSql() throws Exception {
        
        String coluna = id.split("_")[0] + "_ativado";
        
        String sql = "UPDATE " + tabela + " SET " + coluna + " = 1 WHERE " + id + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    //cria um PreparedStatement de atualização genericamente
    //recebe o nome da coluna(conforme ao banco)
    //Para mais de uma coluna/valores utilize "," entre cada um deles(sem espaço)
    public PreparedStatement updateSql(String colunas) throws Exception {
        String[] colunasSplit = colunas.split(",");
        
        String sql = "UPDATE " + tabela + " SET " + colunasSplit[0] + " = ?";
        
        if (colunasSplit.length > 1) {
            for (int i = 1; i < colunasSplit.length; i++) {
                sql += ", " + colunasSplit[i] + " = ?";
            }
        }
        
        sql += " WHERE " + id + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    //cria um PreparedStatement de seleção genérica de ordenação
    //recebe o nome da tabela(conforme ao banco)
    //recebe o nome da coluna(conforme ao banco)
    //asc true para ordenação ascendente e false para descendente
    public PreparedStatement selectSqlOrder(String tabela, String coluna, boolean asc) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc = "DESC";
        
        if(asc)
            ascOuDesc = "ASC";
        
        String sql = "SELECT * FROM " + tabela 
                  + " WHERE " + colunaAtivado + " = 1"
                  + " ORDER BY " + coluna + " " + ascOuDesc;
        
        return con.prepareStatement(sql);   
    }
    
    //cria um PreparedStatement de seleção genérica de ordenação
    //recebe o nome da tabela(conforme ao banco)
    //recebe o nome da coluna a ser ordenada em primeiro(conforme ao banco)
    //recebe o nome da coluna a ser ordenada por segundo(conforme ao banco)
    //asc1 true para ordenação ascendente e false para descendente da primeira coluna
    //asc2 true para ordenação ascendente e false para descendente da segunda coluna
    public PreparedStatement selectSqlOrderDupla(String tabela, String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc1 = "DESC";
        String ascOuDesc2 = "DESC";
        
        if(asc1)
            ascOuDesc1 = "ASC";
        if(asc2)
            ascOuDesc2 = "ASC";
        
        String sql = "SELECT * FROM " + tabela 
                  + " WHERE " + colunaAtivado + " = 1"
                  + " ORDER BY " + coluna1 + " " + ascOuDesc1 + ", " 
                  + coluna2 + " " + ascOuDesc2;
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectSqlOrderDuplaFuncPessoa(String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc1 = "DESC";
        String ascOuDesc2 = "DESC";
        
        if(asc1)
            ascOuDesc1 = "ASC";
        if(asc2)
            ascOuDesc2 = "ASC";
        
        String sql = "SELECT * FROM funcionarios" +
                     " INNER JOIN pessoas ON funcionarios.fun_pes_iden = pessoas.pes_iden" +
                     " WHERE " + colunaAtivado + " = 1" +
                     " ORDER BY funcionarios." + coluna1 + " " + ascOuDesc1 + ", pessoas." + coluna2 + " " + ascOuDesc2;
        
        return con.prepareStatement(sql);   
    }
    
    public PreparedStatement selectSqlOrderDuplaPessoaFunc(String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc1 = "DESC";
        String ascOuDesc2 = "DESC";
        
        if(asc1)
            ascOuDesc1 = "ASC";
        if(asc2)
            ascOuDesc2 = "ASC";
        
        String sql = "SELECT * FROM funcionarios" +
                     " INNER JOIN pessoas ON funcionarios.fun_pes_iden = pessoas.pes_iden" +
                     " WHERE " + colunaAtivado + " = 1" +
                     " ORDER BY pessoas." + coluna1 + " " + ascOuDesc1 + ", funcionarios." + coluna2 + " " + ascOuDesc2;
        
        return con.prepareStatement(sql);   
    }
    
    public PreparedStatement selectSqlOrderDuplaFuncFunc(String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc1 = "DESC";
        String ascOuDesc2 = "DESC";
        
        if(asc1)
            ascOuDesc1 = "ASC";
        if(asc2)
            ascOuDesc2 = "ASC";
        
        String sql = "SELECT * FROM funcionarios" +
                     " INNER JOIN pessoas ON funcionarios.fun_pes_iden = pessoas.pes_iden" +
                     " WHERE " + colunaAtivado + " = 1" +
                     " ORDER BY funcionarios." + coluna1 + " " + ascOuDesc1 + ", funcionarios." + coluna2 + " " + ascOuDesc2;
        
        return con.prepareStatement(sql);   
    }
    
    public PreparedStatement selectSqlOrderDuplaPessoaPessoa(String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = id.split("_")[0] + "_ativado";
        
        String ascOuDesc1 = "DESC";
        String ascOuDesc2 = "DESC";
        
        if(asc1)
            ascOuDesc1 = "ASC";
        if(asc2)
            ascOuDesc2 = "ASC";
        
        String sql = "SELECT * FROM funcionarios" +
                     " INNER JOIN pessoas ON funcionarios.fun_pes_iden = pessoas.pes_iden" +
                     " WHERE " + colunaAtivado + " = 1" +
                     " ORDER BY pessoas." + coluna1 + " " + ascOuDesc1 + ", pessoas." + coluna2 + " " + ascOuDesc2;
        
        return con.prepareStatement(sql);   
    }
    
}
