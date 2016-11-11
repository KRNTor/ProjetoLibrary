/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.dao;

import br.com.library.model.Cliente;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Otto
 */
public interface IDaoCliente {

    void cadastrarCliente(Cliente c) throws Exception;

    void deletarCliente(Cliente c) throws Exception;

    void editarCliente(Cliente c) throws Exception;

    Cliente buscarCliente(long id) throws Exception;

    List<Cliente> listarCliente() throws Exception;

    Cliente buscarClienteNome(String nome) throws Exception;
    
    List<Cliente> buscarClienteCriteriaNome(String nome) throws Exception;

    List<Cliente> getAllCriteria() throws Exception;

    Criteria getCriteria() throws Exception;

}
