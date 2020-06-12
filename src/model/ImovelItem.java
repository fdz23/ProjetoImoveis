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
public class ImovelItem implements Tabela {
    
    private int id;
    private double valor;
    private String descricao;
    private int imovel;
    private int ativado;
    private String nomeId = "iit_iden";
    private String nomeTabela = "imoveis_itens";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public ImovelItem() {}
    
    public ImovelItem(int id, double valor, String descricao, int imovel, int ativado) {
        this.id = id;
        this.valor = valor;
        this.imovel = imovel;
        this.descricao = descricao;
        this.ativado = ativado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImovel() {
        return imovel;
    }

    public void setImovel(int imovel) {
        this.imovel = imovel;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }
}
