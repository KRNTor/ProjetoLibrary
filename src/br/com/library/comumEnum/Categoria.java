/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.comumEnum;

/**
 *
 * @author Felps
 */
public enum Categoria {
    AUTOAJUDA("Autoajuda"),
    AVENTURA("Aventura"),
    BIOGRAFIA("Biografia"),
    CIENTIFICO("Científico"),
    FANTASIA("Fantasia"),
    FICCAOCIENTIFICA("Ficção Científica"),
    HORROR("Horror"),
    INFANTIL("Infantil");

    private String categoria;

    private Categoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return this.categoria;
    }
    
    @Override
    public String toString(){
        return this.categoria;
    }

}
