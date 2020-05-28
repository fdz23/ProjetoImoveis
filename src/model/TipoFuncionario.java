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
public class TipoFuncionario implements Tabela {
    
    private int id;
    private int idNivelAcesso;
    private Double salario;
    private String descricao;
    private String nomeId = "tfu_iden";
    private String nomeTabela = "tipo_funcionarios";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public TipoFuncionario() {}
    
    public TipoFuncionario(int id, String descricao, int idNivelAcesso, Double salario) {
        this.id = id;
        this.idNivelAcesso = idNivelAcesso;
        this.salario = salario;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public void setIdNivelAcesso(int idNivelAcesso) {
        this.idNivelAcesso = idNivelAcesso;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
