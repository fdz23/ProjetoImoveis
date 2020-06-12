/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Tabela;
import java.sql.Date;
import java.util.Iterator;

/**
 *
 * @author fdz
 */
public class Imovel implements Tabela {
    
    private int id;
    private Date dataInclusao;
    private double preco;
    private double tamanho;
    private String observacao;
    private Date baixaData;
    private String baixaMotivo;
    private double valorComissao;
    private int quantidadeParcelas;
    private TipoImovel tipoImovel;
    private Endereco endereco;
    private Pessoa pessoa;
    private Funcionario funcionario;
    private int ativado;
    private String descricao;
    private Iterator<ImovelItem> itensImovel;
    private String nomeId = "imo_iden";
    private String nomeTabela = "imoveis";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public Imovel() {}
    
    public Imovel(int id, Date dataInclusao, double preco, double tamanho, String observacao, Date baixaData, String baixaMotivo, 
            int quantidadeParcelas, double valorComissao, Funcionario funcionario, Pessoa pessoa, TipoImovel tipoImovel, Endereco endereco, 
            int ativado, String descricao, Iterator<ImovelItem> itensImovel) {
        
        this.id = id;
        this.dataInclusao = dataInclusao;
        this.tamanho = tamanho;
        this.preco = preco;
        this.observacao = observacao;
        this.baixaMotivo = baixaMotivo;
        this.valorComissao = valorComissao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.funcionario = funcionario;
        this.tipoImovel = tipoImovel;
        this.endereco = endereco;
        this.baixaData = baixaData;
        this.pessoa = pessoa;
        this.ativado = ativado;
        this.descricao = descricao;
        this.itensImovel = itensImovel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getBaixaData() {
        return baixaData;
    }

    public void setBaixaData(Date baixaData) {
        this.baixaData = baixaData;
    }
    
    public String getBaixaMotivo() {
        return baixaMotivo;
    }

    public void setBaixaMotivo(String baixaMotivo) {
        this.baixaMotivo = baixaMotivo;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel idTipoImovel) {
        this.tipoImovel = idTipoImovel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Iterator<ImovelItem> getItensImovel() {
        return itensImovel;
    }

    public void setItensImovel(Iterator<ImovelItem> itensImovel) {
        this.itensImovel = itensImovel;
    }
}
