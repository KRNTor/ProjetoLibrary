/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.testes;

import br.com.library.comumEnum.Categoria;
import br.com.library.dao.LivroDao;
import br.com.library.model.Livro;
import java.util.Scanner;

/**
 *
 * @author Felps
 */
public class TesteMain {

    public static void main(String[] a) {
        Scanner in = new Scanner(System.in);
        System.out.println("INFORME O TITULO DO LIVRO: ");
        String titulo = in.nextLine();
        try {
            Livro l = new LivroDao().buscar(titulo);
            System.out.println("Livro: " + l.toString() + "\n");

            new LivroDao().remover(l);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
