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
public class Orcamento {
    
    private int id;
    private String dataOrcamento;
    private double valorOrcamento;
    private String descricao;
    private int quantidadeParcelas;
    private int idTipoPagamento;
    private int idPessoa;
    private int idFuncionario;
    private int idImovel;
    
    public Orcamento() {}
    
    public Orcamento(int id, String dataOrcamento, double valorOrcamento, String descricao, int quantidadeParcelas, int idTipoPagamento, int idPessoa, int idFuncionario, int idImovel) {
        this.id = id;
        this.dataOrcamento = dataOrcamento;
        this.idFuncionario = idFuncionario;
        this.idImovel = idImovel;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeParcelas = quantidadeParcelas;
        this.descricao = descricao;
        this.idTipoPagamento = idTipoPagamento;
        this.idPessoa = idPessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(String dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public double getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(double valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
}
