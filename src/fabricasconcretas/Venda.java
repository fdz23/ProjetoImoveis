/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricasconcretas;

import fabricas.AbstractFactory;
import interfaces.Tabela;
import model.*;

/**
 *
 * @author fdz
 */
public class Venda extends AbstractFactory {
    public Venda(){
        tipo = "VENDA";
    }
    
    @Override
    public Tabela getTabela( String tipo ) { 
        if( tipo == null ) {
            return null; 
        }
        else if( tipo.equals("CONTRATO") ) { 
            return new Contrato();
        }
        else if( tipo.equals("ORCAMENTO") ) {
            return new Orcamento(); 
        }
        else if( tipo.equals("SITUACAO") ) {
            return new Situacao(); 
        }
        else if( tipo.equals("STATUS") ) {
            return new Status(); 
        }
        else if( tipo.equals("TIPO_PAGAMENTO") ) {
            return new TipoPagamento(); 
        }
        else { return null;} 
    }
}
