package br.com.ocorteiz.comex.service;

import br.com.ocorteiz.comex.dao.ClienteDAO;
import br.com.ocorteiz.comex.model.Cliente;
import br.com.ocorteiz.comex.model.ClienteDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteService {

   private final ClienteDAO clienteDAO;

   public ClienteService(EntityManager em) {
       this.clienteDAO = new ClienteDAO(em);
   }

   public void save(ClienteDTO dadosCliente){
       Cliente cliente = new Cliente(dadosCliente);
       clienteDAO.save(cliente);
   }

   public List<Cliente> list() {
       return clienteDAO.list();
   }

   public Cliente show(Long id){
       return clienteDAO.show(id);
   }

   public void update(ClienteDTO dadosCliente){
       Cliente cliente = new Cliente(dadosCliente);
       clienteDAO.update(cliente);
   }

   public void delete(Long id){
       clienteDAO.delete(id);
   }
}
