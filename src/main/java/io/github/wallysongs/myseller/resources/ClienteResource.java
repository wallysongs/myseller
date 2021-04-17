package io.github.wallysongs.myseller.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wallysongs.myseller.domain.Cliente;
import io.github.wallysongs.myseller.services.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteResource {

    private ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPeloId(id);
        return ResponseEntity.ok(cliente);
    }
}
