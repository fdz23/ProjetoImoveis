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
    private Date dataOrcamento;
    private int idFuncionario;
    private int idCliente;
    private int idImovel;
    private double valorOrcamento;
    private int quantidadeParcelas;
    
    public Orcamento() {}
    
    public Orcamento(int id, Date dataOrcamento, int idFuncionario, int idCliente, int idImovel, double valorOrcamento, int quantidadeParcelas) {
        this.id = id;
        this.dataOrcamento = dataOrcamento;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idImovel = idImovel;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
    
}
