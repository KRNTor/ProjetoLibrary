/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author Otto
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Pessoa {
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private int idade;
    private boolean sexo;
    
    @OneToOne
    private Endereco enredeco; 
    
    public Pessoa(){
        
    }

    public Pessoa(String nome, int idade, boolean sexo, Endereco enredeco) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.enredeco = enredeco;
    }
        
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Endereco getEnredeco() {
        return enredeco;
    }

    public void setEnredeco(Endereco enredeco) {
        this.enredeco = enredeco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", enredeco=" + enredeco + '}';
    }
    
}
