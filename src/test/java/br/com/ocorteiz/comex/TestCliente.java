package br.com.ocorteiz.comex;

import br.com.ocorteiz.comex.dao.ClienteDAO;
import br.com.ocorteiz.comex.model.Cliente;
import br.com.ocorteiz.comex.model.ClienteDTO;
import br.com.ocorteiz.comex.service.ClienteService;
import br.com.ocorteiz.comex.util.JpaUTIL;

import javax.persistence.EntityManager;
import java.util.List;

public class TestCliente {

    public static void main(String[] args) {
        testeSaveCliente();
        testeDeleteCliente();
    }

    public static void testeSaveCliente(){
        EntityManager em = JpaUTIL.getEntityManager();

        ClienteDTO dadosCliente1 = new ClienteDTO(null,"Luis Cortez", "62219920364","luis@cortez.com");
        ClienteDTO dadosCliente2 = new ClienteDTO(null,"Felipe Almeida", "99988811123","felipe@almeida.com");

        ClienteService clienteService = new ClienteService(em);

        em.getTransaction().begin();

        clienteService.save(dadosCliente1);
        clienteService.save(dadosCliente2);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeListCliente(){
        EntityManager em = JpaUTIL.getEntityManager();
        ClienteService clienteService = new ClienteService(em);
        List<Cliente> clientes = clienteService.list();
        clientes.forEach(System.out::println);
    }

    public static void testeShowCliente(){
        EntityManager em = JpaUTIL.getEntityManager();

        ClienteService clienteService = new ClienteService(em);

        Cliente cliente = clienteService.show(1L);
        System.out.println(cliente.toString());
    }

    public static void testeUpdateCliente(){
        EntityManager em = JpaUTIL.getEntityManager();

        ClienteService clienteService = new ClienteService(em);

        ClienteDTO dadosCliente = new ClienteDTO(1L,"Silva", "62219920364",null);

        em.getTransaction().begin();

        clienteService.update(dadosCliente);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeDeleteCliente(){
        EntityManager em = JpaUTIL.getEntityManager();

        ClienteService clienteService = new ClienteService(em);

        em.getTransaction().begin();

        clienteService.delete(2L);

        em.getTransaction().commit();
        em.close();
    }

}