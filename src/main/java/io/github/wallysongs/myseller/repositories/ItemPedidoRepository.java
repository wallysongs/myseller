package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
}
