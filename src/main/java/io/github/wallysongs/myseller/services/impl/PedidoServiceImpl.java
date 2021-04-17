package io.github.wallysongs.myseller.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.domain.Pedido;
import io.github.wallysongs.myseller.repositories.PedidoRepository;
import io.github.wallysongs.myseller.services.PedidoService;
import io.github.wallysongs.myseller.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Cliente não encontrado!");
        });
    }

    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }
}
