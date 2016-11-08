/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import br.com.library.comumEnum.Sexo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Otto
 */
@Entity
public class Cliente extends Pessoa {

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    public Cliente() {

    }

    public Cliente(Sexo sexo, boolean status, String nome, int idade, Endereco end, Date dataCadastro) {
        super(sexo, status, nome, idade, end);
        this.dataCadastro = dataCadastro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dataCadastro=" + dataCadastro + '}';
    }

}
