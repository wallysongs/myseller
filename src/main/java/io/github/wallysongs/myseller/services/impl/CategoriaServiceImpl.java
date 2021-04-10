package io.github.wallysongs.myseller.services.impl;

import java.util.List;

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
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
