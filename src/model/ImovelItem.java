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
public class ImovelItem {
    
    private int id;
    private double valor;
    private int idItemMovel;
    private int idImovel;
    
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
