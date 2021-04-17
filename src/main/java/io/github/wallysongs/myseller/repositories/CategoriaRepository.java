package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
