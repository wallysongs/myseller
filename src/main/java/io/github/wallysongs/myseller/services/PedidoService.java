package io.github.wallysongs.myseller.services;

import java.util.List;

import io.github.wallysongs.myseller.domain.Pedido;

public interface PedidoService {
    
    public Pedido buscar(Long id);

    public List<Pedido> buscarTodos();
}
