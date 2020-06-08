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
public class Usuario implements Tabela {
    
    private int id;
    private Funcionario funcionario;
    private String senha;
    private int ativado;
    private String nomeId = "usu_iden";
    private String nomeTabela = "usuarios";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario() {}
    
    public Usuario(int id, Funcionario funcionario, String senha, int ativado) {
        this.id = id;
        this.senha = senha;
        this.funcionario = funcionario;
        this.ativado = ativado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
}
