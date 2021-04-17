package io.github.wallysongs.myseller.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.domain.Categoria;
import io.github.wallysongs.myseller.repositories.CategoriaRepository;
import io.github.wallysongs.myseller.services.CategoriaService;
import io.github.wallysongs.myseller.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPeloId(Long id) {
        return this.categoriaRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        });
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
