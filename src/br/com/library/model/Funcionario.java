/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import br.com.library.comumEnum.Sexo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Otto
 */
@Entity
@NamedQuery(name = "Funcionario.listarAll", query = "select f from Funcionario f")
public class Funcionario extends Pessoa {

    private String cargo;
    private int salario;
    @Temporal(TemporalType.DATE)
    private Date dataAdmicao;

    public Funcionario() {
    }

    public Funcionario(Sexo sexo, boolean status, String nome, int idade, Endereco end, String cargo, int salario, Date dataAdmicao) {
        super(sexo, status, nome, idade, end);
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

    public Date getDataAdmicao() {
        return dataAdmicao;
    }

    public void setDataAdmicao(Date dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + ", salario=" + salario + ", dataAdmicao=" + dataAdmicao + '}';
    }

}
