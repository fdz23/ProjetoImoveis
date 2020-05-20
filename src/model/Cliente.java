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
public class Cliente extends Pessoa {
    
    private int idPessoa;
    
    public Cliente() {}
    
    public Cliente(int id, int idPessoa, String nome, String email, String dataNascimento, String cpf, String telefone) {
        super(id, nome, email, dataNascimento, cpf, telefone);
        this.idPessoa = idPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}
