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
public class Funcionario extends Pessoa{
    
    private String cargo;
    private int salario;
    private int dataAdmicao;

    public Funcionario(String nome, int idade, boolean sexo, Endereco end,String cargo, int salario, int dataAdmicao) {
        super (nome, idade, sexo, end);
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmicao = dataAdmicao;
    }

    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getDataAdmicao() {
        return dataAdmicao;
    }

    public void setDataAdmicao(int dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + ", salario=" + salario + ", dataAdmicao=" + dataAdmicao + '}';
    }
    
    
    
}
