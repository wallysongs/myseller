package io.github.wallysongs.myseller.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wallysongs.myseller.domain.Pedido;
import io.github.wallysongs.myseller.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoResource {

    private PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscar(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }
}
