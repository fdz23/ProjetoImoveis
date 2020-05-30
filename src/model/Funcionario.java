/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Tabela;
import java.sql.Date;

/**
 *
 * @author fdz
 */
public class Funcionario extends Pessoa implements Tabela {
    
    private int idStatus;
    private Date dataRescisao;
    private String matricula;
    private int idTipoFuncionario;
    private int idPessoa;
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
    
    public Funcionario() {}
    
    public Funcionario(String nome, String email, Date dataNascimento, String cpf, String telefone, int idEndereco,
                       int id, String matricula, int idPessoa, int idTipoFuncionario, int idStatus, Date dataRescisao) {
        
        super(id, nome, email, dataNascimento, cpf, telefone, idEndereco);
        this.idPessoa = idPessoa;
        this.idTipoFuncionario = idTipoFuncionario;
        this.matricula = matricula;
        this.idStatus = idStatus;
        this.dataRescisao = dataRescisao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public Date getDataRescisao() {
        return dataRescisao;
    }

    public void setDataRescisao(Date dataRescisao) {
        this.dataRescisao = dataRescisao;
    }
    
}
