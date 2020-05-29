/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Tabela;

/**
 *
 * @author fdz
 */
public class Endereco implements Tabela {
    
    private int id;
    private String codigoIBGE;
    private String cidade;
    private String bairro;
    private String estado;
    private String numero;
    private String pontoReferencia;
    private String cep;
    private String logradouro;
    private String complemento;
    private String nomeId = "end_iden";
    private String nomeTabela = "enderecos";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public Endereco() {}
    
    public Endereco(int id, String codigoIBGE, String logradouro, String bairro, String cidade, String estado, String complemento, String numero, String pontoReferencia, String cep) {
        this.id = id;
        this.codigoIBGE = codigoIBGE;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.numero = numero;
        this.pontoReferencia = pontoReferencia;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}
