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
    private ItemMovel itemMovel;
    private Imovel imovel;
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
    
    public ImovelItem(int id, double valor, ItemMovel itemMovel, Imovel imovel) {
        this.id = id;
        this.valor = valor;
        this.imovel = imovel;
        this.itemMovel = itemMovel;
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

    public ItemMovel getItemMovel() {
        return itemMovel;
    }

    public void setItemMovel(ItemMovel itemMovel) {
        this.itemMovel = itemMovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
}
