/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Otto
 */
@Entity
public class Endereco {

    @Id
    @GeneratedValue
    private long idEndereco;
    private String rua;
    private String bairro;
    private String cep;
    private String estado;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String cep, String estado, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
    }

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", rua=" + rua + ", bairro=" + bairro + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + '}';
    }


}
