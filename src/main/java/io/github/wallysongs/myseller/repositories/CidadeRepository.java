package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
}
