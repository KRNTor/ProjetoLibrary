/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.comumEnum;



/**
 *
 * @author Otto
 */

public enum Sexo {
    SEXOM("MASCULINO"),
    SEXOF("FEMININO");

    private Sexo(String sexo) {
        this.sexo = sexo;
    }
    
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Sexo{" + "sexo=" + sexo + '}';
    }
    
    
}
