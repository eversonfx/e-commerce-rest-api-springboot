package com.everson.cursomc.services;

import com.everson.cursomc.domain.Cliente;
import com.everson.cursomc.repositories.ClienteRepository;
import com.everson.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    /*
        Autowired -> Essa dependencia será automaticamente instanciada pelo Spring, atra-
        vés do mecanismo de injeção de dependência ou inversão de controle
    */
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
    }
}
