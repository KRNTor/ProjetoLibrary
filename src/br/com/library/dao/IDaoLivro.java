/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.dao;


import br.com.library.model.Livro;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Felps
 */
public interface IDaoLivro {
    
    public void salvar(Livro livro) throws Exception;
    
    public Livro buscar(String titulo) throws Exception;
    
    public Livro buscarById(long id) throws Exception;
    
    public void editar(Livro livro) throws Exception;
    
    public void remover(Livro livro) throws Exception;
    
    public List<Livro> listarAll() throws Exception;
    
    public List<Livro> listarNamed() throws Exception;
    
    public Livro buscarNamed (String autor) throws Exception;
    
   List<Livro> getCriteriaAutor(String outor) throws Exception;

   Criteria getCriteria() throws Exception;
    
}
