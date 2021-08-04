package com.everson.cursomc.services;

import com.everson.cursomc.domain.Categoria;
import com.everson.cursomc.services.exceptions.ObjectNotFoundException;
import com.everson.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Service
public class CategoriaService {
    /*
        Autowired -> Essa dependencia será automaticamente instanciada pelo Spring, atra-
        vés do mecanismo de injeção de dependência ou inversão de controle
    */
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
