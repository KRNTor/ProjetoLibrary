/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import br.com.library.comumEnum.Categoria;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
public class Livro {

    @Id
    @GeneratedValue
    private long id;
    private int ano;
    private String titulo;
    private String autor;
    private String editora;
    @Enumerated
    private Categoria categoria;
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", ano=" + ano + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", categoria=" + categoria + ", status=" + status + '}';
    }

}
