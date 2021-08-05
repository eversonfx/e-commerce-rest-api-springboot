package com.everson.cursomc.services;

import com.everson.cursomc.domain.Pedido;
import com.everson.cursomc.repositories.PedidoRepository;
import com.everson.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    /*
        Autowired -> Essa dependencia será automaticamente instanciada pelo Spring, atra-
        vés do mecanismo de injeção de dependência ou inversão de controle
    */
    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Pedido.class.getName()));
    }
}
