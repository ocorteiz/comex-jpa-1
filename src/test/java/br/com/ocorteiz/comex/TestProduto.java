package br.com.ocorteiz.comex;

import br.com.ocorteiz.comex.model.Categoria;
import br.com.ocorteiz.comex.model.CategoriaDTO;
import br.com.ocorteiz.comex.model.Produto;
import br.com.ocorteiz.comex.model.ProdutoDTO;
import br.com.ocorteiz.comex.service.CategoriaService;
import br.com.ocorteiz.comex.service.ProdutoService;
import br.com.ocorteiz.comex.util.JpaUTIL;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class TestProduto {

    public static void main(String[] args) {
        testeSaveProduto();
        testeDeleteProduto();
        testeListProduto();
    }

    public static void testeSaveProduto(){
        EntityManager em = JpaUTIL.getEntityManager();

        CategoriaDTO dadosCategoria1 = new CategoriaDTO(null,"Informartica", "62219920364");
        CategoriaDTO dadosCategoria2 = new CategoriaDTO(null,"Eletrodomestico", "99988811123");
        CategoriaService categoriaService = new CategoriaService(em);

        ProdutoDTO produto1 = new ProdutoDTO(null, "Iphone 12 Plus", new BigDecimal("2000"));
        ProdutoDTO produto2 = new ProdutoDTO(null, "Geladeira Electrolux", new BigDecimal("4000"));
        ProdutoService produtoService = new ProdutoService(em);

        em.getTransaction().begin();

        categoriaService.save(dadosCategoria1);
        categoriaService.save(dadosCategoria2);

        Categoria categoria1 = categoriaService.show(1L);
        Categoria categoria2 = categoriaService.show(2L);

        produtoService.save(produto1, categoria1);
        produtoService.save(produto2, categoria2);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeListProduto(){
        EntityManager em = JpaUTIL.getEntityManager();
        ProdutoService produtoService = new ProdutoService(em);
        List<Produto> produtos = produtoService.list();
        produtos.forEach(System.out::println);
    }

    public static void testeShowProduto(){
        EntityManager em = JpaUTIL.getEntityManager();

        ProdutoService produtoService = new ProdutoService(em);

        Produto produto = produtoService.show(1L);
        System.out.println(produto.toString());
    }

    public static void testeUpdateProduto(){
        EntityManager em = JpaUTIL.getEntityManager();

        ProdutoService produtoService = new ProdutoService(em);

        ProdutoDTO dadosProduto = new ProdutoDTO(1L,"Samsung S20", null);

        em.getTransaction().begin();

        produtoService.update(dadosProduto, null);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeDeleteProduto(){
        EntityManager em = JpaUTIL.getEntityManager();

        ProdutoService produtoService = new ProdutoService(em);

        em.getTransaction().begin();

        produtoService.delete(2L);

        em.getTransaction().commit();
        em.close();
    }

}
