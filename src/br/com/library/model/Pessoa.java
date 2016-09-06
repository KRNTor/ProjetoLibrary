/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import br.com.library.comumEnum.Sexo;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

    @Enumerated
    private Sexo sexo;

    private boolean status;
    private String nome;
    private int idade;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enredeco;

    public Pessoa() {

    }

    public Pessoa(Sexo sexo, boolean status, String nome, int idade, Endereco enredeco) {
        this.sexo = sexo;
        this.status = status;
        this.nome = nome;
        this.idade = idade;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
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
