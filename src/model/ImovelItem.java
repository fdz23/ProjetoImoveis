/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Tabela;

/**
 *
 * @author fdz
 */
public class ImovelItem implements Tabela {
    
    private int id;
    private double valor;
    private int idItemMovel;
    private int idImovel;
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
    
    public ImovelItem(int id, double valor, int idItemMovel, int idImovel) {
        this.id = id;
        this.valor = valor;
        this.idImovel = idImovel;
        this.idItemMovel = idItemMovel;
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

    public int getIdItemMovel() {
        return idItemMovel;
    }

    public void setIdItemMovel(int idItemMovel) {
        this.idItemMovel = idItemMovel;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }
}
