/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author fdz
 */
public class Imovel {
    
    private int id;
    private String dataInclusao;
    private double preco;
    private double tamanho;
    private String observacao;
    private String baixaData;
    private String baixaMotivo;
    private double valorComissao;
    private int quantidadeParcelas;
    private int idTipoImovel;
    private int idEndereco;
    private int idPessoa;
    private int idFuncionario;
    
    public Imovel() {}
    
    public Imovel(int id, String dataInclusao, double preco, double tamanho, String observacao, String baixaData, String baixaMotivo, 
            int quantidadeParcelas, double valorComissao, int idFuncionario, int idPessoa, int idTipoImovel, int idEndereco) {
        
        this.id = id;
        this.dataInclusao = dataInclusao;
        this.tamanho = tamanho;
        this.preco = preco;
        this.observacao = observacao;
        this.baixaMotivo = baixaMotivo;
        this.valorComissao = valorComissao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.idFuncionario = idFuncionario;
        this.idTipoImovel = idTipoImovel;
        this.idEndereco = idEndereco;
        this.baixaData = baixaData;
        this.idPessoa = idPessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
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

    public String getBaixaData() {
        return baixaData;
    }

    public void setBaixaData(String baixaData) {
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

    public int getIdTipoImovel() {
        return idTipoImovel;
    }

    public void setIdTipoImovel(int idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
