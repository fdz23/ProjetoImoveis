/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        
        String colunaAtivado = "";
        if(tabela.equals("pessoas"))
            colunaAtivado = tabela.substring(0, 3) + "_ativado";
        else
            colunaAtivado = id.split("_")[0] + "_ativado";
            
        String sql = "SELECT * FROM " + tabela + " WHERE " + colunaAtivado + " = 1";
        
        if(especificacao) {
            sql += " AND " + coluna + " = ?";
        }
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectSqlPessoaClienteEmail() throws Exception {
        
        String sql = "SELECT * FROM pessoas"
                   + " WHERE pes_ativado = 1"
                   + " AND pes_cliente = 0"
                   + " AND pes_email = ?";
        
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
        
        String colunaAtivado = coluna.split("_")[0] + "_ativado";
        
        String ascOuDesc = "DESC";
        
        if(asc)
            ascOuDesc = "ASC";
        
        String sql = "SELECT * FROM " + tabela 
                  + " WHERE " + colunaAtivado + " = 1"
                  + " ORDER BY " + coluna + " " + ascOuDesc;
        
        return con.prepareStatement(sql);   
    }
    
    public PreparedStatement selectSqlClienteOrder(String tabela, String coluna, boolean asc) throws Exception {
        
        String colunaAtivado = coluna.split("_")[0] + "_ativado";
        
        String ascOuDesc = "DESC";
        
        if(asc)
            ascOuDesc = "ASC";
        
        String sql = "SELECT * FROM " + tabela 
                  + " WHERE " + colunaAtivado + " = 1"
                  + " AND pes_cliente = 1"
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
        
        String colunaAtivado = coluna1.split("_")[0] + "_ativado";
        
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
        
        String colunaAtivado = coluna1.split("_")[0] + "_ativado";
        
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
    
    public PreparedStatement selectSqlEmailFuncionarioUsuario() throws SQLException {
        
        String sql = "SELECT * FROM funcionarios " +
                     "INNER JOIN pessoas ON funcionarios.fun_pes_iden = pessoas.pes_iden " +
                     "INNER JOIN usuarios ON funcionarios.fun_iden = usuarios.usu_fun_iden " +
                     "WHERE pessoas.pes_email = ?";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlOrderDuplaPessoaFunc(String coluna1, String coluna2, boolean asc1, boolean asc2) throws Exception {
        
        String colunaAtivado = coluna1.split("_")[0] + "_ativado";
        
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
        
        String colunaAtivado = coluna1.split("_")[0] + "_ativado";
        
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
        
        String colunaAtivado = coluna1.split("_")[0] + "_ativado";
        
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
    
    public PreparedStatement selectSqlImoveisByFuncionario(int idFuncionario) throws SQLException {
        
        String sql = "select P.pes_nome,I.imo_descricao,I.imo_valor_comissao,I.imo_preco from contratos C\n" +
                     "JOIN orcamentos O ON O.orc_iden = C.con_orc_iden\n" +
                     "JOIN funcionarios F ON F.fun_iden = O.orc_fun_iden\n" +
                     "JOIN pessoas P On P.pes_iden = F.fun_pes_iden\n" +
                     "JOIN imoveis I ON i.imo_iden = O.orc_imo_iden\n" +
                     "where F.fun_iden in " + idFuncionario + "\n" +
                     "and C.con_sit_iden in (1)\n" +
                     "order by F.fun_iden asc";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectSqlImoveisFinanciadosByData(int mes, int ano) throws SQLException {
        
        String sql = "SELECT I.imo_descricao,I.imo_preco,I.imo_valor_comissao,PE.pes_nome as funcionario,P.pes_nome as cliente,PES.pes_nome as Proprietário,TP.tpa_descricao,C.con_data \n" +
                     "FROM contratos C\n" +
                     "JOIN orcamentos O ON O.orc_iden = C.con_orc_iden\n" +
                     "JOIN imoveis I ON I.imo_iden = O.orc_imo_iden\n" +
                     "JOIN pessoas P ON P.pes_iden = O.orc_pes_iden\n" +
                     "JOIN funcionarios F ON F.fun_iden = O.orc_fun_iden\n" +
                     "JOIN PESSOAS PE ON PE.pes_iden = F.fun_pes_iden\n" +
                     "JOIN PESSOAS PES ON PES.pes_iden = I.imo_pes_iden\n" +
                     "JOIN tipo_pagamentos TP ON TP.tpa_iden = O.orc_tpa_iden\n" +
                     "where TP.tpa_descricao in ('Financiado')\n" +
                     "and C.con_data < CAST('" + ano + "-" + (mes + 1) + "-1 00:00:00' AS DATE)\n" +
                     "and C.con_data >= CAST('" + ano + "-" + mes + "-1 00:00:00' AS DATE)";
        
        return con.prepareStatement(sql);
    }
    
    public PreparedStatement selectSqlImoveisByCidadePeriodoTipoImovel(String cidade, int mes, int ano, int idTipoImovel) throws SQLException {
        
        String sql = "select I.imo_descricao,P.pes_nome as Proprietario,T.tim_nome,E.end_cidade FROM imoveis I\n" +
                     "JOIN pessoas P ON P.pes_iden = I.imo_pes_iden\n" +
                     "JOIN enderecos E ON E.end_iden = I.imo_iden\n" +
                     "JOIN tipo_imoveis T ON T.tim_iden = I.imo_tim_iden\n" +
                     "where T.tim_iden in (" + idTipoImovel + ")\n" +
                     "and E.end_cidade in ('" + cidade + "')\n" +
                     "and I.imo_data_inclusao < CAST('" + ano + "-" + (mes + 1) + "-1 00:00:00' AS DATE)\n" +
                     "and I.imo_data_inclusao >= CAST('" + ano + "-" + mes + "-1 00:00:00' AS DATE)";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlImoveisBaixadosByBaixa(String baixa) throws SQLException {
        
        String sql = "select I.imo_descricao,I.imo_baixa_data,I.imo_baixa_motivo,I.imo_baixa_data from imoveis I\n" +
                     "where I.imo_baixa_motivo in ('" + baixa + "')\n" +
                     "and I.imo_baixa_data != null";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlImoveisByCpf(String cpf) throws SQLException {
        
        String sql = "select P.pes_nome,I.imo_descricao,I.imo_preco,E.end_cidade FROM imoveis I\n" +
                     "JOIN enderecos E ON E.end_iden = I.imo_end_iden\n" +
                     "JOIN pessoas P ON P.pes_iden = I.imo_pes_iden\n" +
                     "where P.pes_cpf in ('" + cpf + "')";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlCalculoComissaoPorImovel() throws SQLException {
        
        String sql = "select P.pes_nome, SUM(I.imo_valor_comissao) as Valor Comissao from contratos C\n" +
                     "join orcamentos O On O.orc_iden = C.con_orc_iden\n" +
                     "JOIN imoveis I ON I.imo_iden = O.orc_imo_iden\n" +
                     "JOIN funcionarios F ON F.fun_iden = O.orc_fun_iden\n" +
                     "JOIN pessoas P On P.pes_iden = F.fun_pes_iden\n" +
                     "GROUP BY P.pes_nome";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlImoveisDisponiveisPorSituacao(String situacao) throws SQLException {
        
        String sql = "select p.pes_nome as Proprietario,I.imo_descricao,I.imo_preco,I.imo_data_inclusao,I.imo_situacao,I.imo_ativo from imoveis I\n" +
                     "join pessoas P ON P.pes_iden = I.imo_pes_iden\n" +
                     "where I.imo_ativado = 1\n" +
                     "and I.imo_situacao in ('" + situacao + "')";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlImoveisPorVendaAnual(int ano) throws SQLException {
        
        String sql = "select I.imo_descricao,I.imo_valor_comissao,I.imo_preco from contratos C\n" +
                     "join orcamentos O on O.orc_iden = C.con_orc_iden\n" +
                     "join imoveis I ON I.imo_iden = O.orc_imo_iden\n" +
                     "where C.con_data < CAST('" + (ano + 1) + "-01-1 00:00:00' AS DATE)" +
                     "and C.con_data >= CAST('" + ano + "-01-1 00:00:00' AS DATE)";
        
        return con.prepareStatement(sql);
        
    }
    
    public PreparedStatement selectSqlImoveisPorVendaMensal(int ano, int mes) throws SQLException {
        
        String sql = "select I.imo_descricao,I.imo_valor_comissao,I.imo_preco from contratos C\n" +
                     "join orcamentos O on O.orc_iden = C.con_orc_iden\n" +
                     "join imoveis I ON I.imo_iden = O.orc_imo_iden\n" +
                     "where C.con_data < CAST('" + ano + "-" + (mes + 1) + "-1 00:00:00' AS DATE)" +
                     "and C.con_data >= CAST('" + ano + "-" + mes + "-1 00:00:00' AS DATE)";
        
        return con.prepareStatement(sql);
        
    }
}
