/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.facade;

import br.com.library.model.Cliente;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface IFacade {

    void salvarCliente(Cliente cliente) throws Exception;

    void editarCliente(Cliente cliente) throws Exception;

    void removerCliente(Cliente cliente) throws Exception;

    Cliente buscarClienteById(Long id) throws Exception;

    Cliente buscarClienteByName(String nome) throws Exception;

    List<Cliente> getClientes() throws Exception;

}
