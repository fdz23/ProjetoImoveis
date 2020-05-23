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
    private String dataCadastro;
    private String nome;
    private double preco;
    private String itens;
    private String descricao;
    private int quantidadeParcelas;
    private double valorComissao;
    private int statusImovel;
    private String baixaImovel;
    private int idTipoImovel;
    private int idEndereco;
    private int idStatus;
    
    public Imovel() {}
    
    public Imovel(int id, String dataCadastro, String nome, double preco, String itens, String descricao, int quantidadeParcelas, 
            double valorComissao, int statusImovel, String baixaImovel, int idTipoImovel, int idEndereco, int idStatus) {
        
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.preco = preco;
        this.itens = itens;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorComissao = valorComissao;
        this.statusImovel = statusImovel;
        this.baixaImovel = baixaImovel;
        this.idTipoImovel = idTipoImovel;
        this.idEndereco = idEndereco;
        this.idStatus = idStatus;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

    public int getStatusImovel() {
        return statusImovel;
    }

    public void setStatusImovel(int statusImovel) {
        this.statusImovel = statusImovel;
    }

    public String getBaixaImovel() {
        return baixaImovel;
    }

    public void setBaixaImovel(String baixaImovel) {
        this.baixaImovel = baixaImovel;
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

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
}
