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
    
    private double salario;
    private String dataPrimeiroSalario;
    private String dataUltimoSalario;
    private String matricula;
    private String dataContratacao;
    private int idTipoFuncionario;
    private int idPessoa;
    
    public Funcionario() {}
    
    public Funcionario( int id, double salario, String dataPrimeiroSalario, String dataUltimoSalario, String matricula, String dataContratacao, 
                        int idTipoFuncionario, int idPessoa, String nome, String email, String dataNascimento, String cpf, String telefone) {
        
        super(id, nome, email, dataNascimento, cpf, telefone);
        this.idPessoa = idPessoa;
        this.idTipoFuncionario = idTipoFuncionario;
        this.salario = salario;
        this.dataPrimeiroSalario = dataPrimeiroSalario;
        this.dataUltimoSalario = dataUltimoSalario;
        this.matricula = matricula;
        this.dataContratacao = dataContratacao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataPrimeiroSalario() {
        return dataPrimeiroSalario;
    }

    public void setDataPrimeiroSalario(String dataPrimeiroSalario) {
        this.dataPrimeiroSalario = dataPrimeiroSalario;
    }

    public String getDataUltimoSalario() {
        return dataUltimoSalario;
    }

    public void setDataUltimoSalario(String dataUltimoSalario) {
        this.dataUltimoSalario = dataUltimoSalario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
