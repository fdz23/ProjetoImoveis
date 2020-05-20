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
    
    public CriaStatement(Connection con) {
        this.con = con;
    }
    
    //Para mais de uma coluna/valores utilize "," entre cada um deles(sem espaço)
    public PreparedStatement insertSql(String tabela, String colunas) throws Exception {
        String sql = "INSERT INTO " + tabela + "(" + colunas + ")" + " values(?";
        
        for (int i = 1; i < colunas.split(",").length; i++) {
            sql += ",?";
        }
        
        sql += ")";
        
        return con.prepareStatement(sql);
    }
    
    //especificacao true para pesquisar uma coluna especifica e false para a tabela inteira
    public PreparedStatement selectSql(String tabela, boolean especificacao, String coluna) throws Exception {
        String sql = "SELECT * FROM " + tabela;
        
        if(especificacao)
            sql += " WHERE " + coluna + " = ?";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement deleteSql(String tabela) throws Exception {
        String sql = "DELETE FROM " + tabela + " WHERE id = ?";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement updateSql(String tabela, String colunas) throws Exception {
        String[] colunasSplit = colunas.split(",");
        
        String sql = "UPDATE " + tabela + " SET " + colunasSplit[0] + " = ?";
        
        if (colunasSplit.length > 1) {
            for (int i = 1; i < colunasSplit.length; i++) {
                sql += ", " + colunasSplit[i] + " = ?";
            }
        }
        
        sql += " WHERE id = ?";
        
        return con.prepareStatement(sql);
    }
}
