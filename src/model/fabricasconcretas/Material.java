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
public class Material extends AbstractFactory {
    public Material(){
        tipo = "MATERIAL";
    }
    
    @Override
    public Tabela getTabela( String tipo ) { 
        if( tipo == null ) {
            return null; 
        }
        else if( tipo.equals("ENDERECO") ) { 
            return new Endereco();
        }
        else if( tipo.equals("IMOVEL") ) {
            return new Imovel(); 
        }
        else if( tipo.equals("IMOVEL_ITEM") ) {
            return new ImovelItem(); 
        }
        else if( tipo.equals("ITEM_MOVEL") ) {
            return new ItemMovel(); 
        }
        else if( tipo.equals("TIPO_IMOVEL") ) {
            return new TipoImovel(); 
        }
        else { return null;} 
    }
}
