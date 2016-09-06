/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.interfaces;

import br.com.library.model.Livro;

/**
 *
 * @author Felps
 */
public interface ILivroDao {
    
    public void salvar(Livro livro) throws Exception;
    
    public Livro buscar(String titulo) throws Exception;
    
    public Livro buscarById(Long id) throws Exception;
    
    public void editar(Livro livro) throws Exception;
    
    public void remover(Livro livro) throws Exception;
    
}
