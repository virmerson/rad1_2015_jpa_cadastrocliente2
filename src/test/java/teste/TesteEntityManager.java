/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import br.com.larimaia.cadastrocliente.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jboss.jandex.Main;

/**
 *
 * @author rf3020
 */
public class TesteEntityManager {
    
   public static void main(String args[]){
       //Ler o persistence.xml
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("lari");
       //Criano EntityManager
       EntityManager em = emf.createEntityManager();
       
       
       Cliente ze = new Cliente();
       ze.setNome("Zé");
       
       em.getTransaction().begin();
       em.persist(ze);
       em.getTransaction().commit();
   }
}
