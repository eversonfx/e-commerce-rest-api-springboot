package com.everson.cursomc.repositories;

import com.everson.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    JpaRepository é um tipo especial do Spring capaz de acessar os dados com
    base em um tipo que passamos (Pedido) e o seu atributo identificador(id)
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
