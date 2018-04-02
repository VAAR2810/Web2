/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Hugo
 */

@Entity
public class Livro {
    
    @Id
    @GeneratedValue
    private long id;
    private String titulo;
    private String autor;
    private String editora;
    @OneToOne(cascade = CascadeType.ALL)
    private Secao secao;

   public Livro(){
      secao = new Secao();
    }
   
    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", nome=" + titulo + ", autor=" + autor + ", editora=" + editora + '}';
    }
}
