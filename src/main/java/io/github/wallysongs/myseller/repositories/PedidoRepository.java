package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
