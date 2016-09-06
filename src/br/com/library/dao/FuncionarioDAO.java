package br.com.library.dao;

import br.com.library.interfaces.IFuncionarioDao;
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
public class FuncionarioDAO implements IFuncionarioDao {

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
        List<Funcionario> lista = null;
        EntityManager em = null;

        try {

            em = JPAUtil.getEntityManager();

            Query query = (Query) em.createQuery("SELECT f FROM Funcionario f");

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

}