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
import java.util.PriorityQueue;
import java.util.Queue;
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

    public FuncionarioDao() throws ClassNotFoundException, SQLException {

        Tabela obj = AbstractFactory.getInstance("HUMANO").getTabela("FUNCIONARIO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        pessoaDao = new PessoaDao();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "fun_matricula,fun_pes_iden,fun_tfu_iden,fun_sta_iden,fun_data_rescisao,fun_ativado";
        vetorCampos = campos.split(",");
        vetorCamposPessoa = pessoaDao.getVetorCampos();

    }

    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    @Override
    public Iterator<Funcionario> getAllDoubleOrderBy(int campo1, int campo2, boolean ascOuDesc1, boolean ascOuDesc2) throws Exception {

        ResultSet rs;

        //estrutura de dados 1 : Fila de prioridade
        Queue<Funcionario> itens = new PriorityQueue<Funcionario>();

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo1 < 0 || campo1 > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo1 para ser ordenado inexistente.");
        }
        if (campo2 < 0 || campo2 > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo2 para ser ordenado inexistente.");
        }

        //uma série de verificações sobre a ordem dos campos(se pertencem a qual tabela)
        //para a criação do preparedstatement com o sql correto para cada caso
        if (isPessoaCampo(campo1) && isPessoaCampo(campo2)) {

            ps = criaStatement.selectSqlOrderDuplaPessoaPessoa(
                    colunaPessoa(campo1),
                    colunaPessoa(campo2),
                    ascOuDesc1, ascOuDesc2);

        } else {
            if (isPessoaCampo(campo1) && isFuncionarioCampo(campo2)) {

                ps = criaStatement.selectSqlOrderDuplaPessoaFunc(
                        colunaPessoa(campo1),
                        colunaFuncionario(campo2),
                        ascOuDesc1, ascOuDesc2);

            } else {
                if (isFuncionarioCampo(campo1) && isPessoaCampo(campo2)) {

                    ps = criaStatement.selectSqlOrderDuplaFuncPessoa(
                            colunaFuncionario(campo1),
                            colunaPessoa(campo2),
                            ascOuDesc1, ascOuDesc2);

                } else {

                    ps = criaStatement.selectSqlOrderDuplaFuncFunc(
                            colunaFuncionario(campo1),
                            colunaFuncionario(campo2),
                            ascOuDesc1, ascOuDesc2);

                }
            }
        }

        //faz o pedido de busca conforme o PreparedStatement criado
        rs = ps.executeQuery();

        while (rs.next()) {
            //adiciona na fila de prioridade todos os itens
            itens.add(getByID(rs.getInt(id)));
        }

        return itens.iterator();

    }

    //campo é o número correspondente à propriedade conforme a ordem na tabela do banco de dados!(começa do 0)
    //ascOuDesc true para ordem ascendente e false para descendente
    @Override
    public Iterator<Funcionario> getAllOrderBy(int campo, boolean ascOuDesc) throws Exception {

        ResultSet rs;

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo para ser ordenado inexistente.");
        }

        //estrutura de dados 2 : Lista encadeada
        List<Funcionario> itens = new LinkedList<Funcionario>();

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (isPessoaCampo(campo)) {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlOrder("pessoas", colunaPessoa(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                if (checarPessoaFuncionario(rs.getInt("pes_iden"))) {
                    itens.add(getByIDPessoa(rs.getInt("pes_iden")));
                }
            }
        } else {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlOrder(tabela, colunaFuncionario(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {
                //adiciona na fila de prioridade todos os itens
                itens.add(getByID(rs.getInt(id)));
            }
        }

        return itens.iterator();

    }
    
    @Override
    public Iterator<Funcionario> getAllDeactivatedOrderBy(int campo, boolean ascOuDesc) throws Exception {

        ResultSet rs;

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo para ser ordenado inexistente.");
        }

        //estrutura de dados 2 : Lista encadeada
        List<Funcionario> itens = new LinkedList<Funcionario>();

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (isPessoaCampo(campo)) {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlDeativatedOrder("pessoas", colunaPessoa(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                if (checarPessoaFuncionario(rs.getInt("pes_iden"))) {
                    itens.add(getByIDPessoa(rs.getInt("pes_iden")));
                }
            }
        } else {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlDeativatedOrder(tabela, colunaFuncionario(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {
                //adiciona na fila de prioridade todos os itens
                itens.add(getByID(rs.getInt(id)));
            }
        }

        return itens.iterator();

    }
    
    public Iterator<Funcionario> getAllAllOrderBy(int campo, boolean ascOuDesc) throws Exception {

        ResultSet rs;

        //verifica se o número recebido é menor que 0 ou maior que o número máximo de campos
        if (campo < 0 || campo > vetorCampos.length + vetorCamposPessoa.length) {
            throw new Exception("Campo para ser ordenado inexistente.");
        }

        //estrutura de dados 2 : Lista encadeada
        List<Funcionario> itens = new LinkedList<Funcionario>();

        //vetorCampos é um vetor que contém o nome de todos os campos da tabela no banco de dados na ordem
        if (isPessoaCampo(campo)) {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlAllOrder("pessoas", colunaPessoa(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {

                //adiciona na fila de prioridade todos os itens
                if (checarPessoaFuncionario(rs.getInt("pes_iden"))) {
                    itens.add(getByIDPessoa(rs.getInt("pes_iden")));
                }
            }
        } else {

            //cria um sql que recebe todos os itens ordenados a coluna
            ps = criaStatement.selectSqlAllOrder(tabela, colunaFuncionario(campo), ascOuDesc);

            //faz o pedido de busca conforme o PreparedStatement criado
            rs = ps.executeQuery();

            while (rs.next()) {
                //adiciona na fila de prioridade todos os itens
                itens.add(getByID(rs.getInt(id)));
            }
        }

        return itens.iterator();

    }

    private boolean checarPessoaFuncionario(int idPessoa) throws Exception {

        Iterator<Funcionario> itens = new FuncionarioDao().getAll();
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

        if (!getAllAllOrderBy(9, false).hasNext()) {
            return 0;
        } else {
            Iterator<Funcionario> iterator = getAllAllOrderBy(9, false);
            return iterator.next().getId();
        }

    }
    
    @Override
    protected void verificaExistenteInserir(Funcionario item) throws Exception {
    }

    @Override
    protected void verificaExistenteAlterar(Funcionario item) throws Exception {
    }

    @Override
    protected PreparedStatement statementInserir(Funcionario item) throws Exception {

        ps = criaStatement.insertSql(tabela, campos);

        //insere uma pessoa com os valores recebidos
        pessoaDao.insert(
                new Pessoa(
                        0,
                        item.getNome(),
                        item.getEmail(),
                        item.getDataNascimento(),
                        item.getCpf(),
                        item.getTelefone(),
                        item.getEndereco(),
                        item.getCliente(),
                        item.getAtivado()
                )
        );

        //pesquisa essa pessoa que foi inserida por cpf e cria um objeto pessoa e passa seu id para o statement a ser usado
        Pessoa pessoa = pessoaDao.getByCpf(item.getCpf());

        ps.setString(1, item.getMatricula());
        ps.setInt(2, pessoa.getId());
        ps.setInt(3, item.getTipoFuncionario().getId());
        ps.setInt(4, item.getStatus().getId());
        ps.setDate(5, item.getDataRescisao());
        ps.setInt(6, item.getAtivado());

        return ps;
    }

    @Override
    protected PreparedStatement statementAlterar(Funcionario item) throws Exception {

        //cria statement para update os dados dos campos da tabela funcionario
        ps = criaStatement.updateSql(campos);

        //cria um objeto pessoa com os dados pertencentes a tabela pessoa
        Pessoa pessoa = new Pessoa(
                item.getPessoa().getId(),
                item.getNome(),
                item.getEmail(),
                item.getDataNascimento(),
                item.getCpf(),
                item.getTelefone(),
                item.getEndereco(),
                item.getCliente(),
                item.getAtivado()
        );

        //altera a tabela pessoa também com os dados
        pessoaDao.update(pessoa);

        ps.setString(1, item.getMatricula());
        ps.setInt(2, item.getPessoa().getId());
        ps.setInt(3, item.getTipoFuncionario().getId());
        ps.setInt(4, item.getStatus().getId());
        ps.setDate(5, item.getDataRescisao());
        ps.setInt(6, item.getAtivado());
        ps.setInt(7, item.getId());

        return ps;

    }

    @Override
    public boolean deactivate(int id) throws Exception {

        int idPessoa = getByID(id).getPessoa().getId();

        //cria um sql para deactivate o item
        ps = statementDesativar(id);

        ps.executeUpdate();

        pessoaDao.deactivate(idPessoa);

        return true;

    }

    @Override
    public boolean activate(int id) throws Exception {

        int idPessoa = getByID(id).getPessoa().getId();

        //cria um sql para deactivate o item
        ps = statementAtivar(id);

        ps.executeUpdate();

        pessoaDao.activate(idPessoa);

        return true;

    }

    @Override
    protected PreparedStatement statementGetItem(int id) throws Exception {

        //cria o statement que pesquisa por id na tabela funcionario
        ps = criaStatement.selectSql(tabela, true, this.id);

        ps.setInt(1, id);

        rs = ps.executeQuery();

        if (rs.next()) {

            //pega o id referente à tabela pessoa na tabela funcionario
            int idPessoa = rs.getInt("fun_pes_iden");

            //cria um statement que pesquisa por id na tabela pessoa e retorna o mesmo
            psPessoa = criaStatement.selectSql("pessoas", true, "pes_iden");

            psPessoa.setInt(1, idPessoa);

        }

        return psPessoa;

    }

    @Override
    protected Funcionario criaItem(ResultSet rsPessoa) throws Exception {

        //recebe um resultset com as informações da tabela pessoa referente ao id usado 
        //e cria um objeto Funcionario com essas informações e as do resultset normal de funcionario
        if (rsPessoa.next()) {
            return new Funcionario(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    pessoaDao.getByID(rs.getInt(vetorCampos[1])),
                    tipoFuncionarioDao.getByID(rs.getInt(vetorCampos[2])),
                    statusDao.getByID(rs.getInt(vetorCampos[3])),
                    rs.getDate(vetorCampos[4]),
                    rs.getInt(vetorCampos[5])
            );
        }

        return null;

    }

    public Funcionario getByIDPessoa(int idPessoa) throws Exception {

        ps = criaStatement.selectSql(tabela, true, "fun_pes_iden");

        ps.setInt(1, idPessoa);

        ResultSet rs = ps.executeQuery();

        Funcionario item = null;

        if (rs.next()) {
            item = new Funcionario(
                    rs.getInt(id),
                    rs.getString(vetorCampos[0]),
                    pessoaDao.getByID(rs.getInt(vetorCampos[1])),
                    tipoFuncionarioDao.getByID(rs.getInt(vetorCampos[2])),
                    statusDao.getByID(rs.getInt(vetorCampos[3])),
                    rs.getDate(vetorCampos[4]),
                    rs.getInt(vetorCampos[5])
            );
        }

        if (item == null) {
            throw new Exception("Erro ao encontrar um item Funcionario por id pessoa");
        }

        return item;

    }

    private boolean isPessoaCampo(int campo) {

        return campo < vetorCamposPessoa.length + 1;

    }

    private boolean isFuncionarioCampo(int campo) {

        return campo >= vetorCamposPessoa.length + 1;

    }

    private String colunaPessoa(int campo) {

        String coluna = "";

        if (campo == 0) {
            coluna = "pes_iden";
        } else {
            coluna = vetorCamposPessoa[campo - 1];
        }

        return coluna;

    }

    private String colunaFuncionario(int campo) {

        String coluna = "";

        if (campo == vetorCamposPessoa.length + 1) {
            coluna = id;
        } else {
            coluna = vetorCampos[campo - vetorCamposPessoa.length - 1];
        }

        return coluna;

    }

    public Funcionario verificaEmail(String email) throws Exception {
        
        Pessoa pessoa = pessoaDao.getByEmailFunc(email);
        
        if (pessoa == null)
            return null;
        else
            return getByIDPessoa(pessoa.getId());
        
    }

}
