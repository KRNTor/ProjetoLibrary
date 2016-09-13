/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.interfaces;


import br.com.library.model.Cliente;
import java.util.List;

/**
 *
 * @author Otto
 */
public interface IClienteDao {
     public void cadastrarCliente(Cliente c) throws Exception;

    public void deletarCliente(Cliente c) throws Exception;

    public void editarCliente(Cliente c) throws Exception;

    public Cliente buscarCliente(long id) throws Exception;
    
    public List<Cliente> listarCliente() throws Exception;
    
    public Cliente buscarClienteNome(String nome) throws Exception;
    
}
