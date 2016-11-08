/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.facade;

import br.com.library.dao.DaoCliente;
import br.com.library.dao.IDaoCliente;
import br.com.library.model.Cliente;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Facade implements IFacade {

    private IDaoCliente daoCliente;

    public Facade() {
        this.daoCliente = new DaoCliente();
    }

    //CLIENTE
    @Override
    public void salvarCliente(Cliente cliente) throws Exception {
        this.daoCliente.cadastrarCliente(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) throws Exception {
        this.daoCliente.editarCliente(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {
        this.daoCliente.deletarCliente(cliente);
    }

    @Override
    public Cliente buscarClienteById(Long id) throws Exception {
        return this.daoCliente.buscarCliente(id);
    }

    @Override
    public Cliente buscarClienteByName(String nome) throws Exception {
        return this.daoCliente.buscarClienteNome(nome);
    }

    public List<Cliente> getClientes() throws Exception {
        return this.daoCliente.listarCliente();
    }

}
