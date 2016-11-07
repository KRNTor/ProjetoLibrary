/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.testes;

import br.com.library.comumEnum.Categoria;
import br.com.library.comumEnum.Sexo;
import br.com.library.dao.ClienteDAO;
import br.com.library.dao.FuncionarioDAO;
import br.com.library.dao.LivroDao;
import br.com.library.model.Cliente;
import br.com.library.model.Endereco;
import br.com.library.model.Funcionario;
import br.com.library.model.Livro;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Felps
 */
public class TesteMain {

    public static void main(String[] a) throws Exception {

//        Livro l = new Livro(2016, "prefiro jdbc", "wanderson", "é nois", Categoria.AVENTURA, true);
//        LivroDao ld = new LivroDao();
        //ld.salvar(l);
//        Livro guardarLivro = ld.buscarById(8);
//        guardarLivro.setTitulo("Mocoronha");
//        ld.editar(guardarLivro);
//        System.out.println(ld.listarAll());
//        Endereco end = new Endereco("flores", "margarida", "123454", "paraiba");
//        Cliente c = new Cliente(Sexo.SEXOF, true, "Otto", 21, end, new Date(21/04/2016));
//          ClienteDAO cd = new ClienteDAO();
//          System.out.println(cd.buscarClienteCriteria());
//            
//        cd.cadastrarCliente(c);
//        Cliente guardar = cd.buscarCliente(3);
//        guardar.setNome("wanderson");
//        cd.editarCliente(guardar);

//        Endereco end = new Endereco("flores", "margarida", "123454", "paraiba");
//        Funcionario f = new Funcionario(Sexo.SEXOM, true, "rivaldo", 20, end, "Jogador", 250, 21);
        FuncionarioDAO fd = new FuncionarioDAO();
        System.out.println(fd.listaFuncionarioNameQuared());
        //  fd.cadastrarFuncionario(f);
//        Funcionario guardarf = fd.buscarFuncionario(6);
//        guardarf.setNome("galvao");
//        fd.editarFuncionario(guardarf);

          
    }
}
