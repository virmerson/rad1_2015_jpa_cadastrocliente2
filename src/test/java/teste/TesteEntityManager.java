/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.larimaia.cadastrocliente.ClienteDAO;
import br.com.larimaia.cadastrocliente.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Virmerson
 */
public class TesteEntityManager {

    public static void main(String args[]) {

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cli = cliDAO.buscarPorId(261);
        //cliDAO.salvar(cli);
      //  cliDAO.excluir(cli);

        List<Cliente> lista =  cliDAO.buscarTodos();
        for(Cliente c:lista){
            System.out.println(c.getId() + " "+ c.getFone());
        }
        
    }

    public void testVersao1() {
        //Ler o persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lari");
        //Criano EntityManager
        EntityManager em = emf.createEntityManager();

        Cliente ze = new Cliente();
        ze.setNome("Pedro");

        em.getTransaction().begin();
        em.persist(ze);
        em.getTransaction().commit();
    }

}
