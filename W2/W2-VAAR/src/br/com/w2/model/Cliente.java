/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugo
 */

@Entity // Informa ao Hibernate que a classe Contato está associada a uma Tabela no banco
public class Cliente {
    
    @Id // Informa a coluna que será a chave primária
    @GeneratedValue
    private long id;
    private String nome;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
   
    public Cliente(){
        endereco = new Endereco();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
       return "Id: " + id + " - Nome: " + nome + " - E-mail: " + email;
    }
}
