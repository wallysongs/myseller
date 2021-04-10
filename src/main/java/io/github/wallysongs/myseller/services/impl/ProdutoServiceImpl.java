package io.github.wallysongs.myseller.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.entities.Produto;
import io.github.wallysongs.myseller.repositories.ProdutoRepository;
import io.github.wallysongs.myseller.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto buscarPeloId(Long id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> buscarTodos() {
        return this.produtoRepository.findAll();
    }
}
