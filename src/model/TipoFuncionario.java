/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Tabela;

/**
 *
 * @author fdz
 */
public class TipoFuncionario implements Tabela {
    
    private int id;
    private NivelAcesso nivelAcesso;
    private Double salario;
    private String descricao;
    private int login;
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
    
    public TipoFuncionario(int id, String descricao, NivelAcesso nivelAcesso, Double salario, int login) {
        this.id = id;
        this.nivelAcesso = nivelAcesso;
        this.salario = salario;
        this.descricao = descricao;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
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

    
    public int getLogin() {
        return login;
    }

   
    public void setLogin(int login) {
        this.login = login;
    }
    
}
