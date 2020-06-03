/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class FuncionarioDao extends Dao<Funcionario> {

    private PessoaDao pessoaDao;
    private PreparedStatement psPessoa;
    private String[] vetorCamposPessoa;
    private TipoFuncionarioDao tipoFuncionarioDao = new TipoFuncionarioDao();
    private StatusDao statusDao = new StatusDao();

    public FuncionarioDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("FUNCIONARIO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        pessoaDao = new PessoaDao();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao";
        vetorCampos = campos.split(",");
        vetorCamposPessoa = pessoaDao.getVetorCampos();

    }

    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    @Override
    public Iterator<Funcionario> getTodosItensOrdenadosDuplamentePor(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception {

        String[] vetorCamposPessoa = pessoaDao.getVetorCampos();

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo1 < 0 || campo1 > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo1 para ser ordenado inexistente.");
        }
        if (campo2 < 0 || campo2 > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo2 para ser ordenado inexistente.");
        }

        String coluna1 = "";
        String coluna2 = "";

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (campo1 == 0) {
            coluna1 = "pes_iden";
        } else {
            coluna1 = vetorCamposPessoa[campo1 - 1];
        }

        if (campo1 == vetorCamposPessoa.length + 1) {
            coluna1 = id;
        } else {
            coluna1 = vetorCampos[campo1 - vetorCamposPessoa.length - 1];
        }

        if (campo2 == 0) {
            coluna2 = "pes_iden";
        } else {
            coluna2 = vetorCamposPessoa[campo2 - 1];
        }

        if (campo2 == vetorCamposPessoa.length + 1) {
            coluna2 = id;
        } else {
            coluna2 = vetorCampos[campo2 - vetorCamposPessoa.length - 1];
        }

        //estrutura de dados 1 : Fila de prioridade
        Queue<Funcionario> itens = new PriorityQueue<Funcionario>();

        try {

            //cria um sql que recebe todos os itens ordenados conforme duas colunas
            ps = criaStatement.selectSqlOrderDupla("pessoas", coluna1, coluna2, ascOuDesc1, ascOuDesc2);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                if (checarPessoaFuncionario(rs.getInt("pes_iden"))) {
                    itens.add(getByID(rs.getInt(id)));
                }

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return itens.iterator();

    }

    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    @Override
    public Iterator<Funcionario> getTodosItensOrdenadosPor(int campo, boolean ascOuDesc) throws Exception {

        String[] vetorCamposPessoa = pessoaDao.getVetorCampos();

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo para ser ordenado inexistente.");
        }

        String coluna = "";

        //estrutura de dados 2 : Lista encadeada
        List<Funcionario> itens = new LinkedList<Funcionario>();

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (campo < vetorCamposPessoa.length + 1) {
            if (campo == 0) {
                coluna = "pes_iden";
            } else {
                coluna = vetorCamposPessoa[campo - 1];
            }

            try {

                //cria um sql que recebe todos os itens ordenados a coluna
                ps = criaStatement.selectSqlOrder("pessoas", coluna, ascOuDesc);

                //faz o pedido de busca conforme o PreparedStatement criado
                rs = ps.executeQuery();

                while (rs.next()) {

                    //adiciona na fila de prioridade todos os itens
                    if (checarPessoaFuncionario(rs.getInt("pes_iden"))) {
                        itens.add(getByID(rs.getInt(id)));
                    }

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());

            }

        } else {
            if (campo == vetorCamposPessoa.length + 1) {
                coluna = id;
            } else {
                coluna = vetorCampos[campo - vetorCamposPessoa.length - 1];
            }

            try {

                //cria um sql que recebe todos os itens ordenados a coluna
                ps = criaStatement.selectSqlOrder(tabela, coluna, ascOuDesc);

                //faz o pedido de busca conforme o PreparedStatement criado
                rs = ps.executeQuery();

                while (rs.next()) {

                    //adiciona na fila de prioridade todos os itens
                    itens.add(getByID(rs.getInt(id)));

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());

            }

        }

        return itens.iterator();

    }

    private boolean checarPessoaFuncionario(int idPessoa) {

        Iterator<Funcionario> itens = getAll();
        boolean result = false;

        while (itens.hasNext()) {
            if (itens.next().getPessoa().getId() == idPessoa) {
                result = true;
            }
        }

        return result;

    }

    public String geraMatricula() throws Exception {

        return "FUN" + String.format("%04d", (getUltimoId() + 1));

    }

    private int getUltimoId() throws Exception {

        if (!getAll().hasNext()) {
            return 1;
        } else {
            return getTodosItensOrdenadosPor(0, false).next().getId();
        }

    }

    @Override
    protected void verificaExistente(Funcionario item) throws Exception {
    }

    @Override
    protected PreparedStatement statementInserir(Funcionario item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            //insere uma pessoa com os valores recebidos
            pessoaDao.inserir(
                    new Pessoa(
                            0,
                            item.getNome(),
                            item.getEmail(),
                            item.getDataNascimento(),
                            item.getCpf(),
                            item.getTelefone(),
                            item.getEndereco()
                    )
            );

            //pesquisa essa pessoa que foi inserida por cpf e cria um objeto pessoa e passa seu id para o statement a ser usado
            Pessoa pessoa = pessoaDao.getByCpf(item.getCpf());

            ps.setString(1, item.getMatricula());
            ps.setInt(2, pessoa.getId());
            ps.setInt(3, item.getTipoFuncionario().getId());
            ps.setInt(4, item.getStatus().getId());
            ps.setDate(5, item.getDataRescisao());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;
    }

    @Override
    protected PreparedStatement statementAlterar(Funcionario item) {

        try {

            //cria statement para alterar os dados dos campos da tabela funcionario
            ps = criaStatement.updateSql(campos);

            //cria um objeto pessoa com os dados pertencentes a tabela pessoa
            Pessoa pessoa = new Pessoa(
                    item.getPessoa().getId(),
                    item.getNome(),
                    item.getEmail(),
                    item.getDataNascimento(),
                    item.getCpf(),
                    item.getTelefone(),
                    item.getEndereco()
            );

            //altera a tabela pessoa também com os dados
            pessoaDao.alterar(pessoa);

            ps.setString(1, item.getMatricula());
            ps.setInt(2, item.getPessoa().getId());
            ps.setInt(3, item.getTipoFuncionario().getId());
            ps.setInt(4, item.getStatus().getId());
            ps.setDate(5, item.getDataRescisao());
            ps.setInt(6, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementDeletar(int id) {

        try {

            //cria um statement que pesquisa o funcionario com esse id
            ps = criaStatement.selectSql(tabela, true, this.id);

            rs = ps.executeQuery();

            if (rs.next()) {

                //pega o id referente à tabela pessoa
                int idPessoa = rs.getInt("fun_pes_iden");

                //e deleta o mesmo na tabela pessoa
                pessoaDao.deletar(idPessoa);

            } else {
                throw new Exception("Erro na remoção de um item Funcionario(parte de remoção por id pessoa para remover a pessoa)");
            }

            //cria o statemente para deletar o funcionario
            ps = criaStatement.deleteSql();

            ps.setInt(1, id);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementGetItem(int id) {

        try {

            //cria o statement que pesquisa por id na tabela funcionario
            ps = criaStatement.selectSql(tabela, true, this.id);
            
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                //pega o id referente à tabela pessoa na tabela funcionario
                int idPessoa = rs.getInt("fun_pes_iden");

                //cria um statement que pesquisa por id na tabela pessoa e retorna o mesmo
                psPessoa = criaStatement.selectSql("pessoas", true, "pes_iden");

                psPessoa.setInt(1, idPessoa);

            } else {
                throw new Exception("Erro na pesquisa de um item Funcionario(parte de pesquisa por id funcionario para pegar o id pessoa)");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return psPessoa;

    }

    @Override
    protected Funcionario criaItem(ResultSet rsPessoa) {

        try {

            //recebe um resultset com as informações da tabela pessoa referente ao id usado 
            //e cria um objeto Funcionario com essas informações e as do resultset normal de funcionario
            if (rsPessoa.next()) {
                return new Funcionario(
                        rs.getInt(id),
                        rs.getString(vetorCampos[0]),
                        pessoaDao.getByID(rs.getInt(vetorCampos[1])),
                        tipoFuncionarioDao.getByID(rs.getInt(vetorCampos[2])),
                        statusDao.getByID(rs.getInt(vetorCampos[3])),
                        rs.getDate(vetorCampos[4])
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
