package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
