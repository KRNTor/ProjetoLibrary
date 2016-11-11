package br.com.library.dao;

import br.com.library.model.Cliente;
import br.com.library.util.JPAUtil;
import br.com.library.util.StringUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Otto
 */
public class DaoCliente implements IDaoCliente {

    private Class clazz;
    EntityManager em = null;
    private Session session;

    public DaoCliente() {

    }

    public void cadastrarCliente(Cliente c) throws Exception {
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
            System.err.println("erro " + ex);
        }
        return null;
    }

    @Override
    public List<Cliente> listarCliente() throws Exception {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            Query query = (Query) em.createQuery("SELECT c FROM Cliente c");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_LISTAR));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Cliente> getAllCriteria() throws Exception {
        List<Cliente> resultado = null;
        try {
            Criteria crit = getCriteria();
            return crit.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }

    @Override
    public Criteria getCriteria() {
        em = JPAUtil.getEntityManager();
        session = ((Session) em.getDelegate());
        return session.createCriteria(Cliente.class);
    }

    @Override
    public List<Cliente> buscarClienteCriteriaNome(String nome) throws Exception {
         try {
            Criteria crit = getCriteria();
            crit.add(Restrictions.isNotNull("nome"));
            return crit.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }

}
