/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Tabela;
import java.sql.Date;

/**
 *
 * @author fdz
 */
public class Orcamento implements Tabela {
    
    private int id;
    private Date data;
    private String descricao;
    private TipoPagamento tipoPagamento;
    private Pessoa pessoa;
    private Funcionario funcionario;
    private Imovel imovel;
    private String nomeId = "orc_iden";
    private String nomeTabela = "orcamentos";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public Orcamento() {}
    
    public Orcamento(int id, Date data, String descricao, Funcionario funcionario, Pessoa pessoa, Imovel imovel, TipoPagamento tipoPagamento) {
        this.id = id;
        this.data = data;
        this.funcionario = funcionario;
        this.imovel = imovel;
        this.descricao = descricao;
        this.tipoPagamento = tipoPagamento;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
