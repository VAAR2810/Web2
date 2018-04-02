/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.dao;

import br.com.w2.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author VAAR
 */
public class LivroDAO implements ILivroDAO {

    @Override
    public void salvar(Livro li) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(li);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("ERRO ao Salvar");
        } finally {
            em.close();
        }
    }
    
    @Override
    public Livro buscar(long id) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            return em.find(Livro.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO ao buscar");
        } finally {
            em.close();
        }
    }
    
    @Override
    public void editar(Livro li) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(li);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("ERRo ao Editar");
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Livro> listar() throws Exception {
       EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            Query q = em.createQuery("SELECT li FROM Livro li");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO ao listar");
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Livro li) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            li = em.merge(li);
            em.remove(li);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Erro ao excluir livro!");
        } finally {
            em.close();
        }
    }
}
