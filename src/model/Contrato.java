/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Tabela;
import java.sql.Date;

/**
 *
 * @author fdz
 */
public class Contrato implements Tabela {
    
    private int id;
    private Date data;
    private Date dataAlteracao;
    private int idSituacao;
    private int idOrcamento;
    private String nomeId = "con_iden";
    private String nomeTabela = "contratos";
    
    public Contrato() {}
    
    public Contrato(int id, Date dataOrcamento, Date dataAlteracao, int idSituacao, int idOrcamento) {
        this.id = id;
        this.data = dataOrcamento;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
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

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
}
