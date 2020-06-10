/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Array;
import java.sql.SQLException;
import model.interfaces.Tabela;

/**
 *
 * @author fdz
 */
public class NivelAcesso implements Tabela {
    
    private int id;
    private String descricao;
    private int ativado;
    private Array nivel;
    private String nomeId = "nac_iden";
    private String nomeTabela = "nivel_acessos";
    
    public boolean getNivelByIndex(int index) throws SQLException {
        
        Integer[] niveis = (Integer[]) nivel.getArray();
        
        return niveis[index] == 1;
    }
    
    public int getSomaNiveis() throws SQLException {
        
        Integer[] niveis = (Integer[]) nivel.getArray();
        int soma = 0;
        
        for (int i = 0; i < niveis.length; i++) {
            soma += niveis[i];
        }
        
        return soma;
    }

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    public NivelAcesso() {}
    
    public NivelAcesso(int id, String descricao, int ativado, Array nivel) {
        this.id = id;
        this.descricao = descricao;
        this.ativado = ativado;
        this.nivel = nivel;
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

    public Array getNivel() {
        return nivel;
    }

    public void setNivel(Array nivel) {
        this.nivel = nivel;
    }
    
}
