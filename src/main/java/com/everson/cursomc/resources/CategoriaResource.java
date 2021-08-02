package com.everson.cursomc.resources;

import com.everson.cursomc.domain.Categoria;
import com.everson.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;
    /*
        PathVariable - Indica ao Spring que o id referenciado
        virá através da URL identificado com {id}

        Reponse Entity -  É um tipo especial do Spring que encapsula(armazena)
        várias informações de uma reposta Http para um serviço Rest
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
