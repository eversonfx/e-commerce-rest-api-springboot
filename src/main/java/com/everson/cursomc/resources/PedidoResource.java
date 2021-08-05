package com.everson.cursomc.resources;

import com.everson.cursomc.domain.Pedido;
import com.everson.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService service;
    /*
        PathVariable - Indica ao Spring que o id referenciado
        virá através da URL identificado com {id}

        Reponse Entity -  É um tipo especial do Spring que encapsula(armazena)
        várias informações de uma reposta Http para um serviço Rest
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id) {
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
