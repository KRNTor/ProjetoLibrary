/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import javax.persistence.Entity;

/**
 *
 * @author Otto
 */
@Entity
public class Cliente extends Pessoa{
    private int dataCadastro;

    public Cliente(String nome ,int idade, boolean sexo, Endereco end , int dataCadastro) {
        super(nome , idade , sexo, end);
        this.dataCadastro = dataCadastro;
    }
    
    public int getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(int dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dataCadastro=" + dataCadastro + '}';
    }
    
    
    
}
