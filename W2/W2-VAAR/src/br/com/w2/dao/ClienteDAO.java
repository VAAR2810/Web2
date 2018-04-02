/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.dao;

import br.com.w2.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author VAAR
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public void salvar(Cliente c) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
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
    public Cliente buscar(long id) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            return em.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO ao buscar");
        } finally {
            em.close();
        }
    }
    
    @Override
    public void editar(Cliente c) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("ERRO ao Editar");
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Cliente> listar() throws Exception {
       EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            Query q = em.createQuery("SELECT c FROM Cliente c");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao Listar");
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Cliente c) throws Exception {
        EntityManager em = null;
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            c = em.merge(c);
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Erro ao excuir");
        } finally {
            em.close();
        }
    }
}
