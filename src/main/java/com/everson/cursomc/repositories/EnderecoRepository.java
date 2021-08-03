package com.everson.cursomc.repositories;

import com.everson.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    JpaRepository é um tipo especial do Spring capaz de acessar os dados com
    base em um tipo que passamos (Endereco) e o seu atributo identificador(id)
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
