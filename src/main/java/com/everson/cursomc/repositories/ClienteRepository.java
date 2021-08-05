package com.everson.cursomc.repositories;

import com.everson.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
    JpaRepository é um tipo especial do Spring capaz de acessar os dados com
    base em um tipo que passamos (Cliente) e o seu atributo identificador(id)
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);

}
