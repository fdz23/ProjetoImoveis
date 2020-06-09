/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.fabricas.AbstractFactory;
import model.interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class PessoaDao extends Dao<Pessoa> {

    private EnderecoDao enderecoDao = new EnderecoDao();

    public PessoaDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("PESSOA");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "pes_nome,pes_email,pes_nascimento,pes_cpf,pes_telefone,pes_end_iden,pes_cliente,pes_ativado";
        vetorCampos = campos.split(",");

    }

    protected String[] getVetorCampos() {
        return vetorCampos;
    }

    @Override
    public void verificaExistenteInserir(Pessoa item) throws Exception {

        if (getByCpf(item.getCpf()) != null) {
            throw new Exception("Cpf já cadastrado.");
        } else if (getByEmail(item.getEmail()) != null) {
            throw new Exception("Email já cadastrado.");
        }

    }

    @Override
    public void verificaExistenteAlterar(Pessoa item) throws Exception {

        if (getByCpf(item.getCpf()) != null && getByCpf(item.getCpf()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Cpf já cadastrado.");
        } else if (getByEmail(item.getEmail()) != null  && getByEmail(item.getEmail()).getId() != getByID(item.getId()).getId()) {
            throw new Exception("Email já cadastrado.");
        }

    }

    public Pessoa getByCpf(String cpf) throws Exception {

        ps = statementGetPessoaPorCpf(cpf);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    public Pessoa getByEmail(String email) throws Exception {

        ps = statementGetPessoaPorEmail(email);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    public Pessoa getByEmailFunc(String email) throws Exception {

        ps = statementGetPessoaPorEmailFunc(email);

        rs = ps.executeQuery();

        return criaItem(rs);

    }

    protected PreparedStatement statementGetPessoaPorCpf(String cpf) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "pes_cpf");

        ps.setString(1, cpf);

        return ps;
    }
    
    protected PreparedStatement statementGetPessoaPorEmailFunc(String email) throws Exception {

        ps = criaStatement.selectSqlPessoaClienteEmail();

        ps.setString(1, email);

        return ps;
    }

    protected PreparedStatement statementGetPessoaPorEmail(String email) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "pes_email");

        ps.setString(1, email);

        return ps;
    }

    @Override
    protected PreparedStatement statementInserir(Pessoa item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        ps.setString(1, item.getNome());
        ps.setString(2, item.getEmail());
        ps.setDate(3, item.getDataNascimento());
        ps.setString(4, item.getCpf());
        ps.setString(5, item.getTelefone());
        ps.setInt(6, item.getEndereco().getId());
        ps.setInt(7, item.getCliente());
        ps.setInt(8, item.getAtivado());
        
        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Pessoa item) throws Exception {

        ps = criaStatement.updateSql(campos);

        ps.setString(1, item.getNome());
        ps.setString(2, item.getEmail());
        ps.setDate(3, item.getDataNascimento());
        ps.setString(4, item.getCpf());
        ps.setString(5, item.getTelefone());
        ps.setInt(6, item.getEndereco().getId());
        ps.setInt(7, item.getCliente());
        ps.setInt(8, item.getAtivado());
        ps.setInt(9, item.getId());

        return ps;

    }

    @Override
    protected Pessoa criaItem(ResultSet rs) throws Exception {

        if (rs.next()) {

            return new Pessoa(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    rs.getString(vetorCampos[1]),
                    rs.getDate(vetorCampos[2]),
                    rs.getString(vetorCampos[3]),
                    rs.getString(vetorCampos[4]),
                    enderecoDao.getByID(rs.getInt(vetorCampos[5])),
                    rs.getInt(vetorCampos[6]),
                    rs.getInt(vetorCampos[7])
            );

        }

        return null;

    }

    public Iterator<Pessoa> getAllClientes() throws Exception {

        //estrutura de dados 3 : pilha
        List<Pessoa> itens = new Stack<Pessoa>();

        ps = statementGetTodosClientes();
        
        ps.setInt(1, 1);

        rs = ps.executeQuery();

        while (rs.next()) {

            itens.add(getByID(rs.getInt(id)));

        }

        return itens.iterator();

    }

    protected PreparedStatement statementGetTodosClientes() throws Exception {

        //cria um sql para selecionar todos os itens clientes
        ps = criaStatement.selectSql("pessoas", true, "pes_cliente");

        return ps;

    }
    
    public boolean removeCliente(int id) throws Exception {
        
        Pessoa pessoa = getByID(id);
        
        pessoa.setCliente(0);

        return update(pessoa);
        
    }
    
    public Iterator<Pessoa> getAllClienteOrderBy(int campo, boolean ascOuDesc) throws Exception {

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length) {
            throw new Exception("Campo para ser ordenado inexistente.");
        }

        String coluna = "";

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (campo == 0) {
            coluna = id;
        } else {
            coluna = vetorCampos[campo - 1];
        }

        //estrutura de dados 2 : Lista encadeada
        List<Pessoa> itens = new LinkedList<Pessoa>();

        //cria um sql que recebe todos os itens ordenados a coluna
        ps = criaStatement.selectSqlClienteOrder(tabela, coluna, ascOuDesc);

        //faz o pedido de busca conforme o PreparedStatement criado
        rs = ps.executeQuery();

        while (rs.next()) {

            //adiciona na fila de prioridade todos os itens
            itens.add(getByID(rs.getInt(id)));

        }

        return itens.iterator();

    }

}
