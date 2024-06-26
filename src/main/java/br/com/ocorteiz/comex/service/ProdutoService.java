package br.com.ocorteiz.comex.service;

import br.com.ocorteiz.comex.dao.ClienteDAO;
import br.com.ocorteiz.comex.dao.ProdutoDAO;
import br.com.ocorteiz.comex.model.*;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoService {

   private final ProdutoDAO produtoDAO;

   public ProdutoService(EntityManager em) {
       this.produtoDAO = new ProdutoDAO(em);
   }

   public void save(ProdutoDTO dadosProduto, Categoria categoria){
       Produto produto = new Produto(dadosProduto, categoria);
       produtoDAO.save(produto);
   }

   public List<Produto> list() {
       return produtoDAO.list();
   }

   public Produto show(Long id){
       return produtoDAO.show(id);
   }

   public void update(ProdutoDTO dadosProduto, Categoria categoria){
       Produto produto = new Produto(dadosProduto, categoria);
       produtoDAO.update(produto);
   }

   public void delete(Long id){
       produtoDAO.delete(id);
   }
}
