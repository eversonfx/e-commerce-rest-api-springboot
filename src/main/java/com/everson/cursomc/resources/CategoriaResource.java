package com.everson.cursomc.resources;

import com.everson.cursomc.domain.Categoria;
import com.everson.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    /*
        @RequestBody - Faz que o Json seja convertido em um objeto
        Java automaticamente
     */
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
       obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
