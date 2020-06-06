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
public class NivelAcesso implements Tabela {
    
    private int id;
    private String descricao;
    private int ativado;
    private String nomeId = "nac_iden";
    private String nomeTabela = "nivel_acessos";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public NivelAcesso() {}
    
    public NivelAcesso(int id, String descricao, int ativado) {
        this.id = id;
        this.descricao = descricao;
        this.ativado = ativado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }
    
}
