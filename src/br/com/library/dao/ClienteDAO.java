package br.com.library.dao;

import br.com.library.interfaces.IClienteDao;
import br.com.library.model.Cliente;
import br.com.library.model.Livro;
import br.com.library.util.JPAUtil;
import br.com.library.util.StringUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Otto
 */
public class ClienteDAO implements IClienteDao {

    public void cadastrarCliente(Cliente c) throws Exception {

        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.persist(c);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_CADASTRAR));

        } finally {

            JPAUtil.close();

        }
    }

    public void deletarCliente(Cliente c) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.remove(c);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_DELETAR));

        } finally {

            JPAUtil.close();

        }

    }

    public void editarCliente(Cliente c) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.merge(c);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_EDITAR));

        } finally {

            JPAUtil.close();

        }
    }

    public Cliente buscarCliente(long id) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();
            return em.find(Cliente.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_BUSCAR));

        } finally {

            JPAUtil.close();

        }
    }

    @Override
    public Cliente buscarClienteNome(String nome) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome");
            query.setParameter("nome", nome);
            return (Cliente) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> listarCliente() throws Exception {
        List<Cliente> lista = null;
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            Query query = (Query) em.createQuery("SELECT c FROM Cliente c");

            // retorna todos os registros da entidade																// Contato
            lista = ((javax.persistence.Query) query).getResultList();

            // retorna a lista resultante da QueryQuery
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_LISTAR));

        } finally {

            JPAUtil.close();

        }

        return lista;
    }

    @Override
    public List<Cliente> buscarClienteCriteria() throws Exception {
        EntityManager em = null;
        List<Cliente> lista = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> root = cq.from(Cliente.class);
            cq.select(root);
            TypedQuery<Cliente> query = em.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
        }
        
       return null;
    }

}
