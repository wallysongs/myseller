package io.github.wallysongs.myseller.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.entities.Categoria;
import io.github.wallysongs.myseller.repositories.CategoriaRepository;
import io.github.wallysongs.myseller.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPeloId(Long id) {
        Optional<Categoria> categoria  = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
