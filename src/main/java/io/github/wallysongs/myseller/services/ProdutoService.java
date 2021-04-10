package io.github.wallysongs.myseller.services;

import java.util.List;

import io.github.wallysongs.myseller.entities.Produto;

public interface  ProdutoService {
    
    public Produto buscarPeloId(Long id);

    public List<Produto> buscarTodos();
}
