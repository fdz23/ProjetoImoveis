/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricas;

import interfaces.Tabela;
import fabricasconcretas.*;

/**
 *
 * @author fdz
 */
public abstract class AbstractFactory {
    
    protected String tipo;
    
    public String getTipo(){ return tipo; }
    
    //retorna a instancia do objeto selecionado dentro do objeto selecionado
    public abstract Tabela getTabela(String tabela);
    
    //retorna a instancia do objeto selecionado
    public static AbstractFactory getInstance( String tipo ) { 
        if( tipo == null ) {
            return null; 
        }
        else if(tipo.equals("HUMANO")) { 
            return new Humano();
        }
        else if(tipo.equals("MATERIAL")) {
            return new Material(); 
        }
        else if(tipo.equals("VENDA")) {
            return new Venda();
        }
        else {return null;}
    }
}
