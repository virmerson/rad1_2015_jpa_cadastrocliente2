/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.larimaia.cadastrocliente;

import br.com.larimaia.cadastrocliente.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Virmerson
 */
public class ClienteDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDAO() {
        //Ler o persistence.xml
        emf = Persistence.createEntityManagerFactory("lari");
        //Criano EntityManager
        em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(cliente);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public Cliente buscarPorId(Integer id) {

        return em.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Cliente c");
        return consulta.getResultList();
    }

    public void excluir(Cliente cliente) {
        //
        
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(cliente);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }

}
