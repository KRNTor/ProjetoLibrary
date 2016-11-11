/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.testes;

import br.com.library.comumEnum.Categoria;
import br.com.library.comumEnum.Sexo;
import br.com.library.dao.DaoCliente;
import br.com.library.dao.DaoFuncionario;
import br.com.library.dao.DaoLivro;
import br.com.library.model.Cliente;
import br.com.library.model.Endereco;
import br.com.library.model.Livro;
import java.util.Date;

/**
 *
 * @author Felps
 */
public class TesteMain {

    public static void main(String[] a) throws Exception {
//        Endereco end = new Endereco("s", "s","s" , "s", "s");
//        Cliente c = new Cliente(Sexo.SEXOM, true, "otto", 10, end, new Date("21/04/1995"));
        DaoCliente cd = new DaoCliente();
//        cd. cadastrarCliente(c);
        
//Livro l = new Livro(200, "s", "s", "s", Categoria.AVENTURA, true);
        DaoLivro dl= new DaoLivro();
        //dl.salvar(l);
//        System.out.println("lista " +dl.buscarNamed("s"));//namedquery
//        System.out.println("listar " +cd.buscarClienteNome("otto")); //jpql
          System.out.println("listar " + cd.buscarClienteCriteriaNome("otto"));
          System.out.println("listar " + dl.getCriteriaAutor("s"));
//        System.out.println("listar" + cd.getAllCriteria());
//        System.out.println("listar " + dl.getAllCriteria());
    }
}
