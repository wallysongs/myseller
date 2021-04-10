package io.github.wallysongs.myseller.services;

import java.util.List;

import io.github.wallysongs.myseller.entities.Categoria;

public interface CategoriaService {
    
    public List<Categoria> buscarTodos();

    public Categoria buscarPeloId(Long id);
}
