/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaces.Tabela;
import java.sql.Date;

/**
 *
 * @author fdz
 */
public class Funcionario extends Pessoa implements Tabela {
    
    private int id;
    private Status status;
    private Date dataRescisao;
    private String matricula;
    private TipoFuncionario tipoFuncionario;
    private Pessoa pessoa;
    private int ativado;
    private String nomeId = "fun_iden";
    private String nomeTabela = "funcionarios";

    @Override
    public String getNomeId() {
        return nomeId;
    }

    @Override
    public String getNomeTabela() {
        return nomeTabela;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    public Funcionario() {}
    
    public Funcionario(int id, String matricula, Pessoa pessoa, TipoFuncionario tipoFuncionario, Status status, Date dataRescisao, int ativado) {
        
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getDataNascimento(), pessoa.getCpf(), pessoa.getTelefone(), pessoa.getEndereco(), pessoa.getCliente(), pessoa.getAtivado());
        this.pessoa = pessoa;
        this.tipoFuncionario = tipoFuncionario;
        this.matricula = matricula;
        this.status = status;
        this.dataRescisao = dataRescisao;
        this.id = id;
        this.ativado = ativado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataRescisao() {
        return dataRescisao;
    }

    public void setDataRescisao(Date dataRescisao) {
        this.dataRescisao = dataRescisao;
    }

    public int getAtivado() {
        return ativado;
    }

    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }
    
}
