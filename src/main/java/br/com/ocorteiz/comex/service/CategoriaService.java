package br.com.ocorteiz.comex.service;

import br.com.ocorteiz.comex.dao.CategoriaDAO;
import br.com.ocorteiz.comex.dao.ClienteDAO;
import br.com.ocorteiz.comex.model.Categoria;
import br.com.ocorteiz.comex.model.CategoriaDTO;
import br.com.ocorteiz.comex.model.Cliente;
import br.com.ocorteiz.comex.model.ClienteDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaService {

   private final CategoriaDAO categoriaDAO;

   public CategoriaService(EntityManager em) {
       this.categoriaDAO = new CategoriaDAO(em);
   }

   public void save(CategoriaDTO dadosCategoria){
       Categoria categoria = new Categoria(dadosCategoria);
       categoriaDAO.save(categoria);
   }

   public List<Categoria> list() {
       return categoriaDAO.list();
   }

   public Categoria show(Long id){
       return categoriaDAO.show(id);
   }

   public void update(CategoriaDTO dadosCategoria){
       Categoria categoria = new Categoria(dadosCategoria);
       categoriaDAO.update(categoria);
   }

   public void delete(Long id){
       categoriaDAO.delete(id);
   }
}
