package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
