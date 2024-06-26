package br.com.ocorteiz.comex;

import br.com.ocorteiz.comex.model.Categoria;
import br.com.ocorteiz.comex.model.CategoriaDTO;
import br.com.ocorteiz.comex.service.CategoriaService;
import br.com.ocorteiz.comex.util.JpaUTIL;

import javax.persistence.EntityManager;
import java.util.List;

public class TestCategoria {

    public static void main(String[] args) {
        testeSaveCategoria();
        testeDeleteCategoria();
    }

    public static void testeSaveCategoria(){
        EntityManager em = JpaUTIL.getEntityManager();

        CategoriaDTO dadosCategoria1 = new CategoriaDTO(null,"Informartica", "62219920364");
        CategoriaDTO dadosCategoria2 = new CategoriaDTO(null,"Eletrodomestico", "99988811123");

        CategoriaService categoriaService = new CategoriaService(em);

        em.getTransaction().begin();

        categoriaService.save(dadosCategoria1);
        categoriaService.save(dadosCategoria2);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeListCategoria(){
        EntityManager em = JpaUTIL.getEntityManager();
        CategoriaService categoriaService = new CategoriaService(em);
        List<Categoria> categorias = categoriaService.list();
        categorias.forEach(System.out::println);
    }

    public static void testeShowCategoria(){
        EntityManager em = JpaUTIL.getEntityManager();

        CategoriaService categoriaService = new CategoriaService(em);

        Categoria categoria = categoriaService.show(1L);
        System.out.println(categoria.toString());
    }

    public static void testeUpdateCategoria(){
        EntityManager em = JpaUTIL.getEntityManager();

        CategoriaService categoriaService = new CategoriaService(em);

        CategoriaDTO dadosCategoria = new CategoriaDTO(1L,"Jardim", "62219920364");

        em.getTransaction().begin();

        categoriaService.update(dadosCategoria);

        em.getTransaction().commit();
        em.close();
    }

    public static void testeDeleteCategoria(){
        EntityManager em = JpaUTIL.getEntityManager();

        CategoriaService categoriaService = new CategoriaService(em);

        em.getTransaction().begin();

        categoriaService.delete(2L);

        em.getTransaction().commit();
        em.close();
    }

}
