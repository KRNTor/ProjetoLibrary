package br.com.library.dao;

import br.com.library.model.Funcionario;
import br.com.library.util.JPAUtil;
import br.com.library.util.StringUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Otto
 */
public class DaoFuncionario implements IDaoFuncionario {

    @Override
    public void cadastrarFuncionario(Funcionario f) throws Exception {

        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.persist(f);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_CADASTRAR));

        } finally {

            JPAUtil.close();

        }
    }

    @Override
    public void deletarFuncionario(Funcionario f) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.remove(f);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_DELETAR));

        } finally {

            JPAUtil.close();

        }
    }

    @Override
    public void editarFuncionario(Funcionario f) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            em.getTransaction().begin();

            em.merge(f);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

            em.getTransaction().rollback();

            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_EDITAR));

        } finally {

            JPAUtil.close();

        }
    }

    @Override
    public Funcionario buscarFuncionario(long id) throws Exception {
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            return em.find(Funcionario.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_BUSCAR));

        } finally {

            JPAUtil.close();

        }
    }

    @Override
    public List<Funcionario> listaFuncionario() throws Exception {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            Query query = (Query) em.createQuery("SELECT f FROM Funcionario f");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringUtil.getStringValue(StringUtil.KEY_MSG_ERRO_LISTAR));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Funcionario buscarFuncionarioNome(String nome) throws Exception {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT f FROM Funcionaio f WHERE f.nome = :nome");
            query.setParameter("nome", nome);
            return (Funcionario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Funcionario> listaFuncionarioNameQuared() throws Exception {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNamedQuery("Funcionario.listarAll");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JPAUtil.close();
        }
        return null;
    }
}
