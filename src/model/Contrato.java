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
public class Contrato {
    
    private int id;
    private String dataOrcamento;
    private String dataAlteracao;
    private int idSituacao;
    private int idOrcamento;
    
    public Contrato() {}
    
    public Contrato(int id, String dataOrcamento, String dataAlteracao, int idSituacao, int idOrcamento) {
        this.id = id;
        this.dataOrcamento = dataOrcamento;
        this.dataAlteracao = dataAlteracao;
        this.idSituacao = idSituacao;
        this.idOrcamento = idOrcamento;
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

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public int getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(int idSituacao) {
        this.idSituacao = idSituacao;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }
    
}
