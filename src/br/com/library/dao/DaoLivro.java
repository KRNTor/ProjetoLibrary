/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.library.dao;

import br.com.library.model.Livro;
import br.com.library.util.JPAUtil;
import br.com.library.util.StringUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Felps
 */
public class DaoLivro implements IDaoLivro {

    private EntityManager em;
    private Class clazz;
    private Session session;

    @Override
    public void salvar(Livro livro) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Livro buscar(String titulo) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo");
            query.setParameter("titulo", titulo);
            return (Livro) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Livro buscarById(long id) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l WHERE l.id = :id");
            query.setParameter("id", id);
            return (Livro) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void editar(Livro livro) throws Exception {//DONE

        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            livro.setAno(livro.getAno());
            livro.setAutor(livro.getAutor());
            livro.setCategoria(livro.getCategoria());
            livro.setEditora(livro.getEditora());
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    /*
    * ALTERANDO OO STATUS DO LIVRO PARA FALSE
     */
    @Override
    public void remover(Livro livro) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            livro.setStatus(false);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Livro> listarAll() throws Exception {
        List<Livro> lista = null;

        try {

            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l");
            lista = query.getResultList();
            JPAUtil.close();
            return lista;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Livro> getCriteriaAutor(String autor) throws Exception {
        List<Livro> resultado = null;
        try {
            Criteria crit = getCriteria();
            crit.add(Restrictions.isNotNull("autor"));
            return crit.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }

    @Override
    public Criteria getCriteria() throws Exception {
        em = JPAUtil.getEntityManager();
        session = ((Session) em.getDelegate());
        return session.createCriteria(Livro.class);
    }

    @Override
    public List<Livro> listarNamed() throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNamedQuery("Livro.listarTudo");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_LISTAR));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Livro buscarNamed(String autor) throws Exception {
       try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNamedQuery("Livro.buscarAutor");                    
                    return (Livro) query.setParameter("autor", autor).getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_LISTAR));
        } finally {
            JPAUtil.close();
        }
    }
}
