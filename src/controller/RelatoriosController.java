/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RelatoriosDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fdz
 */
public class RelatoriosController {
    
    private RelatoriosDao dao;
    private DefaultTableModel model;
    
    public RelatoriosController(DefaultTableModel model) throws SQLException {
        
        dao = new RelatoriosDao();
        this.model = model;
        
    }
     public RelatoriosController( ) throws SQLException {
        dao = new RelatoriosDao();
        this.model = model;
       
    }
    
    public DefaultTableModel populaImoveisPorFuncionario(int idFuncionario) throws Exception {

        return populaJTable(dao.getImoveisByFuncionario(idFuncionario));

    }
    
    public DefaultTableModel populaImoveisFinanciadosPorData(int mes, int ano) throws Exception {

        return populaJTable(dao.getImoveisFinanciadosByData(mes, ano));

    }
    
    public DefaultTableModel populaImoveisPorCidadePeriodoTipoImovel(String cidade, int mes, int ano, int idTipoImovel) throws Exception {

        return populaJTable(dao.getImoveisByCidadePeriodoTipoImovel(cidade, mes, ano, idTipoImovel));

    }
    
    public DefaultTableModel populaImoveisBaixadosPorBaixa(String baixa) throws Exception {

        return populaJTable(dao.getImoveisBaixadosByBaixa(baixa));

    }
    
    public DefaultTableModel populaImoveisPorCpf(String cpf) throws Exception {

        return populaJTable(dao.getImoveisByCpf(cpf));

    }
    
    public DefaultTableModel populaCalculoComissaoPorImovel() throws Exception {

        return populaJTable(dao.getCalculoComissaoPorImovel());

    }
    
    public DefaultTableModel populaImoveisPorVendaAnual(int ano) throws Exception {

        return populaJTable(dao.getImoveisPorVendaAnual(ano));

    }
    
    public DefaultTableModel populaImoveisPorVendaMensal(int ano, int mes) throws Exception {

        return populaJTable(dao.getImoveisPorVendaMensal(ano, mes));

    }
    
    public DefaultTableModel populaImoveisDisponiveisPorSituacao(String situacao) throws Exception {

        return populaJTable(dao.getImoveisDisponiveisPorSituacao(situacao));

    }
    
    public DefaultTableModel populaImoveisCadastrados() throws Exception {

        return populaJTable(dao.getImoveisCadastrados());

    }
    
    private DefaultTableModel populaJTable(Iterator<Object[]> lista) {
        
        model.setNumRows(0);

        while (lista.hasNext()) {
                
            model.addRow(lista.next());

        }

        return model;
        
    }
    
    public ArrayList<String>PopularListaCidades () throws Exception{
        
      ArrayList<String> cidades = dao.getCidadesCadastradas();
        
      return cidades;
        
        
    }
}
