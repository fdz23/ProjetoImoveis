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
}
