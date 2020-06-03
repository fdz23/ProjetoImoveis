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
import javax.swing.JOptionPane;
import model.Orcamento;
import util.CriaStatement;

/**
 *
 * @author fdz
 */
public class OrcamentoDao extends Dao<Orcamento> {
    
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private PessoaDao pessoaDao = new PessoaDao();
    private ImovelDao imovelDao = new ImovelDao();
    private TipoPagamentoDao tipoPagamentoDao = new TipoPagamentoDao();

    public OrcamentoDao() throws ClassNotFoundException {

        Tabela obj = AbstractFactory.getInstance("VENDA").getTabela("ORCAMENTO");

        this.id = obj.getNomeId();
        this.tabela = obj.getNomeTabela();
        this.criaStatement = new CriaStatement(con, tabela, id);
        campos = "orc_data,orc_descricao,orc_func_iden,orc_pes_iden,orc_imo_iden,orc_tpa_iden";
        vetorCampos = campos.split(",");

    }
    
    public Orcamento getByIdImovel(int idImovel) {

        try {

            ps = statementByIdImovel(idImovel);

            rs = ps.executeQuery();

            return criaItem(rs);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return null;

    }

    protected PreparedStatement statementByIdImovel(int idImovel) {

        try {

            ps = criaStatement.selectSql(tabela, true, "nac_descricao");

            ps.setInt(1, idImovel);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return ps;
    }
    
    @Override
    protected void verificaExistente(Orcamento item) throws Exception {
    
        if (getByIdImovel(item.getImovel().getId()) != null)
            throw new Exception("Já existe um Orçamento sobre este imóvel.");
    
    }

    @Override
    protected PreparedStatement statementInserir(Orcamento item) {

        try {

            ps = criaStatement.insertSql(tabela, campos);

            ps.setDate(1, item.getData());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getFuncionario().getId());
            ps.setInt(4, item.getPessoa().getId());
            ps.setInt(5, item.getImovel().getId());
            ps.setInt(6, item.getTipoPagamento().getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected PreparedStatement statementAlterar(Orcamento item) {

        try {

            ps = criaStatement.updateSql(campos);

            ps.setDate(1, item.getData());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getFuncionario().getId());
            ps.setInt(4, item.getPessoa().getId());
            ps.setInt(5, item.getImovel().getId());
            ps.setInt(6, item.getTipoPagamento().getId());
            ps.setInt(7, item.getId());

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        return ps;

    }

    @Override
    protected Orcamento criaItem(ResultSet rs) {

        try {

            if (rs.next()) {

                return new Orcamento(
                        rs.getInt(id),
                        rs.getDate(vetorCampos[0]),
                        rs.getString(vetorCampos[1]),
                        funcionarioDao.getByID(rs.getInt(vetorCampos[2])),
                        pessoaDao.getByID(rs.getInt(vetorCampos[3])),
                        imovelDao.getByID(rs.getInt(vetorCampos[4])),
                        tipoPagamentoDao.getByID(rs.getInt(vetorCampos[5]))
                );

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return null;

    }

}
