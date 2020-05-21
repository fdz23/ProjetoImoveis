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
    private double altura;
    private double comprimento;
    private double largura;
    private int quantidadeQuartos;
    private int quantidadeSuites;
    private boolean banheira;
    private int quantidadeParcelas;
    private String endereco;
    private double valorComissao;
    private int statusImovel;
    private String baixaImovel;
    private String baixaMotivo;
    private int idTipoImovel;
    
    public Imovel() {}
    
    public Imovel(int id, String dataCadastro, String nome, double preco, double altura, double comprimento, 
            double largura, int quantidadeQuartos, int quantidadeSuites, boolean banheira, int quantidadeParcelas, 
            String endereco, double valorComissao, int statusImovel, String baixaImovel, String baixaMotivo, int idTipoImovel) {
        
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.preco = preco;
        this.altura = altura;
        this.comprimento = comprimento;
        this.largura = largura;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeParcelas = quantidadeParcelas;
        this.quantidadeSuites = quantidadeSuites;
        this.banheira = banheira;
        this.endereco = endereco;
        this.valorComissao = valorComissao;
        this.statusImovel = statusImovel;
        this.baixaImovel = baixaImovel;
        this.baixaMotivo = baixaMotivo;
        this.idTipoImovel = idTipoImovel;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(int quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public boolean isBanheira() {
        return banheira;
    }

    public void setBanheira(boolean banheira) {
        this.banheira = banheira;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getBaixaMotivo() {
        return baixaMotivo;
    }

    public void setBaixaMotivo(String baixaMotivo) {
        this.baixaMotivo = baixaMotivo;
    }

    public int getIdTipoImovel() {
        return idTipoImovel;
    }

    public void setIdTipoImovel(int idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
    }
}
