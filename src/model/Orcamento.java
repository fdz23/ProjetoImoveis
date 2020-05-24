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
    private String data;
    private String descricao;
    private int idTipoPagamento;
    private int idPessoa;
    private int idFuncionario;
    private int idImovel;
    
    public Orcamento() {}
    
    public Orcamento(int id, String data, String descricao, int idFuncionario, int idPessoa, int idImovel, int idTipoPagamento) {
        this.id = id;
        this.data = data;
        this.idFuncionario = idFuncionario;
        this.idImovel = idImovel;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
