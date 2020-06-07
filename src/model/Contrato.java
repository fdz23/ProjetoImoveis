/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Tabela;
import java.sql.Date;

/**
 *
 * @author rapha
 */
public class Contrato implements Tabela {
    
    private int id;
    private Date data;
    private Date dataAlteracao;
    private int pago;
    private Orcamento orcamento;
    private int ativado;
    private String nomeId = "con_iden";
    private String nomeTabela = "contratos";
    
    public Contrato() {}
    
    public Contrato(int id, Date dataOrcamento, Date dataAlteracao, int pago, Orcamento orcamento, int ativado) {
        this.id = id;
        this.data = dataOrcamento;
        this.dataAlteracao = dataAlteracao;
        this.pago = pago;
        this.orcamento = orcamento;
        this.ativado = ativado;
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

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setIdOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }
    
}
