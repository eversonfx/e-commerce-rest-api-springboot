package com.everson.cursomc.repositories;

import com.everson.cursomc.domain.Categoria;
import com.everson.cursomc.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *  JpaRepository é um tipo especial do Spring capaz de acessar os dados com
 *  base em um tipo que passamos (Produto) e o seu atributo identificador(id)
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    /*
     *   @Query - Com essa anotação e possivel passar a query no formato JPQL e
     *      o Spring faz um metodo de retorno automaticamente
     *
     */
    @Transactional(readOnly = true)
    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
    //Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
