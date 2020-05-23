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
public class TipoFuncionario {
    
    private int id;
    private String cargo;
    private int idNivelAcesso;
    private Double salario;
    private String descricao;
    
    public TipoFuncionario() {}
    
    public TipoFuncionario(int id, String cargo, int idNivelAcesso, Double salario, String descricao) {
        this.id = id;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
