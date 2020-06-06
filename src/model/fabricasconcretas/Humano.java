/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fabricasconcretas;

import model.fabricas.AbstractFactory;
import model.interfaces.Tabela;
import model.*;

/**
 *
 * @author fdz
 */
public class Humano extends AbstractFactory {
    public Humano(){
        tipo = "HUMANO";
    }
    
    @Override
    public Tabela getTabela( String tipo ) { 
        if( tipo == null ) {
            return null; 
        }
        else if( tipo.equals("FUNCIONARIO") ) { 
            return new Funcionario();
        }
        else if( tipo.equals("NIVEL_ACESSO") ) {
            return new NivelAcesso(); 
        }
        else if( tipo.equals("PESSOA") ) {
            return new Pessoa(); 
        }
        else if( tipo.equals("TIPO_FUNCIONARIO") ) {
            return new TipoFuncionario(); 
        }
        else if( tipo.equals("USUARIO") ) {
            return new Usuario(); 
        }
        else { return null;} 
    }
}
