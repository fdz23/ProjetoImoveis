/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fdz
 */
public class Funcionario extends Pessoa {
    
    private int idPessoa;
    private int idTipoPessoa;
    private double salario;
    private String senha;
    
    public Funcionario() {}
    
    public Funcionario(int id, int idPessoa, String nome, String email, String dataNascimento, String cpf, String telefone, int idTipoPessoa, double salario, String senha) {
        super(id, nome, email, dataNascimento, cpf, telefone);
        this.idPessoa = idPessoa;
        this.idTipoPessoa = idTipoPessoa;
        this.salario = salario;
        this.senha = senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(int idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
